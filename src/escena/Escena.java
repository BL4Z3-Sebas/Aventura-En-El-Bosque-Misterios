package escena;

import lista.Lista;
import musica.Audio;

/**
 *
 * @author andre
 */
public class Escena {
   public Lista dia;
   public Audio audio;

   public Escena() {
       this.dia = new Lista();  // Inicializa 'dia'
       this.audio = new Audio();  // Inicializa 'audio'
   }
   public void ejecutar(){
       this.dia.showLista();
       this.audio.playSound();
   
   }
}

