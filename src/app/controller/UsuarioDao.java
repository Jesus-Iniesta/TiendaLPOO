
package app.controller;
import app.model.Usuario;

/**
 *
 * @author Alfonso
 */
public interface UsuarioDao {
    
    public abstract boolean Login(String usuario, String contrasenia);
    public abstract void Registro(Usuario usuario);
    public abstract String HashearContrasenia(String password);
}
