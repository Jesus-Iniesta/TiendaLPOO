
package app.controller;


import app.model.Ventas;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import app.util.Conexion;

/**
 *
 * @author Alfonso
 */
public class VentaDAOImp implements VentaDao{

    @Override
    public void GuardarVenta(Ventas venta) {
        
        try {
            Connection conn = Conexion.getConexion();
            if(venta.getId_cliente() > 0){
                String query = "INSERT INTO ventas (id_cliente, total) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, venta.getId_cliente());
                ps.setDouble(2, venta.getTotal());
                
                
                JOptionPane.showMessageDialog(null, "Venta con exito");
                ps.executeUpdate();
                ps.close();
            }else{
                String query = "INSERT INTO ventas (total) VALUES (?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setDouble(1, venta.getTotal());
                
                JOptionPane.showMessageDialog(null, "Venta con exito");
                ps.executeUpdate();
                ps.close();
            }
            
        } catch (Exception e) {
        }
    }

    @Override
    public void EliminarVenta(int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM ventas WHERE id_venta = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venta eliminada con exito");
        } catch (Exception e) {
        }
    }

    @Override
    public Ventas ConsultarVenta(int id) {
        Ventas venta = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT * FROM ventas WHERE id_venta = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
               
                venta = new Ventas(
                    rs.getInt("id_cliente"),
                    rs.getDouble("total")
                );
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return venta;
    }

    @Override
    public void ModificarVentas(Ventas venta, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE ventas SET "
                    + "id_proveedor = ?, "
                    + "total = ? "
                    + "WHERE id_venta = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, venta.getId_cliente());
            ps.setDouble(2, venta.getTotal());
            ps.setInt(3, id);
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Venta Modificada con exito");
        } catch (Exception e) {
        }
    }

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try {
            Connection con = Conexion.getConexion();
            String query = "select * FROM venta";
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
    public int DevolverIdVenta() {
        int id_venta = 0;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT LAST_INSERT_ID() AS id_venta";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id_venta = rs.getInt("id_venta");
            }
            rs.close();
        } catch (Exception e) {
        }
        return id_venta;
    }

    
}
