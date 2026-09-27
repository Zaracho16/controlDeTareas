
package controldetareas;

import controldetareas.database.Conexion;
import controldetareas.database.UsuarioDAO;

public class ControlDeTareas {

    public static void main(String[] args) {
    
        Conexion.conectar();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuarioDAO.listarUsuarios();
        
    }
    
}
