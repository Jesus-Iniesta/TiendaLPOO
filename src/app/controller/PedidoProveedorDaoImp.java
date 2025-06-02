package app.controller;

import app.model.PedidoProveedor;

import app.util.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfonso
 */
public class PedidoProveedorDaoImp implements PedidoProveedorDao {

    @Override
    public void GuardarPedido(PedidoProveedor pedido) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "INSERT INTO pedidos_proveedor (id_proveedor,"
                    + " fecha_pedido,"
                    + " fecha_entrega_estimada,"
                    + " estado_pedido,"
                    + " producto_solicitado,"
                    + " cantidad,"
                    + " precio_unitario,"
                    + " observaciones) "
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, pedido.getId_proveedor());
            ps.setDate(2, (Date) pedido.getFecha_pedido());
            ps.setDate(3, (Date) pedido.getFecha_entrega_estimada());
            ps.setString(4, pedido.getEstado_pedido());
            ps.setString(5, pedido.getProducto_solicitado());
            ps.setInt(6, pedido.getCantidad());
            ps.setDouble(7, pedido.getPrecio_unitario());
            ps.setString(8, pedido.getObservaciones());

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pedido guardado correctamente!!");
        } catch (Exception e) {
            System.out.println("Error al guardar pedido: " + e);
        }
    }

    @Override
    public void EliminarPedido(int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM pedidos_proveedor WHERE id_pedido = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pedido Eliminado con éxito!!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void ModificarPedido(PedidoProveedor pedido, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE pedidos_proveedor SET id_proveedor = ?,"
                    + " fecha_pedido = ?,"
                    + " fecha_entrega_estimada = ?,"
                    + " estado_pedido = ?,"
                    + " producto_solicitado = ?,"
                    + " cantidad = ?,"
                    + " precio_unitario = ?,"
                    + " observaciones = ? WHERE id_pedido = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, pedido.getId_proveedor());
            ps.setDate(2, (Date) pedido.getFecha_pedido());
            ps.setDate(3, (Date) pedido.getFecha_entrega_estimada());
            ps.setString(4, pedido.getEstado_pedido());
            ps.setString(5, pedido.getProducto_solicitado());
            ps.setInt(6, pedido.getCantidad());
            ps.setDouble(7, pedido.getPrecio_unitario());
            ps.setString(8, pedido.getObservaciones());
            ps.executeUpdate();

            ps.close();
            JOptionPane.showMessageDialog(null, "Producto Modificado con éxito!!");
        } catch (Exception e) {
        }
    }

    @Override
    public PedidoProveedor ConsultarPedido(int id) {
        PedidoProveedor pedido = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT * FROM pedidos_proveedor WHERE id_pedido = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pedido = new PedidoProveedor(rs.getInt("id_proveedor"),
                        rs.getDate("fecha_pedido"),
                        rs.getDate("fecha_entrega_estimada"),
                        rs.getString("estado_pedido"),
                        rs.getString("producto_solicitado"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_unitario"),
                        rs.getString("observaciones"));
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
        }
        return pedido;
    }

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try {
            Connection con = Conexion.getConexion();
            String query = "select * FROM pedidos_proveedor";
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
