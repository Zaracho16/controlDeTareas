
package controldetareas.dao;

import controldetareas.dbConexion.Conexion;
import controldetareas.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;


public class UsuarioDAO {
    
    public Usuario obtenerUsuario(String email, String password) {
        
        String sql = "SELECT id, nombre, email, password" + " FROM usuario WHERE email = ?";
        
        try (Connection conexion = Conexion.conectar(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, email);
            
            try (ResultSet resultado = sentencia.executeQuery()) {
            
                if (resultado.next()) {
                    
                    String passwordHash = resultado.getString("password");
                    
                    if(BCrypt.checkpw(password, passwordHash)) {
                        
                        Usuario usuario = new Usuario(
                                resultado.getInt("id"),
                                resultado.getString("nombre"),
                                resultado.getString("email"),
                                resultado.getString("password")
                        );
                        
                        return usuario;
                        
                    }
                    
                }
                
            } catch (SQLException e) {
                System.out.println("Error al obtener usuario");
                e.printStackTrace();
            }
            
            return null;
            
        } catch (SQLException e) {
            
            System.out.println("Error al conectarse a la base de datos");
            e.printStackTrace();
            
        }
        
        return null;
        
    }
    
    public boolean crearUsuario(String nombre, String email, String password) {
        
        String sql = "INSERT INTO usuario (nombre, email, password) VALUES (?, ?, ?)";
        
        try (Connection conexion = Conexion.conectar(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, nombre);
            sentencia.setString(2, email);
            
            String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            sentencia.setString(3, passwordHash);
            
            sentencia.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("Error al crear el usuario");
            e.printStackTrace();
            
            return false;
            
        }
        
    }
    
    
}