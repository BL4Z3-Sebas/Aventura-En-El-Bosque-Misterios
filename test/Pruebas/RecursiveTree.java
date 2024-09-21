package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class RecursiveTree extends JPanel {

    float theta;
    float a = 0;
    float r = 0;

    public RecursiveTree() {
        setPreferredSize(new Dimension(1980, 1080));
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
            r += .1;
            a += 0.03 - 0.01 * r + 0.002 * Math.pow(r, 2);

            if (a > 20) {
                a = 20;
            }
        }

        theta = (float) Math.toRadians(a);

        // Translate to bottom center of screen
        AffineTransform old = g2d.getTransform();
        g2d.translate(getWidth() / 2, getHeight());

        // Draw the main branch
        g2d.drawLine(0, 0, 0, -215);
        g2d.translate(0, -215);

        // Start the recursive tree
        branch(g2d, getHeight() / 2.5f);

        g2d.setTransform(old); // Reset transform to original
    }

    private void branch(Graphics2D g2d, float h) {
        // Reduce branch length
        h *= 2 / 2.99999f;

        if (h > 4) {
            // Save current transform
            AffineTransform old = g2d.getTransform();

            // Rotate by theta and draw branch
            g2d.rotate(theta);
            g2d.drawLine(0, 0, 0, (int) -h);
            g2d.translate(0, -h);
            branch(g2d, h);

            // Restore transform and do the opposite rotation
            g2d.setTransform(old);
            g2d.rotate(-theta);
            g2d.drawLine(0, 0, 0, (int) -h);
            g2d.translate(0, -h);
            branch(g2d, h);

            // Restore the transformation
            g2d.setTransform(old);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Tree");
        RecursiveTree panel = new RecursiveTree();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
//        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
