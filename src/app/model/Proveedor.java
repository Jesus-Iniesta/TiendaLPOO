
package app.model;


import java.time.LocalDate;


/**
 *
 * @author Alfonso
 */
public class Proveedor {
    private int id_proveedor;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String empresa;
    private String telefono;
    private String direccion;
    private String correo;
    private LocalDate fecha_registro;

    public Proveedor(String nombre, String apellido_paterno, String apellido_materno, String empresa, String telefono, String direccion, String correo, LocalDate fecha_registro) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.empresa = empresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
    }

    public Proveedor(int id_proveedor,String nombre, String apellido_paterno, String empresa) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.empresa = empresa;
        this.id_proveedor = id_proveedor;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    
}
