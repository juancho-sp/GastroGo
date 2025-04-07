package com.gastrogo.gastrogousuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GastroGousuario {
    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/gastrogousuario";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             Statement statement = conexion.createStatement()) {

            // Consulta de usuarios
            ResultSet rs = statement.executeQuery("SELECT * FROM usuario");
            System.out.println("Usuarios actuales:");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

            // Inserción de datos
            statement.execute("INSERT INTO usuario (nombre) VALUES ('femilio');");

            // Nueva consulta después de inserción
            rs = statement.executeQuery("SELECT * FROM usuario");
            System.out.println("\nUsuarios después de inserción:");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

            // Actualización de datos
            statement.execute("UPDATE usuario SET nombre = 'fluis' WHERE id = 1;");

            // Nueva consulta después de actualización
            rs = statement.executeQuery("SELECT * FROM usuario");
            System.out.println("\nUsuarios después de actualización:");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

            // Borrado de datos
            statement.execute("DELETE FROM usuario WHERE id = 2;");

            rs = statement.executeQuery("SELECT * FROM usuario");
            System.out.println("\nUsuarios después de eliminación:");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GastroGousuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

