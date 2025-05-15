package com.app.Dao;

import com.app.Model.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase EstudianteDAO proporciona métodos para realizar operaciones CRUD 
 * (Crear, Leer, Actualizar, Eliminar) en la tabla "estudiantes" de la base de datos.
 * 
 * <p>Esta clase utiliza la clase {@link ConexionBD} para establecer la conexión a la base de datos.</p>
 * 
 * @version 1.0
 */
public class EstudianteDAO {

    /**
     * Inserta un nuevo estudiante en la base de datos.
     * 
     * @param e El objeto {@link Estudiante} a agregar.
     * @throws SQLException Si ocurre un error al realizar la operación de inserción.
     */
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

    /**
     * Obtiene una lista de todos los estudiantes almacenados en la base de datos.
     * 
     * @return Una lista de objetos {@link Estudiante}.
     * @throws SQLException Si ocurre un error al realizar la consulta.
     */
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

    /**
     * Busca y obtiene un estudiante en la base de datos por su ID.
     * 
     * @param id El identificador único del estudiante.
     * @return El objeto {@link Estudiante} encontrado, o {@code null} si no existe.
     * @throws SQLException Si ocurre un error al realizar la consulta.
     */
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

    /**
     * Actualiza los datos de un estudiante existente en la base de datos.
     * 
     * @param e El objeto {@link Estudiante} con los nuevos datos.
     * @throws SQLException Si ocurre un error al realizar la actualización.
     */
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

    /**
     * Elimina un estudiante de la base de datos por su ID.
     * 
     * @param id El identificador único del estudiante a eliminar.
     * @throws SQLException Si ocurre un error al realizar la eliminación.
     */
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM estudiantes WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
