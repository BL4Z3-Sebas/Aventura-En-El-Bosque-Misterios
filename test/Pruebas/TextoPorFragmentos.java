package Pruebas;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TextoPorFragmentos {

    private JTextPane textPane;
    private List<String> fragmentosTexto;
    private int indiceFragmentoActual;

    public TextoPorFragmentos() {
        // Crear el JTextPane
        textPane = new JTextPane();
        textPane.setEditable(false);  // Evitar que el usuario edite el texto

        // Crear un JScrollPane para el JTextPane
        JScrollPane scrollPane = new JScrollPane(textPane);

        // Configurar la ventana
        JFrame frame = new JFrame("Texto por fragmentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Agregar el evento de clic en el JTextPane
        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarSiguienteFragmento();  // Mostrar el siguiente fragmento al hacer clic
            }
        });
    }

    public void dividirTextoEnFragmentos(String dialogo) {
        // Dividir el texto en fragmentos que quepan en el JTextPane
        fragmentosTexto = new ArrayList<>();

        // Dividir el texto cada 200 caracteres (puedes ajustar esto según el tamaño del JTextPane)
        int longitudFragmento = 200;
        for (int i = 0; i < dialogo.length(); i += longitudFragmento) {
            fragmentosTexto.add(dialogo.substring(i, Math.min(dialogo.length(), i + longitudFragmento)));
        }

        // Inicialmente mostrar el primer fragmento
        indiceFragmentoActual = 0;
        mostrarSiguienteFragmento();
    }

    public void mostrarSiguienteFragmento() {
        if (indiceFragmentoActual < fragmentosTexto.size()) {
            // Obtener el fragmento actual
            String fragmento = fragmentosTexto.get(indiceFragmentoActual);

            // Obtener el StyledDocument para el JTextPane
            StyledDocument doc = textPane.getStyledDocument();
            try {
                // Limpiar el JTextPane
                doc.remove(0, doc.getLength());

                // Crear un conjunto de atributos para centrar el texto
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

                // Aplicar los atributos al documento
                doc.setParagraphAttributes(0, doc.getLength(), center, false);

                // Insertar el fragmento de texto
                doc.insertString(doc.getLength(), fragmento, null);

                // Actualizar el índice para el próximo fragmento
                indiceFragmentoActual++;
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        } else {
            // No hay más fragmentos, puedes mostrar un mensaje o finalizar la secuencia
            JOptionPane.showMessageDialog(textPane, "Fin del texto.");
        }
    }

    public static void main(String[] args) {
        TextoPorFragmentos ejemplo = new TextoPorFragmentos();
        String textoCompleto = "Este es un ejemplo de texto largo que se mostrará por partes. "
                + "Cada vez que hagas clic en el área de texto, se mostrará el siguiente fragmento "
                + "hasta que todo el texto haya sido revelado. Esta técnica es útil cuando no "
                + "quieres mostrar todo el texto de una vez.";

        // Dividir el texto en fragmentos y comenzar a mostrar
        ejemplo.dividirTextoEnFragmentos(textoCompleto);
    }
}
