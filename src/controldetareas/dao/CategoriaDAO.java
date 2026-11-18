
package controldetareas.dao;

import controldetareas.dbConexion.Conexion;
import controldetareas.modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    
    public List<Categoria> listarCategorias(int idUsuario) {
        List<Categoria> categorias = new ArrayList<>();

        String sql = """
            SELECT id_categoria, id_usuario, nombre
            FROM categoria
            WHERE id_usuario = ?
            ORDER BY id_categoria
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idUsuario);

            try (ResultSet resultado = sentencia.executeQuery()) {

                while (resultado.next()) {
                    Categoria categoria = new Categoria(
                        resultado.getInt("id_categoria"),
                        resultado.getInt("id_usuario"),
                        resultado.getString("nombre")
                    );

                    categorias.add(categoria);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al listar categorías");
            e.printStackTrace();
        }

        return categorias;
    }
    
    
    public boolean guardarCategoria(int idUsuario, String nombre) {

        String sql = """
            INSERT INTO categoria (id_usuario, nombre)
            VALUES (?, ?)
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idUsuario);
            sentencia.setString(2, nombre);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar categoría");
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean actualizarCategoria(int idCategoria, int idUsuario, String nombre) {

        String sql = """
            UPDATE categoria
            SET nombre = ?
            WHERE id_categoria = ? AND id_usuario = ?
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, nombre);
            sentencia.setInt(2, idCategoria);
            sentencia.setInt(3, idUsuario);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarCategoria(int idCategoria, int idUsuario) {

        String sql = """
            DELETE FROM categoria
            WHERE id_categoria = ? AND id_usuario = ?
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idCategoria);
            sentencia.setInt(2, idUsuario);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría");
            e.printStackTrace();
            return false;
        }
    }
    
    
}
