package modelos;
import entidades.*;
import grupo3pf.*;
import java.sql.*;
import java.util.*;
public class PrestadorData {
    
    public Prestador altaPrestador(Prestador prestador){
        try {
            String sql;
            if(prestador.getEspecialidad() != null)
                sql = "INSERT INTO prestadores (dni, nombre, idEspecialidad, activo) VALUES (" + prestador.getDni() + ", '" + prestador.getNombre() + "', " + prestador.getEspecialidad().getId() + ", " + (prestador.isActivo() ? "1" : "0") + ");";
            else
                sql ="INSERT INTO prestadores (dni, nombre, activo) VALUES (" + prestador.getDni() + ", '" + prestador.getNombre() + "', " + (prestador.isActivo() ? "1" : "0") + ");";
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
            String sql = "SELECT * FROM prestadores WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                Especialidad e = (rs.getInt("idEspecialidad") > 0) ? (Especialidad)em.obtenerEspecialidad(rs.getInt("idespecialidad")) : null;
                prestador = new Prestador(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), e, rs.getBoolean("activo"));
            }      
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener prestador: " + e.getMessage());
        }
        return prestador;
    }
    
    public Prestador obtenerPrestadorDNI(int dni){
        Prestador prestador = null;
        EspecialidadData em = new EspecialidadData();
        try {
            String sql = "SELECT * FROM prestadores WHERE dni = " + dni + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                Especialidad e = (rs.getInt("idEspecialidad") > 0) ? (Especialidad)em.obtenerEspecialidad(rs.getInt("idespecialidad")) : null;
                prestador = new Prestador(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), e, rs.getBoolean("activo"));
            }      
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener prestador por DNI: " + e.getMessage());
        }
        return prestador;
    }
    
    public ArrayList<Prestador> obtenerPrestadores(boolean mostrarDeshabilitados){
        ArrayList<Prestador> resultados = new ArrayList<>();
        EspecialidadData em = new EspecialidadData();
        
        try {
            String sql = "SELECT * FROM prestadores WHERE activo = " + (mostrarDeshabilitados ? "0 OR 1" : "1") + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                Especialidad e = (rs.getInt("idEspecialidad") > 0) ? (Especialidad)em.obtenerEspecialidad(rs.getInt("idespecialidad")) : null;
                resultados.add(new Prestador(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), e, rs.getBoolean("activo")));
            }
            s.close();
        } catch (SQLException e){
            System.out.println("Error al obtener prestadores:" + e.getMessage());
        }
        
        return resultados;
    }
    
    public ArrayList<Prestador> obtenerPrestadoresEspecialidad(Especialidad especialidad, boolean mostrarDeshabilitados){
        ArrayList<Prestador> resultados = new ArrayList<>();
        EspecialidadData em = new EspecialidadData();
        
        try {
            String sql;
            if (mostrarDeshabilitados)
                sql = "SELECT * FROM prestadores WHERE idEspecialidad = " + especialidad.getId();
            else
                sql = "SELECT * FROM prestadores WHERE idEspecialidad = " + especialidad.getId() + " AND activo = 1";
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
            String sql = "DELETE FROM prestadores WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);
            
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar prestador: " + ex.getMessage());
        }
    }
    
    public void actualizarPrestador(int id, Prestador prestador){
        try {
            String sql;
            if (prestador.getEspecialidad() != null)
                sql = "UPDATE prestadores SET dni = " + prestador.getDni() + ", nombre = '" + prestador.getNombre() + "', idEspecialidad = " + prestador.getEspecialidad().getId() + ", activo = " + (prestador.isActivo() ? "1" : "0") + " WHERE id = " + id + ";";
            else
                sql = "UPDATE prestadores SET dni = " + prestador.getDni() + ", nombre = '" + prestador.getNombre() + "', idEspecialidad = NULL, activo = " + (prestador.isActivo() ? "1" : "0") + " WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            //s.execute(sql);
            s.executeUpdate(sql);
            
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar prestador: " + e.getMessage());
        }
    }
}
