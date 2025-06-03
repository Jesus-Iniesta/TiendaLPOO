
package app.controller;

import app.model.Categoria;
import app.model.Producto;
import app.model.Proveedor;
import app.util.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
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

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try {
            Connection con = Conexion.getConexion();
            String query = "select * FROM productos";
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
    public ArrayList<String> ProveedoresList() {
        ArrayList<String> ListaProveedores = new ArrayList<>();
        Proveedor proveedor = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT id_proveedor, nombre, apellido_paterno, empresa FROM proveedores";
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proveedor = new Proveedor(rs.getInt("id_proveedor"),rs.getString("nombre"), rs.getString("apellido_paterno"), rs.getString("empresa"));
                ListaProveedores.add(proveedor.getId_proveedor()+" "+proveedor.getNombre()+" " + proveedor.getApellido_paterno()+ " " + proveedor.getEmpresa());
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return ListaProveedores;
    }

    @Override
    public ArrayList<String> CategoriaList() {
        ArrayList<String> ListaCategorias = new ArrayList<>();
        Categoria cat = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT id_categoria, nombre_categoria FROM categorias";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cat = new Categoria(rs.getInt("id_categoria"), rs.getString("nombre_categoria"));
                ListaCategorias.add(cat.getId_categoria()+" "+cat.getNombre_categorial());
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
        }
        return ListaCategorias;
    }

    @Override
    public String ConsultarProveedor(int id) {
        String item = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT id_proveedor, nombre, empresa FROM proveedores WHERE id_proveedor = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                item = rs.getInt("id_proveedor")+" "+rs.getString("nombre")+" "+rs.getString("empresa");
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al consultar Proveedor "+e);
        }
        return item;
    }

    @Override
    public String ConsultarCategoria(int id) {
        String item = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT id_categoria, nombre_categoria FROM categorias WHERE id_categoria = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                item = rs.getInt("id_categoria")+" "+rs.getString("nombre_categoria");
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return item;
    }
    
}
