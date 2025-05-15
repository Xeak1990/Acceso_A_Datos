package com.app.Model;

/**
 * La clase Estudiante representa a un estudiante con atributos básicos como
 * su identificador único, nombre, edad y carrera.
 * 
 * <p>Esta clase es utilizada para almacenar los datos de los estudiantes que 
 * se interactúan en la base de datos, y proporciona métodos para obtener y 
 * modificar estos datos.</p>
 * 
 * @version 1.0
 */
public class Estudiante {
    private int id;
    private String nombre;
    private int edad;
    private String carrera;

    /**
     * Constructor por defecto que crea un objeto Estudiante vacío.
     */
    public Estudiante() {}

    /**
     * Constructor que crea un objeto Estudiante con los valores especificados.
     * 
     * @param id El identificador único del estudiante.
     * @param nombre El nombre del estudiante.
     * @param edad La edad del estudiante.
     * @param carrera La carrera que estudia el estudiante.
     */
    public Estudiante(int id, String nombre, int edad, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
    }

    /**
     * Obtiene el identificador único del estudiante.
     * 
     * @return El identificador del estudiante.
     */
    public int getId() { return id; }

    /**
     * Establece el identificador único del estudiante.
     * 
     * @param id El identificador del estudiante.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Obtiene el nombre del estudiante.
     * 
     * @return El nombre del estudiante.
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del estudiante.
     * 
     * @param nombre El nombre del estudiante.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene la edad del estudiante.
     * 
     * @return La edad del estudiante.
     */
    public int getEdad() { return edad; }

    /**
     * Establece la edad del estudiante.
     * 
     * @param edad La edad del estudiante.
     */
    public void setEdad(int edad) { this.edad = edad; }

    /**
     * Obtiene la carrera que estudia el estudiante.
     * 
     * @return La carrera del estudiante.
     */
    public String getCarrera() { return carrera; }

    /**
     * Establece la carrera del estudiante.
     * 
     * @param carrera La carrera del estudiante.
     */
    public void setCarrera(String carrera) { this.carrera = carrera; }
}
