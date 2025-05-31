
package app.controller;

import app.model.Ventas;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pigim
 */
public interface VentaDao {
    
    
    public abstract void GuardarVenta(Ventas venta);
    public abstract void EliminarVenta(int id);
    public abstract Ventas ConsultarVenta(int id);
    public abstract void ModificarVentas(Ventas venta, int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    public abstract int DevolverIdVenta();
}
