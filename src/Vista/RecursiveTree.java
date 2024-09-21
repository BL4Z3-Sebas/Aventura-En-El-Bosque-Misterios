package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RecursiveTree extends javax.swing.JPanel {

    float theta;
    float a = 0;
    float r = 0;

    public RecursiveTree() {
        setBackground(Color.BLACK);
        Timer timer = new Timer(16, e -> repaint()); // ~60 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);

        if (r < 30) {
            r += 0.1;
            a += 0.03 - 0.01 * r + 0.002 * Math.pow(r, 2);

            if (a > 20) {
                a = 20;
            }

        }

        theta = (float) Math.toRadians(a);

        AffineTransform old = g2d.getTransform();
        g2d.translate(getWidth() / 2, getHeight());
        
        g2d.drawLine(0, 0, 0, -215);
        g2d.translate(0, -215);

        branch(g2d, getHeight() / 2.5f);

        g2d.setTransform(old);
                System.out.println("t");

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
