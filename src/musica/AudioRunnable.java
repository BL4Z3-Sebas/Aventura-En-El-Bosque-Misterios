package musica;

import escena.Escena;

public class AudioRunnable implements Runnable {

    private final Escena escena;
    private final String archivoAudio;

    public AudioRunnable(Escena escena, String archivoAudio) {
        this.escena = escena;
        this.archivoAudio = archivoAudio;
    }

    @Override
    public void run() {
//        escena.ejecutarAudio(archivoAudio);
    }
}
