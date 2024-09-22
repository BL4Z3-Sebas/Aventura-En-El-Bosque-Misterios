package niveles;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public final class Escena {
//    private static Escena instancia;

    private Thread escritor;
    private ArrayList<String> dialogos = new ArrayList<>();
    private int indiceParte = 0;
    private JTextArea area;

    public Escena() {
    }

    public void mostrarParte(boolean esRetroceso) {
        area.setText("");

        if (esRetroceso) {
            area.setText(dialogos.get(indiceParte));
        } else {
            escribirDialogo(dialogos.get(indiceParte));
        }
    }

    public void parteSiguiente() {
        if (indiceParte < dialogos.size() - 1) {
            indiceParte++;
            mostrarParte(false);
        }
    }

    public void parteAnterior() throws InterruptedException {
        if (indiceParte > 0 && !escritor.isAlive()) {
            indiceParte--;
            mostrarParte(true);
        }
    }

    public void escribirDialogo(String dialogo) {
        escritor = new Thread(() -> {
            char[] caracteres = dialogo.toCharArray();
            for (char c : caracteres) {
                final char caracterActual = c;
                SwingUtilities.invokeLater(() -> area.append(String.valueOf(caracterActual)));
                try {
                    switch (caracterActual) {
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
        });
        escritor.start();
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
        this.dialogos.clear();
        this.indiceParte = 0;
    }
}
