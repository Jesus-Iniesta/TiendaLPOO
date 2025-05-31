
package app.model;

import java.awt.TextArea;
import java.util.Date;

/**
 *
 * @author Alfonso
 */
public class PedidoProveedor {
    private int id_pedido;
    private int id_proveedor;
    private Date fecha_pedido;
    private Date fecha_entrega_estimada;
    private String estado_pedido;
    private String producto_solicitado;
    private int cantidad;
    private double precio_unitario;
    private TextArea observaciones;

    public PedidoProveedor(int id_pedido, int id_proveedor, Date fecha_pedido, Date fecha_entrega_estimada, String estado_pedido, String producto_solicitado, int cantidad, double precio_unitario, TextArea observaciones) {
        this.id_pedido = id_pedido;
        this.id_proveedor = id_proveedor;
        this.fecha_pedido = fecha_pedido;
        this.fecha_entrega_estimada = fecha_entrega_estimada;
        this.estado_pedido = estado_pedido;
        this.producto_solicitado = producto_solicitado;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.observaciones = observaciones;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_entrega_estimada() {
        return fecha_entrega_estimada;
    }

    public void setFecha_entrega_estimada(Date fecha_entrega_estimada) {
        this.fecha_entrega_estimada = fecha_entrega_estimada;
    }

    public String getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(String estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public String getProducto_solicitado() {
        return producto_solicitado;
    }

    public void setProducto_solicitado(String producto_solicitado) {
        this.producto_solicitado = producto_solicitado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public TextArea getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(TextArea observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
