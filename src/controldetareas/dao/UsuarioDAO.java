
package controldetareas.dao;

import controldetareas.dbConexion.Conexion;
import controldetareas.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        String sqlUsuario = """
            INSERT INTO usuario (nombre, email, password)
            VALUES (?, ?, ?)
            """;

        String sqlCategoria = """
            INSERT INTO categoria (nombre, id_usuario)
            VALUES (?, ?)
            """;

        String sqlPrioridad = """
            INSERT INTO prioridad (nombre, id_usuario)
            VALUES (?, ?)
            """;

        try (Connection conexion = Conexion.conectar()) {

            conexion.setAutoCommit(false);

            try {
                int idUsuario;

                try (PreparedStatement sentencia = conexion.prepareStatement(
                        sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {

                    sentencia.setString(1, nombre);
                    sentencia.setString(2, email);

                    String passwordHash = BCrypt.hashpw(
                            password, BCrypt.gensalt(12));

                    sentencia.setString(3, passwordHash);

                    sentencia.executeUpdate();

                    try (ResultSet resultado = sentencia.getGeneratedKeys()) {

                        if (resultado.next()) {
                            idUsuario = resultado.getInt(1);
                        } else {
                            throw new SQLException("No se pudo obtener el ID del usuario");
                        }
                    }
                }

                try (PreparedStatement sentencia = conexion.prepareStatement(sqlCategoria)) {

                    String[] categorias = {"Facultad", "Personal", "Trabajo"};

                    for (String categoria : categorias) {
                        sentencia.setString(1, categoria);
                        sentencia.setInt(2, idUsuario);
                        sentencia.addBatch();
                    }

                    sentencia.executeBatch();
                }

                try (PreparedStatement sentencia = conexion.prepareStatement(sqlPrioridad)) {

                    String[] prioridades = {"Alta", "Media", "Baja"};

                    for (String prioridad : prioridades) {
                        sentencia.setString(1, prioridad);
                        sentencia.setInt(2, idUsuario);
                        sentencia.addBatch();
                    }

                    sentencia.executeBatch();
                }

                conexion.commit();

                return true;

            } catch (SQLException e) {

                conexion.rollback();
                throw e;
            }

        } catch (SQLException e) {

            System.out.println("Error al crear el usuario y sus datos iniciales");
            e.printStackTrace();

            return false;
        }
    }
    
    
}