
package app.controller;

import app.model.Proveedor;
import javax.swing.table.DefaultTableModel;
import app.util.Conexion;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;
/**
 *
 * @author Alfonso
 */
public class ProveedorDaoImp implements ProveedorDao{

    @Override
    public void GuardarProveedor(Proveedor proveedor) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "INSERT INTO proveedores (nombre, apellido_paterno, apellido_materno, empresa, telefono, direccion, correo, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getApellido_paterno());
            ps.setString(3, proveedor.getApellido_materno());
            ps.setString(4, proveedor.getEmpresa());
            ps.setString(5, proveedor.getTelefono());
            ps.setString(6, proveedor.getDireccion());
            ps.setString(7, proveedor.getCorreo());

            // Obtener solo la fecha del proveedor
            LocalDate fecha = proveedor.getFecha_registro(); // Ejemplo: 2025-05-31
            LocalTime horaActual = LocalTime.now();         // Ejemplo: 14:30:45
            LocalDateTime fechaHora = LocalDateTime.of(fecha, horaActual);
            Timestamp timestamp = Timestamp.valueOf(fechaHora);
            ps.setTimestamp(8, timestamp); // Simula CONCAT('2025-05-31', ' ', CURTIME())

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Proveedor guardado con exito!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void EliminarProveedor(int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM proveedores where id_proveedor = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Proveedor Eliminado con exito!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ModificarProveedor(Proveedor proveedor, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE proveedores SET nombre = ?, apellido_paterno = ?, "
                    + "apellido_materno = ?,"
                    + " empresa = ?,"
                    + " telefono = ?,"
                    + " direccion = ?,"
                    + " correo = ?,"
                    + " fecha_registro = ? "
                    + "WHERE id_proveedor = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getApellido_paterno());
            ps.setString(3, proveedor.getApellido_materno());
            ps.setString(4, proveedor.getEmpresa());
            ps.setString(5, proveedor.getTelefono());
            ps.setString(6, proveedor.getDireccion());
            ps.setString(7, proveedor.getCorreo());
            
            // Obtener solo la fecha del proveedor
            LocalDate fecha = proveedor.getFecha_registro(); // Ejemplo: 2025-05-31
            LocalTime horaActual = LocalTime.now();         // Ejemplo: 14:30:45
            LocalDateTime fechaHora = LocalDateTime.of(fecha, horaActual);
            Timestamp timestamp = Timestamp.valueOf(fechaHora);
            ps.setTimestamp(8, timestamp); // Simula CONCAT('2025-05-31', ' ', CURTIME())
            
            ps.setInt(9, id);
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Proveedor modificado con exito!!");
        } catch (Exception e) {
        }
    }

    @Override
    public Proveedor ConsultarProveedor(int id) {
        Proveedor proveedor = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT * FROM proveedores WHERE id_proveedor = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Timestamp timestamp = rs.getTimestamp("fecha_registro");
                LocalDate fechaRegistro = timestamp.toLocalDateTime().toLocalDate();
                
                proveedor = new Proveedor(rs.getString("nombre"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getString("empresa"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("correo"),
                        fechaRegistro);
                
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try {
            Connection con = Conexion.getConexion();
            String query = "select * FROM proveedores";
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
