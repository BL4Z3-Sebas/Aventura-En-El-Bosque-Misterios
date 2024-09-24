package vista;

import arbol.Arbol;
import javax.swing.*;
import java.awt.*;
import arbol.Nodo;
import niveles.Apuntador;

public class ArbolMapa extends JPanel {

    private final Arbol arbol;
    private final Apuntador apuntador;
    private final Color colorCyanOscuro = new Color(204, 204, 204);

    public ArbolMapa(Arbol arbol) {
        this.arbol = arbol;
        this.apuntador = Apuntador.getInstancia();
        this.setBackground(Color.BLACK); // Fondo negro
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cambiar a Graphics2D para líneas más gruesas
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3)); // Grosor de las líneas

        // Configurar la fuente
        g2d.setFont(new Font("Blackadder ITC", Font.PLAIN, 36));
        g2d.setColor(colorCyanOscuro);

        if (arbol.getRaiz() != null) {
            // Iniciar el dibujo desde el centro del panel
            int panelWidth = getWidth();
            int startX = panelWidth / 2; // Posición X central del panel
            int startY = 30; // Posición Y inicial
            int horizontalOffset = panelWidth / 4; // Desplazamiento horizontal inicial
            dibujarNodo(g2d, arbol.getRaiz(), startX, startY, horizontalOffset, 1);
        }
    }

    private void dibujarNodo(Graphics2D g, Nodo nodo, int x, int y, int offsetX, int nivel) {
        if (nodo == null) {
            return;
        }

        // Dibujar conexiones (líneas) hacia los hijos
        if (nodo.getLeft() != null) {
            g.drawLine(x, y, x - offsetX, y + 60); // Conexión a la izquierda
            dibujarNodo(g, nodo.getLeft(), x - offsetX, y + 60, offsetX / 2, nivel + 1);
        }
        if (nodo.getRight() != null) {
            g.drawLine(x, y, x + offsetX, y + 60); // Conexión a la derecha
            dibujarNodo(g, nodo.getRight(), x + offsetX, y + 60, offsetX / 2, nivel + 1);
        }

        // Dibujar el nodo como un círculo
        g.fillOval(x - 20, y - 20, 40, 40);

        // Dibujar el ID del nodo dentro del círculo
        g.setColor(Color.BLACK); // Texto negro sobre fondo cian
        g.drawString(" ", x - 10, y + 10);
        g.setColor(colorCyanOscuro); // Restaurar el color cian oscuro

        // Resaltar la ubicación del jugador
        if (nodo == apuntador.getNodo()) {
            g.setColor(Color.RED); // Resaltar el nodo del jugador en rojo
            g.drawOval(x - 25, y - 25, 50, 50); // Borde más grande
            g.setColor(colorCyanOscuro); // Restaurar el color original para otros nodos
        }
    }
}
