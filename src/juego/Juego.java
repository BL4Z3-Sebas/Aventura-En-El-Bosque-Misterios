package juego;

import arbol.Arbol;
import arbol.Nodo;
import escena.Escena;
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

    public void ejecutar() {

        Escena esc = new Escena();
        // Añadir diálogo a la lista
        esc.dia.añadir("¡Bienvenido al bosque misterioso!");
        // Cargar el sonido desde los recursos
        InputStream audioStream = getClass().getResourceAsStream("/musica/Escape.wav");
        if (audioStream != null) {
            esc.audio.setSound(audioStream);
        } else {
            System.err.println("No se encontró el archivo de sonido");
        }
        // Asignar la escena al nodo raíz
        arbol.raiz.esc = esc;
        ejecutarRecursivo(arbol.raiz);
    }

    private void ejecutarRecursivo(Nodo nodo) {
        if (nodo != null) {
            nodo.esc.ejecutar();
            Scanner sc = new Scanner(System.in);
            int i;
            i = sc.nextInt();
            if (i == 1) {
                ejecutarRecursivo(nodo.izq);
            } else {
                ejecutarRecursivo(nodo.der);
            }
        }
    }

}
