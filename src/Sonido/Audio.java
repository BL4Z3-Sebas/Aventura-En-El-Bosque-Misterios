package Sonido;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    private Clip clip;
    private FloatControl volumenControl;
    private Thread reproductor;

    public Audio(String rutaArchivo, int volumenInicio) {
        setClip(rutaArchivo);
        setVolumenInicio(volumenInicio);
        setReproductor();
    }

    private void setClip(String rutaArchivo) {
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(rutaArchivo))) {
            this.clip = AudioSystem.getClip();
            this.clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error al cargar el archivo de audio: " + e.getMessage());
        }
    }

    private void setVolumenInicio(int volumen) {
        this.volumenControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        ajustarVolumen(volumen);
    }

    private void setReproductor() {
        this.reproductor = new Thread(() -> {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            while (true) {
                try {
                    float volumenActual = volumenControl.getValue();
                    if (volumenActual >= -5f) { // Utiliza el valor umbral para detener el aumento
                        break;
                    }
                    volumenControl.setValue(volumenActual + 1f);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restablece el estado de interrupción
                    break;
                }
            }
        });
    }

    public void ajustarVolumen(int volumen) {
        float nuevoVolumen = Math.max(-80.0f, Math.min(volumen * 86f / 100 - 80.0f, 6.0f));
        volumenControl.setValue(nuevoVolumen);
    }

    public void playSound() {
        if (clip != null) {
            clip.setFramePosition(0);  // Reiniciar el audio desde el principio
            clip.start();  // Reproducir el sonido
        }
    }

    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();  // Detener el sonido
            reproductor.interrupt(); // Detener el hilo del reproductor
        }
    }

    public void closeClip() {
        if (clip != null) {
            clip.close();  // Cerrar el clip para liberar recursos
        }
    }

    public void loopSound() {
        if (clip != null) {
            reproductor.start();
        }
    }
}
