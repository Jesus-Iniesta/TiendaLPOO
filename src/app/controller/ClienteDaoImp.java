
package app.controller;

import app.model.Cliente;
import javax.swing.table.DefaultTableModel;
import app.util.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author pigim
 */
public class ClienteDaoImp implements ClienteDao{

    @Override
    public void RegistroCliente(Cliente datos) {
        try {
          Connection conn = Conexion.getConexion();
          String query = "INSERT INTO clientes (nombre, apellido_paterno, telefono, calle, colonia, ciudad, codigo_postal, rfc) values(?,?,?,?,?,?,?,?)";
          PreparedStatement ps = conn.prepareStatement(query);
          ps.setString(1, datos.getNombre());
          ps.setString(2, datos.getApellido_paterno());
          ps.setString(3, datos.getTelefono());
          ps.setString(4, datos.getCalle());
          ps.setString(5, datos.getColonia());
          ps.setString(6, datos.getCiudad());
          ps.setString(7, datos.getCp());
          ps.setString(8, datos.getRfc());
          
          
          ps.executeUpdate();
          ps.close();
          JOptionPane.showMessageDialog(null, "Cliente guardado con exito!!");
        } catch (Exception e) {
        }
    }

    @Override
    public void EliminarCliente(int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM clientes WHERE id_cliente = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cliente eliminado con exito!!");
        } catch (Exception e) {
        }
    }

    @Override
    public void ModificarCliente(Cliente datos, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE clientes SET nombre = ?, "
                    + "apellido_paterno = ?, "
                    + "telefono = ?, "
                    + "calle = ?, "
                    + "colonia = ?, "
                    + "ciudad = ?, "
                    + "codigo_postal = ?, "
                    + "rfc = ? "
                    + "WHERE id_cliente = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, datos.getNombre());
            ps.setString(2, datos.getApellido_paterno());
            ps.setString(3, datos.getTelefono());
            ps.setString(4, datos.getCalle());
            ps.setString(5, datos.getColonia());
            ps.setString(6, datos.getCiudad());
            ps.setString(7, datos.getCp());
            ps.setString(8, datos.getRfc());
            ps.setInt(9, id);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente modificado con exito!!");
            ps.close();
        } catch (Exception e) {
        }
    }

    @Override
    public Cliente ConsultarCliente(int id) {
        Cliente cl = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT * FROM clientes WHERE id_cliente = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cl = new Cliente(rs.getString("nombre"),
                        rs.getString("apellido_paterno"),
                        rs.getString("telefono"),
                        rs.getString("calle"),
                        rs.getString("colonia"),
                        rs.getString("ciudad"),
                        rs.getString("codigo_postal"),
                        rs.getString("rfc"));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl;
    }

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try {
            Connection con = Conexion.getConexion();
            String query = "select * FROM clientes";
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
    
}
