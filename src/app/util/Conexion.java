
package app.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Alfonso
 */
public class Conexion {
    public static Connection getConexion(){
        
        String url = "jdbc:mysql://localhost:3306/tienda_alfonso";
        String usuario = "admin_tienda";
        String contraseña = "TiendaAlfonso324.";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }

}
