package modelos;

import entidades.*;
import grupo3pf.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class OrdenData {
    
    public Orden altaOrden(Orden orden) {
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
    
    public ArrayList<Orden> obtenerOrdenes() {
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
    
    public void actualizarOrden(Orden orden) {
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
