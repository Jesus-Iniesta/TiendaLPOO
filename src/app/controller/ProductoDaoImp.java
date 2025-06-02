
package app.controller;

import app.model.Producto;
import app.util.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
/**
 *
 * @author pigim
 */
public class ProductoDaoImp implements ProductoDao{

    @Override
    public void RegistrarProducto(Producto producto) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "INSERT INTO productos (nombre, descripcion,precio,stock, id_proveedor, id_categoria) values (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId_proveedor());
            ps.setInt(6, producto.getId_categoria());

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Producto registrado con éxito!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error, revisa los campos");
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void EliminarProducto(int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM productos WHERE id_producto = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
            JOptionPane.showMessageDialog(null, "Producto Eliminado con éxito!!");
        } catch (Exception e) {
        }
    }

    @Override
    public void ModificarProducto(Producto producto, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE productos SET nombre = ?, "
                    + "descripcion = ?, "
                    + "precio = ?, "
                    + "stock = ?, "
                    + "id_proveedor = ?, "
                    + "id_categoria = ? "
                    + "WHERE id_producto = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId_proveedor());
            ps.setInt(6, producto.getId_categoria());
            ps.setInt(7, id);
            ps.executeUpdate();

            ps.close();
            JOptionPane.showMessageDialog(null, "Producto Modificado con éxito!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modifcar, verifica los datos");
            System.out.println("Error: " + e);
        }
    }

    @Override
    public Producto ConsultarProducto(int id) {
        Producto producto = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "Select * FROM productos WHERE id_producto = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto(rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("id_proveedor"),
                        rs.getInt("id_categoria"));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error al consultar: " + e);
        }
        return producto;
    }
    
}
