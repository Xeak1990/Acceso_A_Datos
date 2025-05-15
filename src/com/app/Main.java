package com.app;

import com.app.View.EstudianteView;

/**
 * La clase Main es la clase principal de la aplicación, responsable de iniciar
 * la ejecución del programa. En este caso, inicia el flujo de operaciones del 
 * menú de estudiantes.
 * 
 * <p>Este programa permite realizar diversas operaciones sobre los estudiantes,
 * como agregar, listar, buscar, actualizar y eliminar.</p>
 * 
 * @version 1.0
 */
public class Main {
    /**
     * El método main es el punto de entrada de la aplicación. Este método inicia
     * el menú interactivo de operaciones para gestionar estudiantes, proporcionando
     * al usuario la posibilidad de realizar distintas acciones.
     * 
     * @param args Los argumentos de línea de comandos (no se usan en este caso).
     */
    public static void main(String[] args) {
        new EstudianteView().iniciar();
    }
}
