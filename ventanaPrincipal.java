package tarea4;

import javax.swing.*;
import java.awt.*;

public class ventanaPrincipal extends JFrame {

    // Componentes para el módulo de cursos
    private JTextField txtCodigoCurso;
    private JTextField txtNombreCurso;
    private JTextField txtTutorCurso;
    private JButton btnAgregarCurso;

    // Componentes para el módulo de tareas
    private JTextField txtCodigoCursoTarea;
    private JTextField txtTituloTarea;
    private JTextField txtDescripcionTarea;
    private JTextField txtFechaTarea;
    private JButton btnAgregarTarea;

    // Componente para mostrar información
    private JTextArea areaInformacion;
    private JButton btnMostrarInfo;

    // Componentes para el módulo de conversión de temperatura
    private JTextField txtTemperatura;
    private JButton btnConvertirF;
    private JButton btnConvertirK;
    private JLabel lblResultadoConversion;

    // Gestor que administra los datos
    private Gestorcursos gestor;

    public ventanaPrincipal() {
        gestor = new Gestorcursos();

        setTitle("Gestión de Cursos, Tareas y Conversor de Temperatura");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1, 5, 5));

        panelPrincipal.add(crearPanelCursos());
        panelPrincipal.add(crearPanelTareas());
        panelPrincipal.add(crearPanelConversion());

        add(panelPrincipal, BorderLayout.NORTH);
        add(crearPanelInformacion(), BorderLayout.CENTER);
 
        btnAgregarCurso.addActionListener(e -> agregarCurso());
        btnAgregarTarea.addActionListener(e -> agregarTarea());
        btnMostrarInfo.addActionListener(e -> areaInformacion.setText(gestor.mostrarInformacion()));
        btnConvertirF.addActionListener(e -> convertirTemperatura("F"));
        btnConvertirK.addActionListener(e -> convertirTemperatura("K"));
        setLocationRelativeTo(null); // centra la ventana
    }

    // Panel para registrar cursos
    private JPanel crearPanelCursos() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registrar Curso"));

        panel.add(new JLabel("Código:"));
        txtCodigoCurso = new JTextField();
        panel.add(txtCodigoCurso);

        panel.add(new JLabel("Nombre:"));
        txtNombreCurso = new JTextField();
        panel.add(txtNombreCurso);

        panel.add(new JLabel("Tutor:"));
        txtTutorCurso = new JTextField();
        panel.add(txtTutorCurso);

        btnAgregarCurso = new JButton("Agregar Curso");
        panel.add(btnAgregarCurso);

        return panel;
    }

    // Panel para registrar tareas
    private JPanel crearPanelTareas() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registrar Tarea"));

        panel.add(new JLabel("Código del Curso:"));
        txtCodigoCursoTarea = new JTextField();
        panel.add(txtCodigoCursoTarea);

        panel.add(new JLabel("Título:"));
        txtTituloTarea = new JTextField();
        panel.add(txtTituloTarea);

        panel.add(new JLabel("Descripción:"));
        txtDescripcionTarea = new JTextField();
        panel.add(txtDescripcionTarea);

        panel.add(new JLabel("Fecha de Entrega:"));
        txtFechaTarea = new JTextField();
        panel.add(txtFechaTarea);

        btnAgregarTarea = new JButton("Agregar Tarea");
        panel.add(btnAgregarTarea);

        return panel;
    }

    // Panel para el conversor de temperatura
    private JPanel crearPanelConversion() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Conversor de Temperatura"));

        panel.add(new JLabel("Temperatura (°C):"));
        txtTemperatura = new JTextField();
        panel.add(txtTemperatura);

        btnConvertirF = new JButton("Convertir a Fahrenheit");
        panel.add(btnConvertirF);

        btnConvertirK = new JButton("Convertir a Kelvin");
        panel.add(btnConvertirK);

        lblResultadoConversion = new JLabel("Resultado: ");
        panel.add(lblResultadoConversion);

        return panel;
    }

    // Panel para mostrar la información registrada
    private JPanel crearPanelInformacion() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Información Registrada"));

        areaInformacion = new JTextArea();
        areaInformacion.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaInformacion);

        btnMostrarInfo = new JButton("Mostrar Información");

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnMostrarInfo, BorderLayout.SOUTH);

        return panel;
    }
     private void agregarCurso() {
        String codigo = txtCodigoCurso.getText().trim();
        String nombre = txtNombreCurso.getText().trim();
        String tutor = txtTutorCurso.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || tutor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos del curso son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        curso curso = new curso(codigo, nombre, tutor);
        gestor.agregarCurso(curso);

        JOptionPane.showMessageDialog(this, "Curso agregado correctamente.");

        txtCodigoCurso.setText("");
        txtNombreCurso.setText("");
        txtTutorCurso.setText("");
    }

    private void agregarTarea() {
        String codigoCurso = txtCodigoCursoTarea.getText().trim();
        String titulo = txtTituloTarea.getText().trim();
        String descripcion = txtDescripcionTarea.getText().trim();
        String fecha = txtFechaTarea.getText().trim();

        if (codigoCurso.isEmpty() || titulo.isEmpty() || descripcion.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos de la tarea son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!gestor.existeCurso(codigoCurso)) {
            JOptionPane.showMessageDialog(this, "No existe un curso con ese código. Registra el curso primero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TareaAcademica tarea = new TareaAcademica(titulo, descripcion, fecha, codigoCurso);
        gestor.agregarTarea(tarea);

        JOptionPane.showMessageDialog(this, "Tarea agregada correctamente.");

        txtCodigoCursoTarea.setText("");
        txtTituloTarea.setText("");
        txtDescripcionTarea.setText("");
        txtFechaTarea.setText("");
    }

    private void convertirTemperatura(String tipo) {
        String texto = txtTemperatura.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa una temperatura.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double celsius;
        try {
            celsius = Double.parseDouble(texto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La temperatura debe ser un valor numérico.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tipo.equals("F")) {
            double fahrenheit = (celsius * 9 / 5) + 32;
            lblResultadoConversion.setText("Resultado: " + fahrenheit + " °F");
        } else {
            double kelvin = celsius + 273.15;
            lblResultadoConversion.setText("Resultado: " + kelvin + " K");
        }
    }
}