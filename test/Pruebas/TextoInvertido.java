package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TextoInvertido extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Crear un BufferedImage del tamaño del panel
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        // Dibujar fondo en la imagen
        Graphics2D gImg = img.createGraphics();
        gImg.setColor(Color.WHITE); // Fondo blanco
        gImg.fillRect(0, 0, getWidth(), getHeight());

        // Dibujar algo debajo del texto (ejemplo, un degradado de colores)
        GradientPaint gradient = new GradientPaint(0, 0, Color.RED, getWidth(), getHeight(), Color.BLUE);
        gImg.setPaint(Color.blue);
        gImg.fillRect(0, 0, getWidth(), getHeight());

        // Definir las coordenadas y tamaño del área del texto
        String texto = "Texto Semitransparente";
        Font font = new Font("Arial", Font.BOLD, 50);
        FontMetrics fm = gImg.getFontMetrics(font);
        int textX = 50;
        int textY = 100;

        // Crear una máscara del área del texto para invertir colores
        gImg.setFont(font);
        Shape textShape = fm.getStringBounds(texto, gImg).getBounds2D();

        // Invertir los colores debajo del área del texto
        for (int y = textY - fm.getAscent(); y < textY; y++) {
            for (int x = textX; x < textX + fm.stringWidth(texto); x++) {
                if (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight()) {
                    // Obtener el color actual
                    int rgb = img.getRGB(x, y);

                    // Invertir los colores (0xFFFFFF - RGB)
                    int invertedRgb = (0xFFFFFF - (rgb & 0xFFFFFF)) | (rgb & 0xFF000000);

                    // Asignar el color invertido al píxel
                    img.setRGB(x, y, invertedRgb);
                }
            }
        }

        // Dibujar la imagen procesada
        g2d.drawImage(img, 0, 0, null);

        // Establecer transparencia (0.0f es totalmente transparente, 1.0f es totalmente opaco)
        float alpha = 0.5f; // 50% de transparencia
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // Dibujar el texto semitransparente sobre el área de colores invertidos
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString(texto, textX, textY);

        gImg.dispose(); // Liberar recursos del Graphics
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Texto con Colores Invertidos");
        TextoInvertido panel = new TextoInvertido();
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
