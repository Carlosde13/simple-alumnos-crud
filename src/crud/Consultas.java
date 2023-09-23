/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deleo
 */
public class Consultas {

    public static List<String[]> obtenerunselect() {
        List<String[]> resultados = new ArrayList<>();
        Connection connection = Conexion.conexion();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM ALUMNOS";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    int edad = resultSet.getInt("edad");

                    String[] fila = {String.valueOf(id), nombre, String.valueOf(edad)};
                    resultados.add(fila);
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

        return resultados;
    }

    public static void insertAlumno(int id, String nombre, int edad) {
        Connection connection = Conexion.conexion();

        if (connection != null) {
            PreparedStatement statement = null;
            try {
                String query = "INSERT INTO ALUMNOS (id, nombre, edad) VALUES (?, ?, ?)";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.setString(2, nombre);
                statement.setInt(3, edad);
                int rowCount = statement.executeUpdate();

                if (rowCount > 0) {
                    System.out.println("Inserción exitosa");
                } else {
                    System.out.println("No se insertaron registros");
                }
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
     public static void eliminarAlumno(int id) {
        Connection connection = Conexion.conexion();

        if (connection != null) {
            PreparedStatement statement = null;
            try {
                String query = "DELETE FROM ALUMNOS WHERE id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                int rowCount = statement.executeUpdate();

                if (rowCount > 0) {
                    System.out.println("Se ha elimninado exitosamente");
                } else {
                    System.out.println("No se pudo eliminar");
                }
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
     
    public static void actualizarAlumno(int id, String nombre, int edad) {
        Connection connection = Conexion.conexion();

        if (connection != null) {
            PreparedStatement statement = null;
            try {
                String query = "UPDATE ALUMNOS SET nombre = ? , edad = ? WHERE id = ?" ;
                statement = connection.prepareStatement(query);
                statement.setString(1, nombre);
                statement.setInt(2, edad);
                statement.setInt(3, id);
                int rowCount = statement.executeUpdate();

                if (rowCount > 0) {
                    System.out.println("Inserción exitosa");
                } else {
                    System.out.println("No se insertaron registros");
                }
            } catch (SQLException e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}
