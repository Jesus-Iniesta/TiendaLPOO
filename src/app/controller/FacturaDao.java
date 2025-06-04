
package app.controller;

import app.model.Factura;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfonso
 */
public interface FacturaDao {
    
    public abstract void GuardarFactura(Factura factura);
    public abstract void EliminarFactura(int id_factura);
    public abstract void ModificarFactura(Factura factura, int id);
    public abstract Factura ConsultarFactura(int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    public abstract ArrayList<String> Ventas();
    public abstract Double regresarTotal(int idVenta);
}
