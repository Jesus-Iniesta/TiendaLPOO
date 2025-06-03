
package app.model;

import javax.swing.text.TextAction;

/**
 *
 * @author Alfonso
 */
public class Categoria {
    private int id_categoria;
    private String nombre_categorial;
    private String descripcion;

    public Categoria(int id_categoria, String nombre_categorial) {
        this.nombre_categorial = nombre_categorial;
        this.id_categoria = id_categoria;
    }

    public Categoria(int id_categoria, String nombre_categorial, String descripcion) {
        this.id_categoria = id_categoria;
        this.nombre_categorial = nombre_categorial;
        this.descripcion = descripcion;
    }

    public Categoria(String nombre_categorial, String descripcion) {
        this.nombre_categorial = nombre_categorial;
        this.descripcion = descripcion;
    }
    
    

    public String getNombre_categorial() {
        return nombre_categorial;
    }

    public void setNombre_categorial(String nombre_categorial) {
        this.nombre_categorial = nombre_categorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }
    
    
}
