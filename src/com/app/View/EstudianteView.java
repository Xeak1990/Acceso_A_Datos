package com.app.View;

import com.app.Controller.EstudianteController;
import com.app.Model.Estudiante;
import java.util.Scanner;
import java.util.List;

public class EstudianteView {
    private EstudianteController controller = new EstudianteController();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("\n--- MENÚ DE ESTUDIANTES ---");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt(); sc.nextLine();

            try {
                switch (op) {
                    case 1 -> agregar();
                    case 2 -> listar();
                    case 3 -> buscar();
                    case 4 -> actualizar();
                    case 5 -> eliminar();
                    case 6 -> { System.out.println("Adiós"); return; }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void agregar() throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt(); sc.nextLine();
        System.out.print("Carrera: ");
        String carrera = sc.nextLine();

        Estudiante est = new Estudiante(id, nombre, edad, carrera);
        controller.agregarEstudiante(est);
        System.out.println("Estudiante agregado.");
    }

    private void listar() throws Exception {
        List<Estudiante> lista = controller.obtenerTodosLosEstudiantes();
        for (Estudiante e : lista) {
            System.out.printf("%d - %s, %d años, %s\n", e.getId(), e.getNombre(), e.getEdad(), e.getCarrera());
        }
    }

    private void buscar() throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();
        Estudiante e = controller.obtenerEstudiantePorId(id);
        if (e != null) {
            System.out.printf("Nombre: %s\nEdad: %d\nCarrera: %s\n", e.getNombre(), e.getEdad(), e.getCarrera());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void actualizar() throws Exception {
        System.out.print("ID a actualizar: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva edad: ");
        int edad = sc.nextInt(); sc.nextLine();
        System.out.print("Nueva carrera: ");
        String carrera = sc.nextLine();
        controller.actualizarEstudiante(new Estudiante(id, nombre, edad, carrera));
        System.out.println("Estudiante actualizado.");
    }

    private void eliminar() throws Exception {
        System.out.print("ID a eliminar: ");
        int id = sc.nextInt();
        controller.eliminarEstudiante(id);
        System.out.println("Estudiante eliminado.");
    }
}