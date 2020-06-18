package modelos;
import entidades.*;
import grupo3pf.*;
import java.sql.*;
import java.util.*;
import java.time.*;

public class HorarioData {
    
    public Horario altaHorario(Horario horario){
        try {
            String sql = "INSERT INTO horarios (idPrestador, dia, horaInicio, horaFinal) VALUES (" + 
                    horario.getPrestador().getId() + ", " + 
                    horario.getDia().getValue() + ", '" + 
                    horario.getHoraInicio() + "', '" + 
                    horario.getHoraFin() + "');";
            System.out.println(sql);
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();
            
            if (rs.first())
                horario.setId(rs.getInt(1));
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar horario: " + e.getMessage());
        }
        return horario;
    }
    
    public Horario obtenerHorario(int id){
        Horario horario = null;
        PrestadorData pd = new PrestadorData();
        try {
            String sql = "SELECT * FROM horarios WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                Prestador p = pd.obtenerPrestador(rs.getInt("idPrestador"));
                DayOfWeek dia = DayOfWeek.of(rs.getInt("dia"));
                LocalTime inicio = rs.getTime("horaInicio").toLocalTime();
                LocalTime fin = rs.getTime("horaFinal").toLocalTime();
                
                horario = new Horario(rs.getInt("id"), p, dia, inicio, fin);
            }      
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener horario: " + e.getMessage());
        }
        return horario;
    }
    
    public ArrayList<Horario> obtenerHorarios(){
        ArrayList<Horario> resultados = new ArrayList<>();
        PrestadorData pd = new PrestadorData();
        try {
            String sql = "SELECT * FROM horarios";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                Prestador p = pd.obtenerPrestador(rs.getInt("idPrestador"));
                DayOfWeek dia = DayOfWeek.of(rs.getInt("dia"));
                LocalTime inicio = rs.getTime("horaInicio").toLocalTime();
                LocalTime fin = rs.getTime("horaFinal").toLocalTime();
                
                resultados.add(new Horario(rs.getInt("id"), p, dia, inicio, fin));
            }
            s.close();
        } catch (SQLException e){
            System.out.println("Error al obtener horarios:" + e.getMessage());
        }
        return resultados;
    }
    
    public ArrayList<Horario> obtenerHorariosPrestador(int idPrestador){
        ArrayList<Horario> resultados = new ArrayList<>();
        PrestadorData pd = new PrestadorData();
        try {
            String sql = "SELECT * FROM horarios WHERE idPrestador = " + idPrestador + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                Prestador p = pd.obtenerPrestador(rs.getInt("idPrestador"));
                DayOfWeek dia = DayOfWeek.of(rs.getInt("dia"));
                LocalTime inicio = rs.getTime("horaInicio").toLocalTime();
                LocalTime fin = rs.getTime("horaFinal").toLocalTime();
                
                resultados.add(new Horario(rs.getInt("id"), p, dia, inicio, fin));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener horarios del prestador:" + e.getMessage());
        }
        return resultados;
    }
    
    public ArrayList<Horario> obtenerHorariosDia(int dia){
        ArrayList<Horario> resultados = new ArrayList<>();
        PrestadorData pd = new PrestadorData();
        try {
            String sql = "SELECT * FROM horarios WHERE dia = " + dia + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                Prestador p = pd.obtenerPrestador(rs.getInt("idPrestador"));
                DayOfWeek d = DayOfWeek.of(rs.getInt("dia"));
                LocalTime inicio = rs.getTime("horaInicio").toLocalTime();
                LocalTime fin = rs.getTime("horaFinal").toLocalTime();
                
                resultados.add(new Horario(rs.getInt("id"), p, d, inicio, fin));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener horarios del prestador:" + e.getMessage());
        }
        return resultados;
    }
    
    public ArrayList<Horario> obtenerHorariosDiaPrestador(int dia, int idPrestador){
        ArrayList<Horario> resultados = new ArrayList<>();
        PrestadorData pd = new PrestadorData();
        try {
            String sql = "SELECT * FROM horarios WHERE dia = " + dia + " AND idPrestador = " + idPrestador + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                Prestador p = pd.obtenerPrestador(rs.getInt("idPrestador"));
                DayOfWeek d = DayOfWeek.of(rs.getInt("dia"));
                LocalTime inicio = rs.getTime("horaInicio").toLocalTime();
                LocalTime fin = rs.getTime("horaFinal").toLocalTime();
                
                resultados.add(new Horario(rs.getInt("id"), p, d, inicio, fin));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener horarios del prestador:" + e.getMessage());
        }
        return resultados;
    }
    
    public void bajaHorario(int id){
        try {
            String sql = "DELETE FROM horarios WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);
            
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar horarios: " + ex.getMessage());
        }
    }
    
    public void actualizarHorario(int id, Horario horario){
        try {
            String sql = "UPDATE horarios SET "
                    + "idPrestador = '" + horario.getPrestador().getId() + "', "
                    + "dia = " + horario.getDia().getValue() + ", "
                    + "horaInicio = '" + horario.getHoraInicio() + "', "
                    + "horaFinal = '" + horario.getHoraFin() + "' "
                    + "WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.execute(sql);
            
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar afiliado: " + e.getMessage());
        }
    }
}
