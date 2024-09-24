package niveles;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public final class Escena {

    private Thread escritor;
    private List<String> dialogos = new ArrayList<>();
    private int indiceParte = 0;
    private JTextArea area;
    private boolean dialogoCompleto = false; // Variable para rastrear si el diálogo completo se ha mostrado

    public Escena() {
    }

    public void mostrarParte(boolean esRetroceso) {
        if (esRetroceso) {
            area.setText(dialogos.get(indiceParte));
            dialogoCompleto = true; // Cuando retrocedes, se muestra el diálogo completo
        } else {
            if (dialogoCompleto) {
                // Si el diálogo ya se mostró completamente, solo lo mostramos sin reescribirlo
                area.setText(dialogos.get(indiceParte));
            } else {
                area.setText(""); // Limpia el área antes de escribir
                escribirDialogo(dialogos.get(indiceParte));
            }
        }
    }

    public void parteSiguiente() {
        if (hayPosterior()) {
            indiceParte++;
            mostrarParte(false);
            dialogoCompleto = true; // Marcar el diálogo como completo al avanzar
        }
    }

    public void parteAnterior() {
        if (hayPrevio() && !escritor.isAlive()) {
            indiceParte--;
            mostrarParte(true);
            dialogoCompleto = true; // Al retroceder, se muestra el diálogo completo
        }
    }

    private void escribirDialogo(String dialogo) {
        escritor = new Thread(() -> {
            for (char caracterActual : dialogo.toCharArray()) {
                SwingUtilities.invokeLater(() -> area.append(String.valueOf(caracterActual)));
                dormirPorCaracter(caracterActual);
            }
        });
               escritor.start();
    }

    private void dormirPorCaracter(char caracter) {
        try {
            switch (caracter) {
                case '.':
                    Thread.sleep(500);
                    break;
                case ',':
                    Thread.sleep(200);
                    break;
                default:
                    Thread.sleep(50);
                    break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Thread getEscritor() {
        return escritor;
    }

    public void setEscritor(Thread escritor) {
        this.escritor = escritor;
    }

    public JTextArea getArea() {
        return area;
    }

    public void setArea(JTextArea area) {
        this.area = area;
    }

    public boolean hayPrevio() {
        return indiceParte > 0;
    }

    public boolean hayPosterior() {
        return !escritor.isAlive() && indiceParte < dialogos.size() - 1;
    }

    public void agregarDialogo(String dialogo) {
        dialogos.add(dialogo);
    }

    public void reset() {
        dialogos.clear();
        indiceParte = 0;
        dialogoCompleto = false; // Reiniciar el estado del diálogo al restablecer
    }
}
