
package app.model;

/**
 *
 * @author Alfonso
 */
public class Cliente {
    private String nombre;
    private String apellido_paterno;
    private String telefono;
    private String calle;
    private String colonia;
    private String ciudad;
    private String cp;
    private String rfc;

    public Cliente(String nombre, String apellido_paterno, String telefono, String calle, String colonia, String ciudad, String cp, String rfc) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.telefono = telefono;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.cp = cp;
        this.rfc = rfc;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    
}
