
package ejercicioconexionjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjercicioConexionJDBC {

    public static void main(String[] args) {
        
        String usuario = "root"; // este es el usuario para conectar  a la base de datos
        String password = "";// este es el password para conectar  a la base de datos
        String url = "jdbc:mysql://localhost:3306/restaurantedb"; //conectar  al base de datos
        Connection conexion; // instancia para la conexion
        Statement statemen; // el parametro de consulta
        ResultSet rs; // guarda el resultado en una tabla        
        
//REVISAR Q ESTA JDBC
        try { // para evitar si sale un error ver q es
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

//CONSULTAR DATOS
System.out.println("----INICIANDO CONSULTA----");
        try { // para evitar problema que pueda presentarse
            conexion = DriverManager.getConnection(url,usuario,password); // son las variables que definimos para conectarnos
            statemen = conexion.createStatement(); //permite consultar con sql
            rs = statemen.executeQuery("SELECT * FROM usuarios"); // para guardar los datos pero se debe usar una sentencia soporte para q avance lineas con cada fila
            rs.next(); // este salta la linea
            do {
                System.out.println(rs.getInt("id_usuarios")+" : "+rs.getString("username") );// imprime en pantalla
            }while (rs.next()); // sigue mostrando mientras queden pendientes en el rs 
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----CONSULTA REALIZADA----");

// AGREGAR DATO
        System.out.println("----INSERTANDO USUARIO----");
        try { // para evitar problema que pueda presentarse
            conexion = DriverManager.getConnection(url,usuario,password); // son las variables que definimos para conectarnos
            statemen = conexion.createStatement(); //permite consultar con sql
            statemen.executeUpdate("INSERT INTO usuarios(username,password) VALUES ('FranEmilio','123')"); // en los valores e usan comillas simples para evitar errores por uso de ''
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----USUARIO AGREGADO----");

//CONSULTAR DATOS 
        System.out.println("----INICIANDO CONSULTA----");
        try { // para evitar problema que pueda presentarse
            conexion = DriverManager.getConnection(url,usuario,password); // son las variables que definimos para conectarnos
            statemen = conexion.createStatement(); //permite consultar con sql
            rs = statemen.executeQuery("SELECT * FROM usuarios"); // para guardar los datos pero se debe usar una sentencia soporte para q avance lineas con cada fila
            rs.next(); // este salta la linea
            do {
                System.out.println(rs.getInt("id_usuarios")+" : "+rs.getString("username")+" : "+rs.getString("password") );// imprime en pantalla
            }while (rs.next()); // sigue mostrando mientras queden pendientes en el rs 
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----CONSULTA REALIZADA----");

//MODIFICAR DATO
        System.out.println("----MODIFICANDO USUARIO----");
        try { // para evitar problema que pueda presentarse
            conexion = DriverManager.getConnection(url,usuario,password); // son las variables que definimos para conectarnos
            statemen = conexion.createStatement(); //permite consultar con sql
            statemen.executeUpdate("UPDATE usuarios SET password = 'nuevaclave' WHERE username = 'FranEmilio'"); // cambiando la clave de Fran
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----USUARIO MODIFICADO----");

//CONSULTAR DATOS 
        System.out.println("----INICIANDO CONSULTA----");
        try { // para evitar problema que pueda presentarse
            conexion = DriverManager.getConnection(url,usuario,password); // son las variables que definimos para conectarnos
            statemen = conexion.createStatement(); //permite consultar con sql
            rs = statemen.executeQuery("SELECT * FROM usuarios"); // para guardar los datos pero se debe usar una sentencia soporte para q avance lineas con cada fila
            rs.next(); // este salta la linea
            do {
                System.out.println(rs.getInt("id_usuarios")+" : "+rs.getString("username")+" : "+rs.getString("password") );// imprime en pantalla
            }while (rs.next()); // sigue mostrando mientras queden pendientes en el rs 
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----CONSULTA REALIZADA----");
        
//ELIMINAR DATO
        System.out.println("----ELIMINANDO USUARIO----");
        try { // para evitar problema que pueda presentarse
            conexion = DriverManager.getConnection(url,usuario,password); // son las variables que definimos para conectarnos
            statemen = conexion.createStatement(); //permite consultar con sql
            statemen.executeUpdate("DELETE FROM usuarios WHERE username = 'FranEmilio';"); // Eliminando a Fran
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----USUARIO ELIMINADO----");
        
//CONSULTAR DATOS 
        System.out.println("----INICIANDO CONSULTA----");
        try { // para evitar problema que pueda presentarse
            conexion = DriverManager.getConnection(url,usuario,password); // son las variables que definimos para conectarnos
            statemen = conexion.createStatement(); //permite consultar con sql
            rs = statemen.executeQuery("SELECT * FROM usuarios"); // para guardar los datos pero se debe usar una sentencia soporte para q avance lineas con cada fila
            rs.next(); // este salta la linea
            do {
                System.out.println(rs.getInt("id_usuarios")+" : "+rs.getString("username")+" : "+rs.getString("password") );// imprime en pantalla
            }while (rs.next()); // sigue mostrando mientras queden pendientes en el rs 
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----CONSULTA REALIZADA----");
    }
}