package tarea4;

public class TareaAcademica {
    private String titulo;
    private String descripcion;
    private String fechaEntrega;
    private String codigoCurso; // para saber a qué curso pertenece

    public TareaAcademica(String titulo, String descripcion, String fechaEntrega, String codigoCurso) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.codigoCurso = codigoCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    @Override
    public String toString() {
        return "Tarea: " + titulo + " | Descripción: " + descripcion +
               " | Entrega: " + fechaEntrega + " | Curso: " + codigoCurso;
    }
}