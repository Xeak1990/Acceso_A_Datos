package com.app.Controller;

import com.app.Model.Estudiante;
import com.app.Dao.EstudianteDAO;
import java.sql.SQLException;
import java.util.List;

public class EstudianteController {
    private EstudianteDAO dao;

    public EstudianteController() {
        dao = new EstudianteDAO();
    }

    public void agregarEstudiante(Estudiante e) throws SQLException {
        dao.agregar(e);
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() throws SQLException {
        return dao.obtenerTodos();
    }

    public Estudiante obtenerEstudiantePorId(int id) throws SQLException {
        return dao.obtenerPorId(id);
    }
    public void actualizarEstudiante(Estudiante e) throws SQLException {
        dao.actualizar(e);
    }
    
    public void eliminarEstudiante(int id) throws SQLException {
        dao.eliminar(id);
    }
}
