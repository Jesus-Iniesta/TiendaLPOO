package app.controller;

import app.model.DetalleVenta;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import app.util.Conexion;

/**
 *
 * @author Alfonso
 */
public class DetalleVentaDaoImp implements DetalleVentaDao {

    @Override
    public void GuardarDetalle(DetalleVenta detalle) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, detalle.getId_venta());
            ps.setInt(2, detalle.getId_producto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecio_unitario());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dellates Guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar detalles, llena todos los campos");
            System.out.println("error detalle> " + e);
        }
    }

    @Override
    public void EliminarDetalle(int id_detalle) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM detalle_venta WHERE id_venta =  ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id_detalle);

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    @Override
    public void ModificarDetalle(DetalleVenta detalle, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE detalle_venta (id_producto, cantidad, precio_unitario) "
                    + "VALUES (?, ?, ?) WHERE id_venta = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, detalle.getId_producto());
            ps.setInt(2, detalle.getCantidad());
            ps.setDouble(3, detalle.getPrecio_unitario());
            ps.setInt(4, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Detalle modificado con exito");
        } catch (Exception e) {
        }
    }

    @Override
    public DetalleVenta ConsultarDetalle(int id) {
        DetalleVenta detalle = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT * FROM detalle_venta WHERE id_detalle = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalle = new DetalleVenta(rs.getInt("id_venta"), rs.getInt("id_producto"), rs.getInt("cantidad"), rs.getDouble("precio_unitario"), rs.getDouble("subtotal"));

            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error al consultar: " + e);
        }
        return detalle;
    }

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try {
            Connection con = Conexion.getConexion();
            String query = "select * FROM detalle_venta";
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

    public String consultarProducto(int id) {
        String producto = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT id_producto, nombre FROM productos WHERE id_producto = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto = rs.getInt("id_producto") + " " + rs.getString("nombre");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return producto;
    }

    public String consultarCliente(int idVenta) {
        String cliente = null;
        try {
            Connection conn = Conexion.getConexion();

            // 1. Buscar el id_cliente a partir del id_venta
            String queryVenta = "SELECT id_cliente FROM ventas WHERE id_venta = ?";
            PreparedStatement psVenta = conn.prepareStatement(queryVenta);
            psVenta.setInt(1, idVenta);
            ResultSet rsVenta = psVenta.executeQuery();

            int idCliente = -1;
            if (rsVenta.next()) {
                idCliente = rsVenta.getInt("id_cliente");
            }
            rsVenta.close();
            psVenta.close();

            if (idCliente != -1) {
                // 2. Buscar los datos del cliente
                String queryCliente = "SELECT id_cliente, nombre, apellido_paterno FROM clientes WHERE id_cliente = ?";
                PreparedStatement psCliente = conn.prepareStatement(queryCliente);
                psCliente.setInt(1, idCliente);
                ResultSet rsCliente = psCliente.executeQuery();

                if (rsCliente.next()) {
                    cliente = rsCliente.getInt("id_cliente") + " "
                            + rsCliente.getString("nombre") + " "
                            + rsCliente.getString("apellido_paterno");
                }
                rsCliente.close();
                psCliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

}
