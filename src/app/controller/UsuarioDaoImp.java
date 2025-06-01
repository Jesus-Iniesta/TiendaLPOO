
package app.controller;

import app.model.Usuario;
import app.util.Conexion;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Alfonso
 */
public class UsuarioDaoImp implements UsuarioDao{

    @Override
    public boolean Login(String usuario, String contrasenia) {
        boolean autenticado = false;
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT contrasenia FROM usuarios WHERE nombre_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("contrasenia");
                String inputHash = HashearContrasenia(contrasenia);

                if (storedHash.equals(inputHash)) {
                    autenticado = true;
                }
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autenticado;
    }

    @Override
    public void Registro(Usuario usuario) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "INSERT INTO usuarios (nombre_usuario, contrasenia, nombre_completo, rol) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            // Encriptar la contraseña (SHA-256 como ejemplo simple)
            String hashedPassword = HashearContrasenia(usuario.getcontrasenia());

            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, hashedPassword);
            ps.setString(3, usuario.getNombre_completo());
            ps.setString(4, usuario.getRol()); // "admin" o "empleado"
            ps.executeUpdate();

            ps.close();
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar usuario.");
        }
    }

    @Override
    public String HashearContrasenia(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
