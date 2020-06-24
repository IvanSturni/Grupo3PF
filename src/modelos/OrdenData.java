package modelos;

import entidades.*;
import grupo3pf.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class OrdenData {
    
    static public Orden altaOrden(Orden orden) {
        try {
            String sql = "INSERT INTO ordenes (idAfiliado, idHorario, fechaAtencion, fechaCreacion, efectivo, activa) VALUES ('"
                    + orden.getAfiliado().getId() + "', '" 
                    + orden.getHorario().getId() + "', '"
                    + java.sql.Date.valueOf(orden.getFechaAtencion()) + "', '"
                    + java.sql.Date.valueOf(orden.getFechaCreacion()) + "', "
                    + (orden.isEfectivo() ? "1" : "0") + ", "
                    + (orden.isActiva() ? "1" : "0") + ");";
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();

            if (rs.first()) {
                orden.setId(rs.getInt(1));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar orden: " + e.getMessage());
        }
        return orden;
    }
    
    public Orden obtenerOrden(int id) {
        Orden orden = null;
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();
        
        try {
            String sql = "SELECT * FROM ordenes WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                orden = new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa"));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener orden: " + e.getMessage());
        }
        return orden;
    }
    
    static public ArrayList<Orden> obtenerOrdenes() {
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT * FROM ordenes";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public ArrayList<Orden> obtenerOrdenesAfiliadoPrestadorFecha(Afiliado afiliado, Prestador prestador, LocalDate fecha){
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT o.* FROM ordenes o JOIN horarios h ON o.idHorario = h.id WHERE o.idAfiliado = " + afiliado.getId() + " AND h.idPrestador = " + prestador.getId() + " AND o.fechaAtencion = '" + fecha + "';";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public ArrayList<Orden> obtenerOrdenesPrestador(Prestador prestador){
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT o.* FROM ordenes o JOIN horarios h ON o.idHorario = h.id WHERE h.idPrestador = " + prestador.getId();
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public ArrayList<Orden> obtenerOrdenesPrestadorFecha(Prestador prestador, LocalDate fecha){
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT o.* FROM ordenes o JOIN horarios h ON o.idHorario = h.id WHERE h.idPrestador = " + prestador.getId() + " AND o.fechaAtencion = '" + fecha + "';";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public ArrayList<Orden> obtenerOrdenesAfiliadoPrestador(Afiliado afiliado, Prestador prestador){
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT o.* FROM ordenes o JOIN horarios h ON o.idHorario = h.id WHERE h.idPrestador = " + prestador.getId() + " AND o.idAfiliado = " + afiliado.getId() + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public ArrayList<Orden> obtenerOrdenesAfiliado(Afiliado afiliado){
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT * FROM ordenes WHERE idAfiliado = " + afiliado.getId();
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public ArrayList<Orden> obtenerOrdenesAfiliadoFecha(Afiliado afiliado, LocalDate fecha){
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT * FROM ordenes WHERE idAfiliado = " + afiliado.getId() + " AND fechaAtencion = '" + fecha + "';";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public ArrayList<Orden> obtenerOrdenesFecha(LocalDate fecha){
        ArrayList<Orden> resultados = new ArrayList<>();
        AfiliadoData ad = new AfiliadoData();
        HorarioData hd = new HorarioData();

        try {
            String sql = "SELECT * FROM ordenes WHERE fechaAtencion = '" + fecha + "';";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                
                Afiliado a = ad.obtenerAfiliado(rs.getInt("idAfiliado"));
                Horario h = hd.obtenerHorario(rs.getInt("idHorario"));
                LocalDate fAtencion = rs.getDate("fechaAtencion").toLocalDate();
                LocalDate fCreacion = rs.getDate("fechaCreacion").toLocalDate();
                
                resultados.add(new Orden(rs.getInt("id"), a, h, fAtencion, fCreacion, rs.getBoolean("efectivo"), rs.getBoolean("activa")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ordenes:" + e.getMessage());
        }

        return resultados;
    }
    
    public void bajaOrden(int id) {
        try {
            String sql = "DELETE FROM ordenes WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);

            s.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar orden: " + ex.getMessage());
        }
    }
    
    static public void actualizarOrden(Orden orden) {
        try {
            String sql = "UPDATE ordenes SET idAfiliado = '" + orden.getAfiliado().getId() + 
                    "', idHorario = '" + orden.getHorario().getId() + 
                    "', fechaAtencion = '" + java.sql.Date.valueOf(orden.getFechaAtencion()) +
                    "', fechaCreacion = '" + java.sql.Date.valueOf(orden.getFechaCreacion()) + 
                    "', efectivo = " + (orden.isEfectivo() ? "1" : "0") +
                    ", activa = " + (orden.isActiva() ? "1" : "0") +
                    " WHERE id = " + orden.getId() + ";";
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql);

            s.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar orden: " + e.getMessage());
        }
    }
}
