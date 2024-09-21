package juego;

import arbol.Arbol;
import arbol.Nodo;
import escena.Escena;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juego {

    Arbol arbol = new Arbol();

    public Juego() {
        // Inicializa el árbol
    }

    public void ejecutar() throws IOException {

        Escena esc = new Escena();
        // Añadir diálogo a la lista
        /* esc.dia.añadir("Año 4202");
        esc.dia.añadir("La humanidad vivía su mejor momento");
        esc.dia.añadir("Dominaban todo el sistema solar");
        esc.dia.añadir("La necesidad de energía y recursos no era un problema");
        esc.dia.añadir("Pero...");
        esc.dia.añadir("Aún con una vida que para otras especies seria perfecta");
        esc.dia.añadir("Su curiosidad y deseo por llevar las leyes naturales al extremo tendría consecuencias");
         */
        // Cargar el sonido desde los recursos
//        InputStream audioStream = getClass().getResourceAsStream("/musica/Escape.wav");
//        if (audioStream != null) {
//            esc.audio.setSound(audioStream);
//        } else {
//            System.err.println("No se encontró el archivo de sonido");
//        }
    
        // Asignar la escena al nodo raíz
        arbol.getRaiz().setEsc(esc);
        ejecutarRecursivo(arbol.getRaiz());
    }

    private void ejecutarRecursivo(Nodo nodo) {
        if (nodo != null) {
            try {
                nodo.getEsc().ejecutar();
            } catch (IOException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
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
