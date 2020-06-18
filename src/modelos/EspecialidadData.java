package modelos;
import entidades.*;
import grupo3pf.*;
import java.sql.*;
import java.util.*;

public class EspecialidadData {
    
    public Especialidad altaEspecialidad(Especialidad especialidad){
        try {
            String sql = "INSERT INTO especialidades SET nombre = '" + especialidad.getNombre() + "';";
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();
            
            if (rs.first())
                especialidad.setId(rs.getInt(1));
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar especialidad: " + e.getMessage());
        }
        return especialidad;
    }
    
    public Especialidad obtenerEspecialidad(int id){
        Especialidad especialidad = null;
        try {
            String sql = "SELECT * FROM especialidades WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                especialidad = new Especialidad(rs.getInt("id"), rs.getString("nombre"));
            }      
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener especialidad: " + e.getMessage());
        }
        return especialidad;
    }
    
    public ArrayList<Especialidad> obtenerEspecialidades(){
        ArrayList<Especialidad> resultados = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM especialidades";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                resultados.add(new Especialidad(rs.getInt("id"), rs.getString("nombre")));
            }
            s.close();
        } catch (SQLException e){
            System.out.println("Error al obtener especialidades:" + e.getMessage());
        }
        
        return resultados;
    }
    
    public void bajaEspecialidad(int id){
        try {
            String sql = "DELETE FROM especialidades WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);
            
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar especialidad: " + ex.getMessage());
        }
    }
    
    public void actualizarEspecialidad(int id, Afiliado afiliado){
        try {
            String sql = "UPDATE especialidades SET  nombre = '" + afiliado.getNombre()+ "' WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.execute(sql);
            
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar especialidad: " + e.getMessage());
        }
    }
}
