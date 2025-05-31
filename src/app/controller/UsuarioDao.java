
package app.controller;
import app.model.Usuario;

/**
 *
 * @author Alfonso
 */
public interface UsuarioDao {
    
    public abstract Usuario Login(Usuario nombreUsuario, Usuario contraseniaUsuario);
    public abstract void Registro(Usuario nombreUsuario, Usuario nombreCompleto, Usuario rol, Usuario contraseniaUsuario,Usuario fechaRegistro);
}
