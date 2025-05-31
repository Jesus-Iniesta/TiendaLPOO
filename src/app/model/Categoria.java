
package app.model;

import javax.swing.text.TextAction;

/**
 *
 * @author Alfonso
 */
public class Categoria {
    private int id_categoria;
    private String nombre_categorial;
    private TextAction descripcion;

    public Categoria(int id_categoria, String nombre_categorial, TextAction descripcion) {
        this.id_categoria = id_categoria;
        this.nombre_categorial = nombre_categorial;
        this.descripcion = descripcion;
    }

    public String getNombre_categorial() {
        return nombre_categorial;
    }

    public void setNombre_categorial(String nombre_categorial) {
        this.nombre_categorial = nombre_categorial;
    }

    public TextAction getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(TextAction descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }
    
    
}
