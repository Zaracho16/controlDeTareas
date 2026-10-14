
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

public List<Prioridad> listarPrioridades() {
    List<Prioridad> prioridades = new ArrayList<>();

    String sql = """
        SELECT id_prioridad, nombre
        FROM prioridad
        ORDER BY id_prioridad
        """;

    try (Connection conexion = Conexion.conectar();
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery()) {

        while (resultado.next()) {
            Prioridad prioridad = new Prioridad(
                resultado.getInt("id_prioridad"),
                resultado.getString("nombre")
            );

            prioridades.add(prioridad);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar prioridades");
        e.printStackTrace();
    }

    return prioridades;
}

}
