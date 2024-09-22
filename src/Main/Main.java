package Main;

import escena.Escena;
import imagen.Imagen;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import Sonido.Audio;
import niveles.GeneradorNiveles;
import niveles.Nivel;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Imagen.ejecutarImagen("/imagen/lab.png");  // Asegúrate de que la ruta es correcta

        System.setOut(new PrintStream(System.out, true, "utf-8"));

        Nivel nivel = GeneradorNiveles.crearNivel("nivel_1");
        System.out.println(nivel.getTitulo());
        System.out.println("");
        Escena escena = new Escena();

        // Ejecutar el audio en un hilo separado
//        Thread audioThread = new Thread(new AudioRunnable(escena, "Escape.wav"));
//        audioThread.start();
        Audio bgAudio = new Audio("src/musica/Escape.wav", 5);
        bgAudio.loopSound();

        Escena.escribirDialogo(nivel.getHistoria());

        System.out.println("");

        Escena.escribirAcertijo(nivel.getAcertijo());
        //System.out.println(nivel.getAcertijo().replace("\t", "\n"));
        System.out.println("");

        Collections.shuffle(Arrays.asList(nivel.getRespuetas()));
        System.out.println("Opciones: " + Arrays.toString(nivel.getRespuetas()));
        System.out.println("");

        System.out.println("Solucion: " + nivel.getSolucion());

        //Juego juego = new Juego();      
        //juego.ejecutar();
    }
}
