package com.app.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La clase ConexionBD proporciona métodos para establecer y cerrar conexiones 
 * con una base de datos MySQL.
 * 
 * <p>Utiliza el controlador JDBC para conectarse a una base de datos con la URL, 
 * el usuario y la contraseña especificados.
 * </p>
 * 
 * @author Axel
 * @version 1.0
 */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/Acceso";
    private static final String USER = "axel";
    private static final String PASSWORD = "0101";

    /**
     * Establece y devuelve una conexión con la base de datos.
     * 
     * @return Un objeto {@link Connection} que representa la conexión a la base de datos,
     *         o {@code null} si no se pudo establecer la conexión.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Conexión establecida con éxito.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        }
        return connection;
    }

    /**
     * Cierra una conexión previamente establecida con la base de datos.
     * 
     * @param connection La conexión a cerrar. Si es {@code null}, no realiza ninguna acción.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada con éxito.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }   
    }
}
