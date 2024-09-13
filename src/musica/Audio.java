package musica;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    Clip clip;

    public void setSound(String filePath) {
        try {
            // Cargamos el archivo de sonido como un objeto AudioInputStream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            
            // Creamos un Clip que es lo que usamos para controlar el audio
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Imprime cualquier error que ocurra
        }
    }

    public void playSound() {
        if (clip != null) {
            clip.start();  // Reproducir el sonido
        }
    }

    public void stopSound() {
        if (clip != null) {
            clip.stop();   // Detener el sonido
        }
    }
}
