
package app.model;

import java.time.LocalDateTime;

/**
 *
 * @author Alfonso
 */
public class Ventas {
    private int id_venta;
    private int id_cliente;
    private LocalDateTime fecha;
    private double total;

    
    //venta con cliente 
    public Ventas(int id_cliente, double total) {
        this.id_cliente = id_cliente;
        this.total = total;
    }

    //venta sin cliente 

    public Ventas(double total) {
        this.total = total;
    }
    
    //consultar ventas

    public Ventas(int id_venta) {
        this.id_venta = id_venta;
    }

    
   

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    
}
