
package app.controller;
import app.model.Categoria;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alfonso
 */
public interface CategoriaDao {
    
    public abstract void GuardarCategoria(Categoria cat);
    public abstract void EliminarCat(int id);
    public abstract Categoria ConsultarCategoria(int id);
    public abstract void ModificarCategoria(Categoria cat, int id);
    public abstract int ObtenerIdCat(DefaultTableModel modelotabla);
    public abstract void construirTabla(DefaultTableModel modeloTabla);
}
