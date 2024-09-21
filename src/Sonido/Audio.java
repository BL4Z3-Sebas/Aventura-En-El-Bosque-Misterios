package Sonido;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Alfonso
 */
public class Audio {

    private Clip clip;
    private FloatControl volumenControl;

    public Audio(String rutaArchivo) {
        // Cargar el archivo de audio
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(rutaArchivo));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println(ex);
        }

        // Obtener el control de volumen
        volumenControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        // Establecer el volumen inicial en 0 (silencio)
        volumenControl.setValue(-80.0f); // El rango es de -80.0f a 6.0f
    }

    public void reproducirLoop() {
        // Reproducir la música en bucle
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        // Aumentar el volumen gradualmente
        Thread hiloVolumen = new Thread(() -> {
            try {
                while (true) {
                    float volumenActual = volumenControl.getValue();
                    if (volumenActual < 6.0f) {
                        volumenControl.setValue(volumenActual + 0.1f); // Aumentar el volumen en 0.1f cada vez
                    }
                    Thread.sleep(100); // Esperar 100ms antes de aumentar el volumen de nuevo
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        hiloVolumen.start();
    }

}
