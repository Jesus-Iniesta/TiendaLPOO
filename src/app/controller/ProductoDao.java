package app.controller;

import app.model.Producto;
/**
 *
 * @author Alfonso
 */
public interface ProductoDao {
    
    public abstract void RegistrarProducto(Producto producto);
    public abstract void EliminarProducto(int id);
    public abstract void ModificarProducto(Producto producto, int id);
    public abstract Producto ConsultarProducto(int id);
}
