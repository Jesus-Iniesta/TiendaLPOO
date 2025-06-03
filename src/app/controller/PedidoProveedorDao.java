
package app.controller;
import app.model.PedidoProveedor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alfonso
 */
public interface PedidoProveedorDao {
    
    public abstract void GuardarPedido(PedidoProveedor pedido);
    public abstract void EliminarPedido(int id);
    public abstract void ModificarPedido(PedidoProveedor pedido, int id);
    public abstract PedidoProveedor ConsultarPedido(int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    public abstract ArrayList<String> ProveedoresList();
    public abstract ArrayList<String> ProductosList();
    public abstract Double consultarPrecio(int id);
    public abstract String consultarProveedor(int id);
    
}
