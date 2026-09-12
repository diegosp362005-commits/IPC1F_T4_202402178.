package tarea4;

import javax.swing.SwingUtilities;

public class Tarea4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ventanaPrincipal ventana = new ventanaPrincipal();
            ventana.setVisible(true);
        });
    }
}