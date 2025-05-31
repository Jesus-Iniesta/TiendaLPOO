
package app.controller;
import app.model.Cliente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfonso
 */
public interface ClienteDao {
    
    public abstract void RegistroCliente(Cliente datos);
    public abstract void EliminarCliente(int id);
    public abstract void ModificarCliente(Cliente datos, int id);
    public abstract Cliente ConsultarCliente(int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    
}
