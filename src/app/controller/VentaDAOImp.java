package app.controller;

import app.model.Cliente;
import app.model.DetalleVenta;
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
public class VentaDAOImp implements VentaDao {

    @Override
    public void GuardarVenta(Ventas venta, DetalleVenta detalle) {

        Connection conn = null;
        PreparedStatement psVenta = null;
        PreparedStatement psDetalle = null;
        ResultSet generatedKeys = null;
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false); // Inicia la transacción

            // 1. Insertar la venta
            String queryVenta;
            if (venta.getId_cliente() > 0) {
                queryVenta = "INSERT INTO ventas (id_cliente, total) VALUES (?, ?)";
                psVenta = conn.prepareStatement(queryVenta, Statement.RETURN_GENERATED_KEYS);
                psVenta.setInt(1, venta.getId_cliente());
                psVenta.setDouble(2, venta.getTotal());
            } else {
                queryVenta = "INSERT INTO ventas (total) VALUES (?)";
                psVenta = conn.prepareStatement(queryVenta, Statement.RETURN_GENERATED_KEYS);
                psVenta.setDouble(1, venta.getTotal());
            }
            psVenta.executeUpdate();

            // 2. Obtener el id_venta generado
            generatedKeys = psVenta.getGeneratedKeys();
            int idVenta = 0;
            if (generatedKeys.next()) {
                idVenta = generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el id de la venta.");
            }

            // 3. Insertar el detalle de la venta usando el idVenta generado
            String queryDetalle = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
            psDetalle = conn.prepareStatement(queryDetalle);
            psDetalle.setInt(1, idVenta);
            psDetalle.setInt(2, detalle.getId_producto());
            psDetalle.setInt(3, detalle.getCantidad());
            psDetalle.setDouble(4, detalle.getPrecio_unitario());
            psDetalle.executeUpdate();

            conn.commit(); // Confirma la transacción
            JOptionPane.showMessageDialog(null, "Venta y detalle guardados con éxito");
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Error al guardar venta y detalle: ");
            System.out.println("error venta/detalle> " + e);
        } finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (psDetalle != null) {
                    psDetalle.close();
                }
                if (psVenta != null) {
                    psVenta.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void EliminarVenta(int idVenta) {
        Connection conn = null;
        PreparedStatement psDetalle = null;
        PreparedStatement psVenta = null;
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false); // Transacción

            // 1. Eliminar detalles de la venta
            String queryDetalle = "DELETE FROM detalle_venta WHERE id_venta = ?";
            psDetalle = conn.prepareStatement(queryDetalle);
            psDetalle.setInt(1, idVenta);
            psDetalle.executeUpdate();

            // 2. Eliminar la venta
            String queryVenta = "DELETE FROM ventas WHERE id_venta = ?";
            psVenta = conn.prepareStatement(queryVenta);
            psVenta.setInt(1, idVenta);
            psVenta.executeUpdate();

            conn.commit();
            JOptionPane.showMessageDialog(null, "Venta y detalle(s) eliminados con éxito");
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Error al eliminar la venta: ");
            System.out.println("error eliminar venta " + e);
        } finally {
            try {
                if (psDetalle != null) {
                    psDetalle.close();
                }
                if (psVenta != null) {
                    psVenta.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
            while (rs.next()) {

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
    public void ModificarVentas(Ventas venta, DetalleVenta detalle, int idVenta, int idDetalle) {
        Connection conn = null;
        PreparedStatement psVenta = null;
        PreparedStatement psDetalle = null;
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false); // inicia transacción

            // 1. Modificar la venta
            String queryVenta = "UPDATE ventas SET id_cliente = ?, total = ? WHERE id_venta = ?";
            psVenta = conn.prepareStatement(queryVenta);
            psVenta.setInt(1, venta.getId_cliente());
            psVenta.setDouble(2, venta.getTotal());
            psVenta.setInt(3, idVenta);
            psVenta.executeUpdate();

            // 2. Modificar el detalle de la venta
            String queryDetalle = "UPDATE detalle_venta SET id_producto = ?, cantidad = ?, precio_unitario = ? WHERE id_detalle = ?";
            psDetalle = conn.prepareStatement(queryDetalle);
            psDetalle.setInt(1, detalle.getId_producto());
            psDetalle.setInt(2, detalle.getCantidad());
            psDetalle.setDouble(3, detalle.getPrecio_unitario());
            psDetalle.setInt(4, idDetalle);
            psDetalle.executeUpdate();

            conn.commit(); // confirma cambios
            JOptionPane.showMessageDialog(null, "Venta y detalle modificados con éxito");
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
            }
            JOptionPane.showMessageDialog(null, "Error al modificar venta/detalle: " + e.getMessage());
            System.out.println("Error modificar venta/detalle: " + e);
        } finally {
            try {
                if (psDetalle != null) {
                    psDetalle.close();
                }
                if (psVenta != null) {
                    psVenta.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (Exception ex) {
            }
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
            while (rs.next()) {
                id_venta = rs.getInt("id_venta");
            }
            rs.close();
        } catch (Exception e) {
        }
        return id_venta;
    }

    @Override
    public ArrayList<String> ListaClientes() {
        ArrayList<String> ListaClientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT id_cliente, nombre, apellido_paterno FROM clientes";
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(rs.getString("nombre"), rs.getString("apellido_paterno"), rs.getInt("id_cliente"));
                ListaClientes.add(cliente.getId_cliente() + " " + cliente.getNombre() + " " + cliente.getApellido_paterno());
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return ListaClientes;
    }

}
