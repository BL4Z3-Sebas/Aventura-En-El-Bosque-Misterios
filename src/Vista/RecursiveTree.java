package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RecursiveTree extends javax.swing.JPanel {

    float theta;
    float a = 0;
    float r = 0;
    Timer timer;

    float velocidadMaxima = 1.5f; // Velocidad máxima que queremos alcanzar
    float velocidadActual = 0.0001f; // Velocidad inicial lenta
    float aceleracion = 0.001f; // Aceleración que incrementa la velocidad

    public RecursiveTree() {
        setBackground(Color.BLACK);
        timer = new Timer(16, e -> repaint()); // ~60 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calcular el color actual basado en el progreso de r
        // r varia de 0 a 30, así que usamos un rango de 0 a 255 para el color
        int colorValue = (int) (125 + r / 17 * 130);  // Interpolación lineal de 0 (oscuro) a 255 (blanco)
        colorValue = Math.min(colorValue, 255); // Aseguramos que no pase de 255
        g2d.setColor(new Color(colorValue, colorValue, colorValue)); // Color de gris oscuro a blanco

        if (r < 17) {
            r += velocidadActual; // Aumentar r usando la velocidad actual
            a += 0.03 - 0.01 * r + 0.002 * Math.pow(r, 2);

//            if (a > 17) {
//                a = 17;
//            }
            // Incrementar la velocidad actual con aceleración, pero no exceder la velocidad máxima
            if (velocidadActual < velocidadMaxima) {
                velocidadActual += aceleracion;
            }
        } else {
            timer.stop();
        }

        theta = (float) Math.toRadians(a);

        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(90), getWidth() / 2, getHeight() / 2);
        g2d.translate(getWidth() / 2, getHeight());

        g2d.drawLine(0, 100, 0, -260);
        g2d.translate(0, -260);

        branch(g2d, getHeight() / 2.5f);

        g2d.setTransform(old);
    }

    private void branch(Graphics2D g2d, float h) {
        h *= 2 / 3f;

        if (h > 4) {
            AffineTransform old = g2d.getTransform();

            g2d.rotate(theta);
            g2d.drawLine(0, 0, 0, (int) -h);
            g2d.translate(0, -h);
            branch(g2d, h);

            g2d.setTransform(old);
            g2d.rotate(-theta);
            g2d.drawLine(0, 0, 0, (int) -h);
            g2d.translate(0, -h);
            branch(g2d, h);

            g2d.setTransform(old);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Tree");

        RecursiveTree panel = new RecursiveTree();
        frame.add(panel);
        frame.setUndecorated(true); // Oculta bordes de la ventana

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
