package tarea4;

import java.util.ArrayList;

public class Gestorcursos {
    private ArrayList<curso> cursos;
    private ArrayList<TareaAcademica> tareas;

    public Gestorcursos() {
        cursos = new ArrayList<>();
        tareas = new ArrayList<>();
    }
    // Agregar un curso nuevo
    public void agregarCurso(curso curso) {
        cursos.add(curso);
    }

    // Agregar una tarea nueva
    public void agregarTarea(TareaAcademica tarea) {
        tareas.add(tarea);
    }

    // Verifica si existe un curso con ese código (para asociar tareas correctamente)
    public boolean existeCurso(String codigo) {
        for (curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    // Genera un texto con todos los cursos y tareas registrados
    public String mostrarInformacion() {
        StringBuilder texto = new StringBuilder();

        texto.append("=== CURSOS REGISTRADOS ===\n");
        if (cursos.isEmpty()) {
            texto.append("No hay cursos registrados.\n");
        } else {
            for (curso c : cursos) {
                texto.append(c.toString()).append("\n");
            }
        }

        texto.append("\n=== TAREAS REGISTRADAS ===\n");
        if (tareas.isEmpty()) {
            texto.append("No hay tareas registradas.\n");
        } else {
            for (TareaAcademica t : tareas) {
                texto.append(t.toString()).append("\n");
            }
        }
        return texto.toString();
    }
}
