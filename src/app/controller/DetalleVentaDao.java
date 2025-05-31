
package app.controller;
import app.model.DetalleVenta;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alfonso
 */
public interface DetalleVentaDao {
    
    public abstract void GuardarDetalle(DetalleVenta detalle);
    public abstract void EliminarDetalle(int id_detalle);
    public abstract void ModificarDetalle(DetalleVenta detalle, int id); 
    public abstract DetalleVenta ConsultarDetalle(int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
}
