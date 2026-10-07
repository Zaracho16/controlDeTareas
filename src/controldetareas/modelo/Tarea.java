
package controldetareas.modelo;

import java.util.Date;

public class Tarea {
    
    private int idTareas;
    private int idUsuario;
    private int idCategoria;
    private int idEstado;
    
    private String nombreCategoria;
    private String nombreEstado;
    
    private String titulo;
    private String descripcion;
    private String prioridad;
    
    private Date fechaLimite;
    private Date fechaCreacion;
    
    private boolean completada;
    
    public Tarea(int idTareas, int idUsuario, int idCategoria, int idEstado, String titulo, String descripcion, String prioridad, Date fechaLimite, Date fechaCreacion, boolean completada) {
        this.idTareas = idTareas;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.idEstado = idEstado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.fechaCreacion = fechaCreacion;
        this.completada = completada;
    }

    public int getIdTareas() {
        return idTareas;
    }

    public void setIdTareas(int idTareas) {
        this.idTareas = idTareas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    
    
}