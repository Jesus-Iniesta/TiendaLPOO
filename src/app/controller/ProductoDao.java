package app.controller;

import app.model.Producto;
/**
 *
 * @author Alfonso
 */
public interface ProductoDao {
    
    public abstract void RegistrarProducto(Producto producto);
    public abstract void EliminarProducto(Producto id);
    public abstract void ModificarProducto(Producto producto, int id);
    public abstract Producto ConsultarProducto(Producto id);
}
