package Main;

import Vista.MainFrame;
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
//        Imagen.ejecutarImagen("/imagen/lab.png");  // Asegúrate de que la ruta es correcta
//
//        System.setOut(new PrintStream(System.out, true, "utf-8"));
//
//        Nivel nivel = GeneradorNiveles.crearNivel("nivel_1");
//        System.out.println(nivel.getTitulo());
//        System.out.println("");
//        Escena escena = new Escena();
//
//        // Ejecutar el audio en un hilo separado
////        Thread audioThread = new Thread(new AudioRunnable(escena, "Escape.wav"));
////        audioThread.start();
//        Audio bgAudio = new Audio("src/musica/Escape.wav", 5);
//        bgAudio.loopSound();
//        Escena.escribirDialogo(nivel.getHistoria());
//
//        System.out.println("");
//
//        Escena.escribirAcertijo(nivel.getAcertijo());
//        //System.out.println(nivel.getAcertijo().replace("\t", "\n"));
//        System.out.println("");
//
//        Collections.shuffle(Arrays.asList(nivel.getRespuetas()));
//        System.out.println("Opciones: " + Arrays.toString(nivel.getRespuetas()));
//        System.out.println("");
//
//        System.out.println("Solucion: " + nivel.getSolucion());
//
//        //Juego juego = new Juego();      
//        //juego.ejecutar();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

        Nivel nivel = GeneradorNiveles.crearNivel("nivel_1");
        System.out.println(nivel.getTitulo());
        System.out.println("");
        Escena escena = new Escena();

        // Ejecutar el audio en un hilo separado
//        Thread audioThread = new Thread(new AudioRunnable(escena, "Escape.wav"));
//        audioThread.start();
        Audio bgAudio = new Audio("src/musica/Escape.wav", 5);
        bgAudio.loopSound();

//        Escena.escribirDialogo(nivel.getHistoria());
//
//        System.out.println("");
//
//        Escena.escribirAcertijo(nivel.getAcertijo());
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
