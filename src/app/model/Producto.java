
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
    private TextAction descripcion;
    private double precio;
    private int stock = 0;
    private LocalDateTime fecha_registro;

    public Producto(String nombre, TextAction descripcion, double precio, LocalDateTime fecha_registro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_registro = fecha_registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TextAction getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(TextAction descripcion) {
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
