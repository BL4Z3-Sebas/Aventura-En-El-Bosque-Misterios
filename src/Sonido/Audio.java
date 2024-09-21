package Sonido;

import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;

public class Audio {

    private Clip clip;
    private FloatControl volumenControl;
    private Thread reproductor;

    public Audio(String rutaArchivo, int volumenInicio) {
        this.setClip(rutaArchivo);
        this.setVolumenInicio(volumenInicio);
        this.setReproductor();
    }

    private void setClip(String rutaArchivo) {
        AudioInputStream audioStream;
        try {
            // Cargamos el archivo de sonido como un objeto AudioInputStream
            audioStream = AudioSystem.getAudioInputStream(new File(rutaArchivo));

            // Creamos un Clip que es lo que usamos para controlar el audio
            this.clip = AudioSystem.getClip();
            this.clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Imprime cualquier error que ocurra
            System.out.println(e);
        }
    }

    private void setVolumenInicio(int volumen) {
        if (volumen > 100) {
            volumen = 100;
        }
        if (volumen < 0) {
            volumen = 0;
        }
        this.volumenControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        this.volumenControl.setValue(volumen * 86.0f / 100 - 80.0f);
    }

    private void setReproductor() {
        this.reproductor = new Thread(() -> {
            try {
                this.clip.loop(Clip.LOOP_CONTINUOUSLY);
                while (true) {
                    float volumenActual = this.volumenControl.getValue();
                    if (volumenActual > 6.0f) {
                        break;
                    }
                    this.volumenControl.setValue(volumenActual + 1f);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
    }

    public void playSound() {
        if (this.clip == null) {
            return;
        }
        this.clip.setFramePosition(0);  // Reiniciar el audio desde el principio
        this.clip.start();  // Reproducir el sonido
    }

    public void stopSound() {
        if (this.clip == null) {
            return;
        }
        this.reproductor.interrupt();// Detener el sonido si está sonando
    }

    public void closeClip() {
        if (this.clip == null) {
            return;
        }
        this.clip.close();  // Cerrar el clip para liberar recursos
    }

    // Método para hacer que el sonido se repita continuamente
    public void loopSound() {
        if (this.clip == null) {
            return;
        }
        this.reproductor.start();
    }
}
