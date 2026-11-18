
package controldetareas.dao;

import controldetareas.dbConexion.Conexion;
import controldetareas.modelo.Prioridad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrioridadDAO {

    public List<Prioridad> listarPrioridades(int idUsuario) {
        List<Prioridad> prioridades = new ArrayList<>();

        String sql = """
            SELECT id_prioridad, nombre
            FROM prioridad
            WHERE id_usuario = ?
            ORDER BY id_prioridad
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idUsuario);

            try (ResultSet resultado = sentencia.executeQuery()) {

                while (resultado.next()) {
                    Prioridad prioridad = new Prioridad(
                        resultado.getInt("id_prioridad"),
                        resultado.getString("nombre")
                    );

                    prioridades.add(prioridad);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al listar prioridades");
            e.printStackTrace();
        }

        return prioridades;
    }
    
    public boolean guardarPrioridad(int idUsuario, String nombre) {
        String sql = """
            INSERT INTO prioridad (id_usuario, nombre)
            VALUES (?, ?)
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idUsuario);
            sentencia.setString(2, nombre);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar prioridad");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizarPrioridad(int idPrioridad, int idUsuario, String nombre) {
        String sql = """
            UPDATE prioridad
            SET nombre = ?
            WHERE id_prioridad = ? AND id_usuario = ?
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, nombre);
            sentencia.setInt(2, idPrioridad);
            sentencia.setInt(3, idUsuario);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar prioridad");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarPrioridad(int idPrioridad, int idUsuario) {
        String sql = """
            DELETE FROM prioridad
            WHERE id_prioridad = ? AND id_usuario = ?
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idPrioridad);
            sentencia.setInt(2, idUsuario);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar prioridad");
            e.printStackTrace();
            return false;
        }
    }

}
