
package app.controller;

import app.model.Factura;
import app.model.Ventas;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import app.util.Conexion;
import java.util.ArrayList;

/**
 *
 * @author Alfonso
 */
public class FacturaDaoImp implements FacturaDao{

    @Override
    public void GuardarFactura(Factura factura) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "INSERT INTO facturas (id_venta, nombre, apellido_paterno, apellido_materno, rfc, razon_social, direccion_fiscal, total) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, factura.getId_venta());
            ps.setString(2, factura.getNombre());
            ps.setString(3, factura.getApellido_paterno());
            ps.setString(4, factura.getApellido_materno());
            ps.setString(5, factura.getRfc());
            ps.setString(6, factura.getRazon_social());
            ps.setString(7, factura.getDireccion_fiscal());
            ps.setDouble(8, factura.getTotal());
            
            ps.executeUpdate();
            
            ps.close();
            JOptionPane.showMessageDialog(null, "Factura guardada con exito");
            
        } catch (Exception e) {
            System.out.println("Error:" +e);
        }
    }

    @Override
    public void EliminarFactura(int id_factura) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM facturas WHERE id_factura = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id_factura);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR FACTURA "+e);
        }
    }

    @Override
    public void ModificarFactura(Factura factura, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE facturas SET "
                    + "id_venta = ?, "
                    + "nombre = ?, "
                    + "apellido_paterno = ?, "
                    + "apellido_materno = ?, "
                    + "rfc = ?, "
                    + "razon_social = ?, "
                    + "direccion_fiscal = ?, "
                    + "total = ? "
                    + "WHERE id_factura = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, factura.getId_venta());
            ps.setString(2, factura.getNombre());
            ps.setString(3, factura.getApellido_paterno());
            ps.setString(4, factura.getApellido_materno());
            ps.setString(5, factura.getRfc());
            ps.setString(6, factura.getRazon_social());
            ps.setString(7, factura.getDireccion_fiscal());
            ps.setDouble(8, factura.getTotal());
            ps.setInt(9, id);
            ps.executeUpdate();
            
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Factura Modificada con exito");
            
        } catch (Exception e) {
        }
    }

    @Override
    public Factura ConsultarFactura(int id) {
        Factura fac = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT * FROM facturas WHERE id_factura = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                fac = new Factura(rs.getInt("id_factura"),
                        rs.getInt("id_venta"),
                        rs.getString("nombre"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getString("rfc"),
                        rs.getString("razon_social"),
                        rs.getString("direccion_fiscal"), 
                        rs.getDouble("total"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return fac;
    }

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try {
            Connection con = Conexion.getConexion();
            String query = "select * FROM facturas";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error al contruir tabla. " + e);
        }
    }

    @Override
    public ArrayList<String> Ventas() {
        ArrayList<String> ListaProveedores = new ArrayList<>();
        Ventas ventas = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT id_venta FROM ventas";
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ventas = new Ventas(rs.getInt("id_venta"));
                ListaProveedores.add(ventas.getId_venta()+"");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return ListaProveedores;
    }

    @Override
    public Double regresarTotal(int idVenta) {
        Double total = 0.0;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT total FROM VENTAS WHERE id_venta = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idVenta);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                total = rs.getDouble("total");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return total;
    }
    
    
}
