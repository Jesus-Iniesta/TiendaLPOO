
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
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url , "admin_tienda","TiendaAlfonso324.");
            
        }catch(SQLException e){
            System.out.println("Error de conexion: "+e);
        }
        return conn;
    }

}
