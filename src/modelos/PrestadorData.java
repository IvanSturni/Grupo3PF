package modelos;
import entidades.*;
import grupo3pf.*;
import java.sql.*;
import java.util.*;
public class PrestadorData {
    
    public Prestador altaPrestador(Prestador prestador){
         try {
            String sql = "INSERT INTO prestador (dni, nombre, especialidad, activo) VALUES ('" + prestador.getDni() + "', '" + prestador.getNombre() + "', " + prestador.getEspecialidad() + "', " + (prestador.isActivo() ? "1" : "0") + ");";
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();
            
            if (rs.first())
                prestador.setId(rs.getInt(1));
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar prestador: " + e.getMessage());
        }
         return prestador;
    }
    
    public Prestador obtenerPrestador(int id){
        Prestador prestador = null;
        EspecialidadData em = new EspecialidadData();
        try {
            String sql = "SELECT * FROM prestador WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                prestador = new Prestador(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), (Especialidad)em.obtenerEspecialidad(rs.getInt("idespecialidad")), rs.getBoolean("activo"));
            }      
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener prestador: " + e.getMessage());
        }
        return prestador;
    }
    
    public ArrayList<Prestador> obtenerPrestadores(){
        ArrayList<Prestador> resultados = new ArrayList<>();
        EspecialidadData em = new EspecialidadData();
        
        try {
            String sql = "SELECT * FROM prestador";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                resultados.add(new Prestador(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), (Especialidad)em.obtenerEspecialidad(rs.getInt("idespecialidad")), rs.getBoolean("activo")));
            }
            s.close();
        } catch (SQLException e){
            System.out.println("Error al obtener prestadores:" + e.getMessage());
        }
        
        return resultados;
    }
    
    public void bajaPrestador(int id){
        try {
            String sql = "DELETE FROM prestador WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);
            
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar prestador: " + ex.getMessage());
        }
    }
    
    public void actualizarPrestador(int id, Prestador prestador){
        try {
            String sql = "UPDATE prestador SET dni = '" + prestador.getDni() + "', nombre = '" + prestador.getNombre() + "', activo = " + prestador.getEspecialidad() + "', " + (prestador.isActivo() ? "1" : "0") + " WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.execute(sql);
            
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar prestador: " + e.getMessage());
        }
    }
}
