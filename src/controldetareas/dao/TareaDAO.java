
package controldetareas.dao;

import controldetareas.dbConexion.Conexion;
import controldetareas.modelo.Tarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {

    public List<Tarea> listarTareas(int idUsuario) {

        List<Tarea> tareas = new ArrayList<>();

        String sql = """
            SELECT t.id_tareas, t.id_usuario, t.id_categoria, t.id_estado,
                   t.titulo, t.descripcion, t.prioridad,
                   t.fecha_limite, t.fecha_creacion, t.completada,
                   c.nombre AS nombre_categoria,
                   e.nombre AS nombre_estado
            FROM tareas t
            INNER JOIN categoria c ON t.id_categoria = c.id_categoria
            INNER JOIN estado e ON t.id_estado = e.id_estado
            WHERE t.id_usuario = ?
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idUsuario);

            try (ResultSet resultado = sentencia.executeQuery()) {

                while (resultado.next()) {

                    Tarea tarea = new Tarea(
                        resultado.getInt("id_tareas"),
                        resultado.getInt("id_usuario"),
                        resultado.getInt("id_categoria"),
                        resultado.getInt("id_estado"),
                        resultado.getString("titulo"),
                        resultado.getString("descripcion"),
                        resultado.getString("prioridad"),
                        resultado.getDate("fecha_limite"),
                        resultado.getDate("fecha_creacion"),
                        resultado.getBoolean("completada")
                    );
                    
                    String nombreCategoria = resultado.getString("nombre_categoria");
                    String nombreEstado = resultado.getString("nombre_estado");
                    
                    tarea.setNombreCategoria(nombreCategoria);
                    tarea.setNombreEstado(nombreEstado);
                    
                    tareas.add(tarea);

                }
            }

        } catch (SQLException e) {

            System.out.println("Error al listar tareas");
            e.printStackTrace();
        }

        return tareas;
    }
}