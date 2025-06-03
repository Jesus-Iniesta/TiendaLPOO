package app.controller;

import app.model.Producto;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Alfonso
 */
public interface ProductoDao {
    
    public abstract void RegistrarProducto(Producto producto);
    public abstract void EliminarProducto(int id);
    public abstract void ModificarProducto(Producto producto, int id);
    public abstract Producto ConsultarProducto(int id);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
    public abstract ArrayList<String> ProveedoresList();
    public abstract ArrayList<String> CategoriaList();
    public abstract String ConsultarProveedor(int id);
    public abstract String ConsultarCategoria(int id);
}
