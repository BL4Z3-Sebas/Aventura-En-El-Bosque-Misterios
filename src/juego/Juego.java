package juego;

import arbol.Arbol;
import arbol.Nodo;
import escena.Escena;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Juego {

    Arbol arbol;

    public Juego() {
        // Inicializa el árbol
        arbol = new Arbol();
    }

    public void ejecutar() throws IOException {

        Escena esc = new Escena();
        // Añadir diálogo a la lista
        esc.dia.añadir("Año 4202");
        esc.dia.añadir("La humanidad vivía su mejor momento");
        esc.dia.añadir("Dominaban todo el sistema solar");
        esc.dia.añadir("La necesidad de energía y recursos no era un problema");
        esc.dia.añadir("Pero...");
        esc.dia.añadir("Aún con una vida que para otras especies seria perfecta");
        esc.dia.añadir("Su curiosidad y deseo por llevar las leyes naturales al extremo tendría consecuencias");

        // Cargar el sonido desde los recursos
        InputStream audioStream = getClass().getResourceAsStream("/musica/Escape.wav");
        if (audioStream != null) {
            esc.audio.setSound(audioStream);
        } else {
            System.err.println("No se encontró el archivo de sonido");
        }
        // Asignar la escena al nodo raíz
        arbol.getRaiz().setEsc(esc);
        ejecutarRecursivo(arbol.getRaiz());
    }

    // Infinite loop (probably not needed unless for game engine)
    
    

    //while(true){} 

    private void ejecutarRecursivo(Nodo nodo) throws IOException {
        if (nodo != null) {
            nodo.getEsc().ejecutar();
            if (nodo.getIzq() != null && nodo.getDer() != null) {
                Scanner sc = new Scanner(System.in);
                int i;
                i = sc.nextInt();
                if (i == 1) {
                    ejecutarRecursivo(nodo.getIzq());
                } else {
                    ejecutarRecursivo(nodo.getDer());
                }
            }
        }
    }
}
