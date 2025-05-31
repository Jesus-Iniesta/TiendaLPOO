
package app.model;

import java.security.Timestamp;
import javax.swing.text.TextAction;

/**
 *
 * @author Alfonso
 */
public class Proveedor {
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String empresa;
    private String telefono;
    private TextAction direccion;
    private String correo;
    private Timestamp fecha_registro;

    public Proveedor(String nombre, String apellido_paterno, String apellido_materno, String empresa, String telefono, TextAction direccion, String correo, Timestamp fecha_registro) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.empresa = empresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TextAction getDireccion() {
        return direccion;
    }

    public void setDireccion(TextAction direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
}
