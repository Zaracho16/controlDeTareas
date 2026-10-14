
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
    
    public List<Categoria> listarCategorias() {
    List<Categoria> categorias = new ArrayList<>();

    String sql = """
        SELECT id_categoria, nombre
        FROM categoria
        ORDER BY id_categoria
        """;

    try (Connection conexion = Conexion.conectar();
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery()) {

        while (resultado.next()) {
            Categoria categoria = new Categoria(
                resultado.getInt("id_categoria"),
                0,
                resultado.getString("nombre")
            );

            categorias.add(categoria);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar categorías");
        e.printStackTrace();
    }

    return categorias;

    }
    
    
}
