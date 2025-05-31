
package app.controller;

import app.model.Producto;
import app.util.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
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
            String query = "INSERT INTO productos (nombre, descripcion,precio,stock, fecha_registro, id_proveedor, id_categoria)  ";
        } catch (Exception e) {
        }
    }

    @Override
    public void EliminarProducto(Producto id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ModificarProducto(Producto producto, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto ConsultarProducto(Producto id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
