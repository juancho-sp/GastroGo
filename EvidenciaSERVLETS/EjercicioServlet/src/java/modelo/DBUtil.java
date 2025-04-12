package modelo;

import java.sql.*;

public class DBUtil {
    // Parámetros de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/restaurantedb";
    private static final String USER = "root";
    private static final String PASS = "";

    // Insertar usuario
    public static boolean insertarUsuario(String username, String password) {
        boolean exito = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            int filas = stmt.executeUpdate();
            exito = filas > 0;

            stmt.close();
            conn.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("⚠️ Usuario ya existe.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    // Obtener usuario por nombre
    public static Usuario obtenerUsuarioPorNombre(String username) {
        Usuario user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String sql = "SELECT * FROM usuarios WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id_usuarios");
                String nombre = rs.getString("username");
                String pass = rs.getString("password");
                user = new Usuario(id, nombre, pass);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static boolean eliminarUsuarioPorNombre(String username) {
        boolean exito = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String sql = "DELETE FROM usuarios WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            int filas = stmt.executeUpdate();
            exito = filas > 0;

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public static boolean actualizarContrasena(String username, String nuevaPassword) {
        boolean exito = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String sql = "UPDATE usuarios SET password = ? WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nuevaPassword);
            stmt.setString(2, username);

            int filas = stmt.executeUpdate();
            exito = filas > 0;

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

}