
package controldetareas.dao;

import controldetareas.dbConexion.Conexion;
import controldetareas.modelo.Usuario;

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
    
    public boolean validacionCredenciales(String email, String password) {
        
        String sql = "SELECT id FROM usuario WHERE email = ? AND password = ?";
        
        try (Connection conexion = Conexion.conectar(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, email);
            sentencia.setString(2, password);
            
            try (ResultSet resultado = sentencia.executeQuery()){
                return resultado.next();
            }
            
        } catch (SQLException e) {
            
            System.out.println("Error al validar credenciales");
            e.printStackTrace();
            
            return false;
        }
        
    }
    
    public Usuario obtenerUsuario(String email, String password) {
        
        String sql = "SELECT id, nombre, email, password" + " FROM usuario WHERE email = ? AND password = ? ";
        
        try (Connection conexion = Conexion.conectar(); PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, email);
            sentencia.setString(2, password);
            
            try (ResultSet resultado = sentencia.executeQuery()) {
            
                if (resultado.next()) {
                    
                    Usuario usuario = new Usuario(
                            resultado.getInt("id"),
                            resultado.getString("nombre"),
                            resultado.getString("email"),
                            resultado.getString("password")
                    );
                    
                    return usuario;
                    
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
            sentencia.setString(3, password);
            
            sentencia.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("Error al crear el usuario");
            e.printStackTrace();
            
            return false;
            
        }
        
    }
    
    
}