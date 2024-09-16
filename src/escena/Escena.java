package escena;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import lista.Lista;
import musica.Audio;

public class Escena {

    public Lista dia;
    public Audio audio;

    public Escena() {
        this.dia = new Lista();  // Inicializa 'dia'
        this.audio = new Audio();  // Inicializa 'audio'
    }

    public void ejecutar() throws IOException {
        this.dia.showLista();
        this.audio.playSound();

    }

    public static void escribirDialogo(String dialogo) {
        String[] palabras = dialogo.split("\\s+");
        int longitud = 0;
        for (String palabra : palabras) {
            System.out.print(palabra + " ");
            longitud += palabra.length() + 1;
            if (longitud >= 45) {
                System.out.println("");
                longitud = 0;
            }

            try {
                if (palabra.endsWith(".") 
                        && palabra.charAt(0) != palabra.toUpperCase().charAt(0)) {
                    Thread.sleep(800);
                    System.out.println("");
                    longitud = 0;
                } else {
                    Thread.sleep(250);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("");
    }
}
