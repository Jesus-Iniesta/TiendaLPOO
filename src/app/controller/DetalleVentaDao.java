
package app.controller;
import app.model.DetalleVenta;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alfonso
 */
public interface DetalleVentaDao {
    
    
     
    public abstract DetalleVenta ConsultarDetalle(int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
}
