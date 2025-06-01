
package app.model;


import java.time.LocalDateTime;

/**
 *
 * @author Alfonso
 */
public class Usuario {
    private String nombre_usuario;
    private String contrasenia;
    private String nombre_completo;
    private String rol;
    private LocalDateTime fecha_registro;

    public Usuario(String nombre_usuario, String contrasenia, String nombre_completo, String rol) {
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.nombre_completo = nombre_completo;
        this.rol = rol;
        this.fecha_registro = LocalDateTime.now();
    }
    

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getcontrasenia() {
        return contrasenia;
    }

    public void setcontrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
    
}
