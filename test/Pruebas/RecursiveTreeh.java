package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RecursiveTreeh extends javax.swing.JPanel {

    float theta;
    float a = 0;
    float r = 0;
    Timer timer;

    public RecursiveTreeh() {
        setBackground(Color.BLACK);
        timer = new Timer(16, e -> repaint()); // ~60 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Cambiar el color de las líneas a blanco
        g2d.setColor(Color.WHITE);

        // Si el valor de r es menor que 30, continúa aumentando el ángulo a medida que avanza el tiempo
        if (r < 30) {
            r += 0.1;
            a += 0.03 - 0.01 * r + 0.002 * Math.pow(r, 2);

            if (a > 20) {
                a = 20;
            }
        } else {
            // Si r alcanza 30, detiene el timer
            timer.stop();
        }

        // Convertir el ángulo a radianes
        theta = (float) Math.toRadians(a);

        // Guardar la transformación original
        AffineTransform old = g2d.getTransform();

        // Aplicar la rotación de 90 grados a la derecha (en sentido de las agujas del reloj)
        g2d.rotate(Math.toRadians(90), getWidth() / 2, getHeight() / 2);

        // Trasladar el punto de origen al centro de la pantalla y hacia abajo para comenzar el dibujo
        g2d.translate(getWidth() / 2, getHeight());

        // Dibujar el tronco principal del árbol
        g2d.drawLine(0, 0, 0, -215);
        g2d.translate(0, -215);

        // Iniciar el dibujo de las ramas
        branch(g2d, getHeight() / 2.5f);

        // Restaurar la transformación original
        g2d.setTransform(old);
    }

    private void branch(Graphics2D g2d, float h) {
        // Reducir el tamaño de la rama en 2/3
        h *= 2 / 3f;

        // Condición base: Si la longitud de la rama es mayor a 4, dibujar ramas
        if (h > 4) {
            AffineTransform old = g2d.getTransform();

            // Rotar la rama hacia la derecha
            g2d.rotate(theta);
            g2d.drawLine(0, 0, 0, (int) -h); // Dibujar la rama
            g2d.translate(0, -h); // Moverse al final de la rama
            branch(g2d, h); // Recursión para continuar dibujando las ramas

            g2d.setTransform(old);

            // Rotar la rama hacia la izquierda
            g2d.rotate(-theta);
            g2d.drawLine(0, 0, 0, (int) -h); // Dibujar la rama hacia la izquierda
            g2d.translate(0, -h); // Moverse al final de la rama
            branch(g2d, h); // Recursión para continuar dibujando las ramas

            g2d.setTransform(old); // Restaurar la transformación original
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Tree");

        RecursiveTreeh panel = new RecursiveTreeh();
        frame.add(panel);
        frame.setUndecorated(true); // Oculta los bordes de la ventana

        // Obtener el dispositivo de pantalla para pantalla completa
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if (gd.isFullScreenSupported()) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setFullScreenWindow(frame); // Activa pantalla completa
        } else {
            frame.setSize(1980, 1080);
            frame.setVisible(true);
        }
    }
}
