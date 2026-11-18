
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
    
    
}
