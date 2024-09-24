package Pruebas;

import javax.swing.*;
import java.awt.*;

public class DialogoJuego {

    private int indiceParte = 0;  // Índice de la parte actual del diálogo
    private String[] partesDialogo;  // Partes en las que se dividirá el diálogo
    private JTextArea area;
    private JButton btnSiguiente;
    private JButton btnAnterior;
    private JPanel panelDecisiones;

    public DialogoJuego(JTextArea area, JButton btnSiguiente, JButton btnAnterior, JPanel panelDecisiones) {
        this.area = area;
        this.btnSiguiente = btnSiguiente;
        this.btnAnterior = btnAnterior;
        this.panelDecisiones = panelDecisiones;
    }

    // Método para dividir el diálogo en partes
    public void dividirDialogo(String dialogo) {
        partesDialogo = dialogo.split("(?<=\\G.{550})");  // Dividir el diálogo en partes de 140 caracteres
        mostrarParte(false);
    }

    // Método para mostrar la parte actual del diálogo
    private void mostrarParte(boolean esRetroceso) {
        area.setText("");  // Limpiar el área de texto

        if (esRetroceso) {
            // Si es retroceso, mostrar directamente el texto completo de esa parte
            area.setText(partesDialogo[indiceParte]);
        } else {
            // Si es avance, escribirlo carácter por carácter
            escribirDialogo(partesDialogo[indiceParte]);
        }

        actualizarBotones();
    }

    // Método para escribir gradualmente el diálogo en el JTextArea
    public void escribirDialogo(String dialogo) {
        Thread thread = new Thread(() -> {
            char[] caracteres = dialogo.toCharArray();
            for (char c : caracteres) {
                SwingUtilities.invokeLater(() -> area.append(String.valueOf(c)));
                try {
                    switch (c) {
                        case '.':
                            Thread.sleep(500);  // Pausa más larga después de un punto
                            break;
                        case ',':
                            Thread.sleep(200);  // Pausa corta entre palabras (después de una coma)
                            break;
                        default:
                            Thread.sleep(50);  // Pausa corta entre caracteres
                            break;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
    }

    // Método para manejar el botón de "Siguiente"
    public void siguienteParte() {
        if (indiceParte < partesDialogo.length - 1) {
            indiceParte++;
            mostrarParte(false);  // Es avance, se escribe el texto gradualmente
        } else {
            mostrarOpciones();  // Mostrar opciones cuando se llega al final
        }
    }

    // Método para manejar el botón de "Anterior"
    public void parteAnterior() {
        if (indiceParte > 0) {
            indiceParte--;
            mostrarParte(true);  // Es retroceso, se muestra el texto completo
        }
    }

    // Método para actualizar los botones
    private void actualizarBotones() {
        btnAnterior.setEnabled(indiceParte > 0);
        btnSiguiente.setEnabled(indiceParte < partesDialogo.length - 1);
    }

    // Método para mostrar las opciones de decisión al final del diálogo
    private void mostrarOpciones() {
        panelDecisiones.removeAll();  // Limpiar el panel de decisiones
        area.setText("Debes tomar una decisión:\n");

        // Ejemplo de decisiones
        JButton opcion1 = new JButton("Opción 1");
        JButton opcion2 = new JButton("Opción 2");

        opcion1.addActionListener(e -> cargarDialogoAlternativo("Has elegido la opción 1"));
        opcion2.addActionListener(e -> cargarDialogoAlternativo("Has elegido la opción 2"));

        panelDecisiones.add(opcion1);
        panelDecisiones.add(opcion2);

        panelDecisiones.revalidate();
        panelDecisiones.repaint();
    }

    // Método para cargar un diálogo alternativo según la decisión
    private void cargarDialogoAlternativo(String dialogo) {
        area.setText("");  // Limpiar el área de texto
        dividirDialogo(dialogo);  // Cargar nuevo diálogo
    }

    // Configuración de los botones de avance y retroceso
    public void configurarBotones() {
        btnSiguiente.addActionListener(e -> siguienteParte());
        btnAnterior.addActionListener(e -> parteAnterior());
    }

    public static void main(String[] args) {
        // Asegurar que todo se ejecute en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // Configuración del JFrame
            JFrame frame = new JFrame("Diálogo de Juego");
            JTextArea areaTexto = new JTextArea(10, 40);
//            areaTexto.setLineWrap(true);  // Ajustar el texto automáticamente
//            areaTexto.setWrapStyleWord(true);  // No cortar las palabras al ajustar
//            areaTexto.setEditable(false);  // El área de texto no debe ser editable

            JButton btnSiguiente = new JButton("Siguiente");
            JButton btnAnterior = new JButton("Anterior");
            JPanel panelDecisiones = new JPanel();

            DialogoJuego dialogoJuego = new DialogoJuego(areaTexto, btnSiguiente, btnAnterior, panelDecisiones);

            // Dividir y mostrar el diálogo
            dialogoJuego.dividirDialogo("Este es el diálogo inicial de prueba que se mostrará en partes. "
                    + "Cada parte tiene una longitud limitada de 140 caracteres. "
                    + "Cuando termines de leer esta parte, se mostrará otra parte. Aquí puede continuar el diálogo.");

            dialogoJuego.configurarBotones();

            // Configuración del JFrame
            JPanel panelTexto = new JPanel();
            panelTexto.setLayout(new BorderLayout());
            panelTexto.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

            JPanel panelBotones = new JPanel();
            panelBotones.add(btnAnterior);
            panelBotones.add(btnSiguiente);

            frame.setLayout(new BorderLayout());
            //frame.add(panelTexto, BorderLayout.NORTH);
            frame.add(panelBotones, BorderLayout.SOUTH);
            frame.add(panelDecisiones, BorderLayout.SOUTH);

            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
