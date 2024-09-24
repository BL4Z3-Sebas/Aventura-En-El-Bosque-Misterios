package Main;

import imagen.Imagen;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import Sonido.Audio;
import arbol.Arbol;
import niveles.Apuntador;
import niveles.GeneradorNiveles;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Imagen.ejecutarImagen("/imagen/lab.png");  // Asegúrate de que la ruta es correcta

        System.setOut(new PrintStream(System.out, true, "utf-8"));

//        Nivel nivel = GeneradorNiveles.crearNivel(1);
        Arbol arbol = Arbol.getInstancia();
        GeneradorNiveles.generarArbolNiveles();
        Apuntador apuntador = Apuntador.getInstancia();
        apuntador.setNodo(arbol.getRaiz());

        System.out.println(apuntador.getUbicacion().getTitulo());
        System.out.println("");

        // Ejecutar el audio en un hilo separado
//        Thread audioThread = new Thread(new AudioRunnable(escena, "Escape.wav"));
//        audioThread.start();
        Audio bgAudio = new Audio("src/archivos/sonidos/Escape.wav", 5);
        bgAudio.loopSound();

//        Escena.escribirDialogo(apuntador.getUbicacion().getHistoria());
        System.out.println("");

//        Escena.escribirAcertijo(apuntador.getUbicacion().getAcertijo());
        //System.out.println(nivel.getAcertijo().replace("\t", "\n"));
        System.out.println("");

        Collections.shuffle(Arrays.asList(apuntador.getUbicacion().getRespuestas()));
        System.out.println("Opciones: " + Arrays.toString(apuntador.getUbicacion().getRespuestas()));
        System.out.println("");

        System.out.println("Solucion: " + apuntador.getUbicacion().getSolucion());

        //Juego juego = new Juego();      
        //juego.ejecutar();
    }
}
