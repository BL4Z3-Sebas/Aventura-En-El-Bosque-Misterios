package Main;

import escena.Escena;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import musica.AudioRunnable;
import niveles.GeneradorNiveles;
import niveles.Nivel;

public class Main {

    public static void main(String[] args) {

        try {
            System.setOut(new PrintStream(System.out, true, "utf-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Nivel nivel = GeneradorNiveles.crearNivel("nivel_1");
        System.out.println(nivel.getTitulo());
        System.out.println("");
        Escena escena = new Escena();

        // Ejecutar el audio en un hilo separado
        Thread audioThread = new Thread(new AudioRunnable(escena, "Escape.wav"));
        audioThread.start();
        Escena.escribirDialogo(nivel.getHistoria());

        System.out.println("");

        System.out.println(nivel.getAcertijo().replace("\t", "\n"));
        System.out.println("");

        Collections.shuffle(Arrays.asList(nivel.getRespuetas()));
        System.out.println("Opciones: " + Arrays.toString(nivel.getRespuetas()));
        System.out.println("");

        System.out.println("Solucion: " + nivel.getSolucion());
        
        //Juego juego = new Juego();      
        //juego.ejecutar();
    }
}
