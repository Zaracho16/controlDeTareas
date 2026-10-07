
package controldetareas.modelo;


public class Categoria {
    
    private int idCategoria;
    private int idUsuario;
    private String nombre;

    public Categoria(int idCategoria, int idUsuario, String nombre) {
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
       
}
