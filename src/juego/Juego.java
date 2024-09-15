package juego;

import arbol.Arbol;
import escena.Escena;

/**
 *
 * @author andre
 */
public class Juego {

    public void ejecutar() {
        Arbol juego = new Arbol();  // If you're using Arbol elsewhere, keep this
        Escena esc = new Escena();  // Create the 'Escena' object, where 'dia' is initialized

        // Adding the dialogue to the list
        esc.dia.añadir("¡Bienvenido al bosque misterioso!");
        esc.audio.setSound("/musca/Escape.wav");
        // Display the list
        esc.dia.showLista();

        // Infinite loop (probably not needed unless for game engine)
        while(true){} 
    }
}
