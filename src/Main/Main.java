package Main;

import escena.Escena;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import niveles.GeneradorNiveles;
import niveles.Nivel;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "utf-8"));

//        String cadena = "Hola, mundo!";
//        for (int i = 0; i < cadena.length(); i++) {
//            char letra = cadena.charAt(i);
//            System.out.print(letra);
//            System.out.flush(); // fuerza la salida de la consola
//            try {
//                Thread.sleep(500); // pausa de 500 milisegundos (0,5 segundos)
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
        Nivel nivel = GeneradorNiveles.crearNivel("nivel_1");
        System.out.println(nivel.getTitulo());
        System.out.println("");

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
