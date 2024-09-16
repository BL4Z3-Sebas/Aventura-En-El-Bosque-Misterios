package Main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import niveles.GeneradorNiveles;
import niveles.Nivel;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.setOut(new PrintStream(System.out, true, "utf-8"));

        Nivel nivel = new Nivel();
        nivel = GeneradorNiveles.crearNivel("nivel_1");
        System.out.println(nivel.getTitulo());
        System.out.println("");

        int longitudMaxima = 50;
        int indice = 0;

        while (indice < nivel.getHistoria().length()) {
            int espacio = nivel.getHistoria().indexOf(" ", indice + longitudMaxima);
            if (espacio == -1) {
                espacio = nivel.getHistoria().length();
            }
            String linea = nivel.getHistoria().substring(indice, espacio);
            System.out.println(linea);
            indice = espacio + 1;
        }

        //System.out.println(nivel.getHistoria());
        System.out.println("");
        System.out.println(nivel.getAcertijo().replace("\t", "\n"));
        System.out.println("");
        System.out.println("Opciones: " + Arrays.toString(nivel.getRespuetas()));
        System.out.println("");
        System.out.println("Solucion: " + nivel.getSolucion());
    }

}
