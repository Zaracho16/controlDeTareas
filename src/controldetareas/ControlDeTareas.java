
package controldetareas;

import controldetareas.dbConexion.Conexion;
import controldetareas.dao.UsuarioDAO;

public class ControlDeTareas {

    public static void main(String[] args) {
    
        Conexion.conectar();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
       boolean resultado = usuarioDAO.validacionCredenciales(
               "usuario1@gmai.com",
               "1234"
       );
       
        System.out.println("Salida: " + resultado);
        
    }
    
}
