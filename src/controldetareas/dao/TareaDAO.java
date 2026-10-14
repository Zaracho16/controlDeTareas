
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
            SELECT t.id_tareas, t.id_usuario, t.id_categoria, t.id_estado, t.id_prioridad,
                   t.titulo, t.descripcion,
                   t.fecha_limite, t.fecha_creacion, t.completada,
                   c.nombre AS nombre_categoria,
                   e.nombre AS nombre_estado,
                   p.nombre AS nombre_prioridad
            FROM tareas t
            INNER JOIN categoria c ON t.id_categoria = c.id_categoria
            INNER JOIN estado e ON t.id_estado = e.id_estado
            INNER JOIN prioridad p ON t.id_prioridad = p.id_prioridad
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
                        resultado.getInt("id_prioridad"),
                        resultado.getString("titulo"),
                        resultado.getString("descripcion"),
                        resultado.getDate("fecha_limite"),
                        resultado.getDate("fecha_creacion"),
                        resultado.getBoolean("completada")
                    );
                    
                    String nombreCategoria = resultado.getString("nombre_categoria");
                    String nombreEstado = resultado.getString("nombre_estado");
                    String nombrePrioridad = resultado.getString("nombre_prioridad");
                    
                    tarea.setNombreCategoria(nombreCategoria);
                    tarea.setNombreEstado(nombreEstado);
                    tarea.setNombrePrioridad(nombrePrioridad);
                    
                    tareas.add(tarea);

                }
            }

        } catch (SQLException e) {

            System.out.println("Error al listar tareas");
            e.printStackTrace();
        }

        return tareas;
    }
    
    public boolean crearTarea(
        int idUsuario,
        int idCategoria,
        int idPrioridad,
        String titulo,
        String descripcion,
        java.sql.Date fechaLimite) {

        String sql = """
            INSERT INTO tareas
                (id_usuario, id_categoria, id_estado, id_prioridad,
                 titulo, descripcion, fecha_limite, completada)
            VALUES (?, ?, ?, ?, ?, ?, ?, FALSE)
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idUsuario);
            sentencia.setInt(2, idCategoria);
            sentencia.setInt(3, 1); // Pendiente
            sentencia.setInt(4, idPrioridad);
            sentencia.setString(5, titulo);
            sentencia.setString(6, descripcion);
            sentencia.setDate(7, fechaLimite);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al crear la tarea");
            e.printStackTrace();
            return false;
        }

    }
    
}