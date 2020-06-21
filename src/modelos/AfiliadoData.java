package modelos;

import entidades.*;
import grupo3pf.*;
import java.sql.*;
import java.util.*;

public class AfiliadoData {

    public Afiliado altaAfiliado(Afiliado afiliado) {
        try {
            String sql = "INSERT INTO afiliados (dni, nombre, activo) VALUES ('" + afiliado.getDni() + "', '" + afiliado.getNombre() + "', " + (afiliado.isActivo() ? "1" : "0") + ");";
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();

            if (rs.first()) {
                afiliado.setId(rs.getInt(1));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar afiliado: " + e.getMessage());
        }
        return afiliado;
    }

    public Afiliado obtenerAfiliado(int id) {
        Afiliado afiliado = null;
        try {
            String sql = "SELECT * FROM afiliados WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                afiliado = new Afiliado(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), rs.getBoolean("activo"));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener afiliado: " + e.getMessage());
        }
        return afiliado;
    }

    public ArrayList<Afiliado> obtenerAfiliados(boolean mostrarDeshabilitados) {
        ArrayList<Afiliado> resultados = new ArrayList<>();

        try {
            String sql = "SELECT * FROM afiliados WHERE activo = " + (mostrarDeshabilitados ? "0 OR 1" : "1") + ";";;
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                resultados.add(new Afiliado(rs.getInt("id"), rs.getInt("dni"), rs.getString("nombre"), rs.getBoolean("activo")));
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener afiliados:" + e.getMessage());
        }

        return resultados;
    }

    public void bajaAfiliado(int id) {
        try {
            String sql = "DELETE FROM afiliados WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);

            s.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar afiliado: " + ex.getMessage());
        }
    }

    public void actualizarAfiliado(int id, Afiliado afiliado) {
        try {
            String sql = "UPDATE afiliados SET dni = '" + afiliado.getDni() + "', nombre = '" + afiliado.getNombre() + "', activo = " + (afiliado.isActivo() ? "1" : "0") + " WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.execute(sql);

            s.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar afiliado: " + e.getMessage());
        }
    }
}
