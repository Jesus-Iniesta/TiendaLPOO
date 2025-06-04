
package app.controller;

import app.model.DetalleVenta;
import app.model.Ventas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pigim
 */
public interface VentaDao {
    
    
    public abstract void GuardarVenta(Ventas venta, DetalleVenta detalle);
    public abstract void EliminarVenta(int id);
    public abstract Ventas ConsultarVenta(int id);
    public abstract void ModificarVentas(Ventas venta, DetalleVenta detalle, int idVenta, int idDetalle);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    public abstract int DevolverIdVenta();
    public abstract ArrayList<String> ListaClientes();
}
