package Pruebas;

import javax.swing.*;
import java.awt.*;

public class TituloPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Establecer el texto a dibujar
        String text = "Texto Vertical";

        // Establecer fuente y color
        g2d.setFont(new Font("Blackadder ITC", Font.PLAIN, 200));
        g2d.setColor(Color.BLACK);

        // Aplicar rotación de -90 grados para que el texto sea vertical
        g2d.rotate(Math.toRadians(-90), getWidth() / 2, getHeight() / 2);

        // Dibujar el texto en la posición deseada
        g2d.drawString(text, getWidth() / 2 - 50, getHeight() / 2);

        // Restaurar la transformación original (opcional si dibujas más cosas)
        g2d.setTransform(g2d.getTransform());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vertical Text Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Añadir el panel personalizado al JFrame
        TituloPanel panel = new TituloPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
