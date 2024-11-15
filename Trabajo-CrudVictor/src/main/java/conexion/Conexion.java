package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Parámetros de conexión
    private static final String hostname = "bancodb.cnwwkoq0cbja.us-east-1.rds.amazonaws.com";
    private static final String jdbcUrl = "jdbc:mysql://" + hostname + ":3306/banco_db"; 
    private static final String user = "admin";
    private static final String password = "Victor2202";
    
    // Objeto Connection
    private Connection con;

    // Constructor de la clase Conexion
    public Conexion() {
        try {
            // Intentamos cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentamos establecer la conexión
            con = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Éxito en la conexión");
        } catch (ClassNotFoundException e) {
            // En caso de que no se encuentre el driver
            System.out.println("Driver MySQL no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            // En caso de error en la conexión
            System.out.println("Error con la clase conexión: " + e.getMessage());
        }
    }
    
    // Método para obtener la conexión
    public Connection getConexion() {
        return con;
    }
}
