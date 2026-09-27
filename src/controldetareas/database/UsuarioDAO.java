
package controldetareas.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    
    public void listarUsuarios() {
        
        String sql = "Select id, nombre, email, password FROM usuario";
        
        try (Connection conexion = Conexion.conectar(); 
             PreparedStatement sentencia = conexion.prepareStatement(sql); // para ejecutar consultas sql desde java
             ResultSet resultado = sentencia.executeQuery() ) { // contiene los resultados que devuelve postgres
                
                while(resultado.next()) {
                    
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    String email = resultado.getString("email");
                    
                    System.out.println("ID: " + id + " | Nombre: " + nombre + " | Email " + email);
                     
                }
            
            } catch (SQLException e) {
            
                System.out.println("Error al listar usuarios");
                e.printStackTrace();
                
            }
            
    }
    
}
