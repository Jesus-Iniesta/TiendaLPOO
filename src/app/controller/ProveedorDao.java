
package app.controller;

import app.model.Proveedor;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alfonso
 */
public interface ProveedorDao {
    
    public abstract void GuardarProveedor(Proveedor proveedor);
    public abstract void EliminarProveedor(int id);
    public abstract void ModificarProveedor(Proveedor proveedor, int id);
    public abstract Proveedor ConsultarProveedor(int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
}
