package musica;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Audio {

    private Clip clip;

    public void setSound(InputStream inputStream) {
        try {
            // Cargamos el archivo de sonido como un objeto AudioInputStream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

            // Creamos un Clip que es lo que usamos para controlar el audio
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Imprime cualquier error que ocurra
        }
    }

    public void playSound() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();  // Detener el clip si ya está sonando
            }
            clip.setFramePosition(0);  // Reiniciar el audio desde el principio
            clip.start();  // Reproducir el sonido
        }
    }

    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();   // Detener el sonido si está sonando
        }
    }

    public void closeClip() {
        if (clip != null) {
            clip.close();  // Cerrar el clip para liberar recursos
        }
    }

    // Método para hacer que el sonido se repita continuamente
    public void loopSound() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}
