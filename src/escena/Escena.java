package escena;

import java.io.IOException;
import lista.Lista;
import musica.Audio;
import niveles.Nivel;

public class Escena {

    public Nivel nivel;
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
    
    public void escribirHistoria(){
        String h_caacteres = nivel.getHistoria();
    }
}
