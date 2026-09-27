
package controldetareas.dbConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/controlDeTareas";
    private static final String USUARIO = "postgres";
    private static final String PASSWORD = "2004";
    
    
    public static Connection conectar() {
        
        try {

            Connection conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    PASSWORD
            );

            System.out.println("Conexion exitosa a PostgresSQL");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error al conectar con PostgresSQL");
            e.printStackTrace();

            return null;

        }
        
    }
    
    
}




