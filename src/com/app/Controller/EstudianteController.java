package com.app.Controller;

import com.app.Dao.EstudianteDAO;
import com.app.Model.Estudiante;
import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de los estudiantes.
 * Utiliza el DAO para realizar las operaciones con la base de datos.
 */
public class EstudianteController {
    private EstudianteDAO dao;

    /**
     * Constructor que inicializa el objeto DAO.
     */
    public EstudianteController() {
        dao = new EstudianteDAO();
    }

    /**
     * Agrega un nuevo estudiante a la base de datos.
     * 
     * @param e El objeto Estudiante a agregar.
     * @throws SQLException Si ocurre un error en la operación de la base de datos.
     */
    public void agregarEstudiante(Estudiante e) throws SQLException {
        dao.agregar(e);
    }

    /**
     * Obtiene una lista de todos los estudiantes registrados.
     * 
     * @return Una lista con todos los estudiantes.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public List<Estudiante> obtenerTodosLosEstudiantes() throws SQLException {
        return dao.obtenerTodos();
    }

    /**
     * Obtiene un estudiante específico por su ID.
     * 
     * @param id El ID del estudiante a buscar.
     * @return El objeto Estudiante si se encuentra, o null si no existe.
     * @throws SQLException Si ocurre un error al realizar la consulta.
     */
    public Estudiante obtenerEstudiantePorId(int id) throws SQLException {
        return dao.obtenerPorId(id);
    }

    /**
     * Actualiza la información de un estudiante existente en la base de datos.
     * 
     * @param e El objeto Estudiante con la información actualizada.
     * @throws SQLException Si ocurre un error al realizar la actualización.
     */
    public void actualizarEstudiante(Estudiante e) throws SQLException {
        dao.actualizar(e);
    }

    /**
     * Elimina un estudiante de la base de datos dado su ID.
     * 
     * @param id El ID del estudiante a eliminar.
     * @throws SQLException Si ocurre un error durante la eliminación.
     */
    public void eliminarEstudiante(int id) throws SQLException {
        dao.eliminar(id);
    }
}
