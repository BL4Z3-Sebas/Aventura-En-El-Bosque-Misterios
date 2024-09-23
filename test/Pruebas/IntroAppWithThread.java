package Pruebas;

import javax.swing.*;
import java.awt.*;

public class IntroAppWithThread extends JFrame {

    private JLabel appNameLabel;
    private JTextArea textArea;
    private int yPosition;
    private Color color;

    public IntroAppWithThread() {
        setTitle("Aplicación con Introducción");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Usar layout nulo para controlar las posiciones de los componentes

        // Crear el JLabel
        appNameLabel = new JLabel("Nombre de la Aplicación", JLabel.CENTER);
        appNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        appNameLabel.setBounds(100, 150, 300, 50); // Posición inicial
        yPosition = 150;
        color = new Color(50, 50, 50); // Color gris oscuro inicial
        appNameLabel.setForeground(color);
        add(appNameLabel);

        // Crear el JTextArea para el texto al final de la animación
        textArea = new JTextArea();
        textArea.setBounds(50, 250, 400, 100);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        add(textArea);

        // Crear un hilo para la animación del JLabel
        Thread animationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Animar el JLabel moviéndolo hacia arriba y cambiando de color
                    while (yPosition > 50 || !color.equals(Color.WHITE)) {
                        if (yPosition > 50) { // Mover hacia arriba
                            yPosition -= 2;
                        }

                        if (color.getRed() < 255) { // Cambiar color a blanco
                            int red = Math.min(255, color.getRed() + 2);
                            int green = Math.min(255, color.getGreen() + 2);
                            int blue = Math.min(255, color.getBlue() + 2);
                            color = new Color(red, green, blue);
                        }

                        // Actualizar la posición y el color en el EDT
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                appNameLabel.setBounds(100, yPosition, 300, 50);
                                appNameLabel.setForeground(color);
                            }
                        });

                        Thread.sleep(30); // Pausar brevemente entre cada actualización
                    }

                    // Después de la animación, escribir el texto carácter por carácter
                    escribirTextoCaracterPorCaracter("Este es el texto de introducción que aparecerá en el JTextArea...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        animationThread.start(); // Iniciar el hilo de la animación
    }

    // Función para escribir el texto carácter por carácter en el JTextArea
    private void escribirTextoCaracterPorCaracter(String texto) {
        Thread textThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < texto.length(); i++) {
                        final int index = i;

                        // Actualizar el JTextArea en el EDT
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                textArea.append(String.valueOf(texto.charAt(index)));
                            }
                        });

                        Thread.sleep(50); // Pausa entre cada carácter
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        textThread.start(); // Iniciar el hilo de escritura del texto
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IntroAppWithThread().setVisible(true);
            }
        });
    }
}
