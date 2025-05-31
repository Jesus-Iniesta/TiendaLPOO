
package app.controller;

import app.model.Categoria;
import app.util.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author pigim
 */
public class CategoriaDaoImp implements CategoriaDao{

    @Override
    public void GuardarCategoria(Categoria cat) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "INSERT INTO categorias (nombre_categoria,descripcion) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cat.getNombre_categorial());
            ps.setString(2, cat.getDescripcion());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria registrado con éxito");
        } catch (Exception e) {
        }
    }

    @Override
    public void EliminarCat(int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "DELETE FROM categorias where id_categoria = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria eliminada con éxito");
        } catch (Exception e) {
        }
    }

    @Override
    public Categoria ConsultarCategoria(int id) {
        Categoria cat = null; 
        try {
            Connection conn = Conexion.getConexion();
            String query = "SELECT * FROM categorias WHERE id_categoria = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cat = new Categoria(rs.getInt("id_categoria"), rs.getString("nombre_categoria"), rs.getString("descripcion"));
            }
            
        } catch (Exception e) {
            System.out.println("Error al eliminar cat: "+e);
        }
        return cat;
    }

    @Override
    public void ModificarCategoria(Categoria cat, int id) {
        try {
            Connection conn = Conexion.getConexion();
            String query = "UPDATE categorias SET nombre_categoria = ?, descripcion = ?  WHERE id_categoria = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cat.getNombre_categorial());
            ps.setString(2, cat.getDescripcion());
            ps.setInt(3, id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria Modificada con éxito");
        } catch (Exception e) {
            System.out.println("No se a podido modificar: "+e);
        }
    }

    @Override
    public void construirTabla(DefaultTableModel modeloTabla) {
        try{
            Connection con = Conexion.getConexion();
            String query = "select id_categorias, nombre_categoria, descripcion FROM categorias";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            
            while(rs.next()){
                Object[] fila = new Object[columnas];
                for(int i = 0; i< columnas;i++){
                    fila[i] = rs.getObject(i+1);
                }
                modeloTabla.addRow(fila);
            }
            
        }catch(SQLException e){
            System.out.println("Error al contruir tabla. "+e);
        }
    }

    @Override
    public int ObtenerIdCat(DefaultTableModel modeloTabla) {
        int id = modeloTabla.findColumn("id_categoria");
        return id;
    }
    
}
