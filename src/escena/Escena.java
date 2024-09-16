package escena;

import java.io.IOException;
import lista.Lista;
import musica.Audio;

public class Escena {
   public Lista dia;
   public Audio audio;

   public Escena() {
       this.dia = new Lista();  // Inicializa 'dia'
       this.audio = new Audio();  // Inicializa 'audio'
   }
   public void ejecutar() throws IOException{
       this.dia.showLista();
       this.audio.playSound();
   
   }
}

