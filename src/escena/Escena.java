package escena;

import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import musica.Audio;

public class Escena {

    public Audio audio;

    public Escena() {
//        this.audio = new Audio();  // Inicializa 'audio'
    }

    //no se usa
    public void ejecutar() throws IOException {
        this.audio.playSound();
    }

    public void ejecutardAudio(String archivoAudio) {
        if (archivoAudio == null || archivoAudio.isEmpty()) {
            System.err.println("El nombre del archivo de sonido es nulo o vacío.");
            return;
        }

        try {
            InputStream audioStream = getClass().getResourceAsStream("/musica/" + archivoAudio);
            if (audioStream != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioStream);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("No se encontró el archivo de sonido: " + archivoAudio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void escribirDialogo(String dialogo) {
        String[] palabras = dialogo.split("\\s+");
        int longitud = 0;
        for (String palabra : palabras) {
            System.out.print(palabra + " ");

            Escenario escenario = new Escenario();

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

    public static void escribirAcertijo(String acertijo) {
        String lineas[] = acertijo.split("\t");
        for (String linea : lineas) {
            System.out.println(linea);

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
