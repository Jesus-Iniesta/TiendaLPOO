
package app.model;

import java.time.LocalDateTime;
import javax.swing.text.TextAction;

/**
 *
 * @author Alfonso
 */
public class Producto {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock = 0;
    private LocalDateTime fecha_registro;
    private int id_proveedor;
    private int id_categoria;

    public Producto( String nombre, String descripcion, double precio,int stock, int id_proveedor, int id_categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fecha_registro = fecha_registro;
        this.id_proveedor = id_proveedor;
        this.id_categoria = id_categoria;
    }

    public Producto(int id_producto, String nombre) {
        this.id_producto = id_producto;
        this.nombre = nombre;
    }
    
    
    
    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    
    
}
