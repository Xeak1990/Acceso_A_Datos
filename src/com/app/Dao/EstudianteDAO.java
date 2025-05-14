package com.app.Dao;

import com.app.Model.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public void agregar(Estudiante e) throws SQLException {
        String sql = "INSERT INTO estudiantes (id, nombre, edad, carrera) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, e.getId());
            stmt.setString(2, e.getNombre());
            stmt.setInt(3, e.getEdad());
            stmt.setString(4, e.getCarrera());
            stmt.executeUpdate();
        }
    }

    public List<Estudiante> obtenerTodos() throws SQLException {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("carrera")
                ));
            }
        }
        return lista;
    }

    public Estudiante obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("carrera")
                );
            }
        }
        return null;
    }

    public void actualizar(Estudiante e) throws SQLException {
        String sql = "UPDATE estudiantes SET nombre=?, edad=?, carrera=? WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setInt(2, e.getEdad());
            stmt.setString(3, e.getCarrera());
            stmt.setInt(4, e.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM estudiantes WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}