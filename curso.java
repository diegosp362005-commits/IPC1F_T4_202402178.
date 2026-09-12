package tarea4;

public class curso {
    private String codigo;
    private String nombre;
    private String tutor;

    public curso(String codigo, String nombre, String tutor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tutor = tutor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return "Curso: " + nombre + " | Código: " + codigo + " | Tutor: " + tutor;
    }
}