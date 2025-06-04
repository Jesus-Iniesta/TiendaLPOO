
package app.model;

import java.time.LocalDateTime;
import javax.swing.text.TextAction;

/**
 *
 * @author Alfonso
 */
public class Factura {
    private int id_factura, id_venta;
    private String nombre;
    private String apellido_paterno, apellido_materno;
    private String rfc;
    private String razon_social;
    private String direccion_fiscal;
    private LocalDateTime fecha_emision;
    private double total; 

    public Factura(int id_factura, int id_venta, String nombre, String apellido_paterno, String apellido_materno, String rfc, String razon_social, String direccion_fiscal, LocalDateTime fecha_emision, double total) {
        this.id_factura = id_factura;
        this.id_venta = id_venta;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rfc = rfc;
        this.razon_social = razon_social;
        this.direccion_fiscal = direccion_fiscal;
        this.fecha_emision = fecha_emision;
        this.total = total;
    }

    public Factura(int id_venta, String nombre, String apellido_paterno, String apellido_materno, String rfc, String razon_social, String direccion_fiscal, double total) {
        this.id_venta = id_venta;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rfc = rfc;
        this.razon_social = razon_social;
        this.direccion_fiscal = direccion_fiscal;
        this.total = total;
    }

    public Factura(int id_factura, int id_venta, String nombre, String apellido_paterno, String apellido_materno, String rfc, String razon_social, String direccion_fiscal, double total) {
        this.id_factura = id_factura;
        this.id_venta = id_venta;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rfc = rfc;
        this.razon_social = razon_social;
        this.direccion_fiscal = direccion_fiscal;
        this.total = total;
    }
    
    
    

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion_fiscal() {
        return direccion_fiscal;
    }

    public void setDireccion_fiscal(String direccion_fiscal) {
        this.direccion_fiscal = direccion_fiscal;
    }

    public LocalDateTime getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDateTime fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
