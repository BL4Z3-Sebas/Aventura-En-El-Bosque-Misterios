package Pruebas;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MiClase {

    private JTextPane textPane;

    public MiClase() {
        // Inicializar el JTextPane
        textPane = new JTextPane();
        textPane.setEditable(false);  // Hacer el JTextPane no editable
        JFrame frame = new JFrame("Ejemplo JTextPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new JScrollPane(textPane), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void escribirDialogo(String dialogo, Thread siguienteHilo) {
        Thread thread = new Thread(() -> {
            char[] caracteres = dialogo.toCharArray();  // Convertir el diálogo a un array de caracteres
            int longitud = 0;

            StyledDocument doc = textPane.getStyledDocument();  // Obtener el documento del JTextPane
            Style estilo = textPane.addStyle("Estilo", null);  // Crear un estilo de texto

            for (char c : caracteres) {
                final char caracterActual = c;

                // Publicar el carácter en el JTextPane
                SwingUtilities.invokeLater(() -> {
                    try {
                        doc.insertString(doc.getLength(), String.valueOf(caracterActual), estilo);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }
                });

                longitud++;

                if (longitud >= 65 && caracterActual == ' ') {
                    SwingUtilities.invokeLater(() -> {
                        try {
                            doc.insertString(doc.getLength(), "\n", estilo);
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    });
                    longitud = 0;
                }

                try {
                    switch (caracterActual) {
                        case '.':
                            Thread.sleep(500);
                            SwingUtilities.invokeLater(() -> {
                                try {
                                    doc.insertString(doc.getLength(), "\n", estilo);
                                } catch (BadLocationException e) {
                                    e.printStackTrace();
                                }
                            });
                            longitud = 0;
                            break;
                        case ',':
                            Thread.sleep(200);
                            break;
                        default:
                            Thread.sleep(50);
                            break;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();  // Iniciar el hilo

        // Esperar a que termine el hilo y luego iniciar el siguiente
        new Thread(() -> {
            try {
                thread.join();  // Esperar a que el primer hilo termine
                if (siguienteHilo != null) {
                    siguienteHilo.start();  // Iniciar el siguiente hilo después
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public static void main(String[] args) {
        MiClase miClase = new MiClase();

        // Crear primer hilo
        Thread hilo1 = new Thread(() -> miClase.escribirDialogo("Este es el primer diálogo.", null));

        // Crear segundo hilo
        Thread hilo2 = new Thread(() -> miClase.escribirDialogo("Este es el segundo diálogo.", null));

        // Iniciar el primer hilo, y cuando termine, iniciar el segundo hilo
        miClase.escribirDialogo("Este es el primer diálogo.", hilo2);
    }
}
