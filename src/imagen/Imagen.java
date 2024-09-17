package imagen;

import javax.swing.*;
import java.awt.*;

public class Imagen {

    public static void ejecutarImagen(String cad) {
        // Obtener el recurso como URL
        java.net.URL imgURL = Imagen.class.getResource(cad);

        if (imgURL == null) {
            System.out.println("Error: No se pudo cargar la imagen.");
            return;
        }

        // Cargar la imagen usando ImageIcon
        ImageIcon icon = new ImageIcon(imgURL);

        // Redimensionar la imagen (ajustar el tamaño)
        Image image = icon.getImage(); // Obtener el objeto Image del icono
        Image scaledImage = image.getScaledInstance(1280, 720, Image.SCALE_SMOOTH); // Redimensionar a 300x200 (puedes ajustar)
        icon = new ImageIcon(scaledImage); // Crear un nuevo ImageIcon con la imagen redimensionada

        // Crear el JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Quitar la barra de título y decoración
        frame.setUndecorated(true);

        // Crear un JPanel con FlowLayout para alinear la imagen a la izquierda
        JPanel leftAlignedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Crear una etiqueta con la imagen
        JLabel label = new JLabel(icon);

        // Añadir la etiqueta al panel
        leftAlignedPanel.add(label);

        // Añadir el panel en la parte central (CENTER) del JFrame usando BorderLayout
        frame.setLayout(new BorderLayout());
        frame.add(leftAlignedPanel, BorderLayout.CENTER);

        // Ajustar el tamaño del JFrame al tamaño de la imagen
        frame.pack();

        // Mostrar el JFrame
        frame.setVisible(true);
    }
}
