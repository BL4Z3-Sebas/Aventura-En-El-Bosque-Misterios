package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RecursiveTree extends JPanel {
    
    private static final int MAX_R = 17;
    private static final int MAX_COLOR_VALUE = 255;
    private static final int INITIAL_BRANCH_LENGTH = 260;
    
    private float theta;
    private float a = 0;
    private float r = 0;
    private static Timer timer;

    private final float velocidadMaxima = 1.5f; // Velocidad máxima que queremos alcanzar
    private float velocidadActual = 0.0001f; // Velocidad inicial lenta
    private final float aceleracion = 0.001f; // Aceleración que incrementa la velocidad

    public RecursiveTree() {
        setBackground(Color.BLACK);
        timer = new Timer(16, e -> repaint()); // ~60 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calcular el color actual
        int colorValue = calcularColor();
        g2d.setColor(new Color(colorValue, colorValue, colorValue));

        actualizarParametros();

        theta = (float) Math.toRadians(a);
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(90), getWidth() / 2, getHeight() / 2);
        g2d.translate(getWidth() / 2, getHeight());

        g2d.drawLine(0, 100, 0, -INITIAL_BRANCH_LENGTH);
        g2d.translate(0, -INITIAL_BRANCH_LENGTH);

        branch(g2d, getHeight() / 2.5f);

        g2d.setTransform(old);
    }

    private int calcularColor() {
        int colorValue = (int) (125 + r / 17 * 130);  // Interpolación lineal de 0 a 255
        return Math.min(colorValue, MAX_COLOR_VALUE); // Aseguramos que no pase de 255
    }

    private void actualizarParametros() {
        if (r < MAX_R) {
            r += velocidadActual; // Aumentar r usando la velocidad actual
            a += 0.03 - 0.01 * r + 0.002 * Math.pow(r, 2);

            // Incrementar la velocidad actual con aceleración, pero no exceder la velocidad máxima
            if (velocidadActual < velocidadMaxima) {
                velocidadActual += aceleracion;
            }
        } else {
            timer.stop();
        }
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
}
