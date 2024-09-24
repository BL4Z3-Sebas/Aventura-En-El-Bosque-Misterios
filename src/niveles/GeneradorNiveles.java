package niveles;

import arbol.Arbol;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneradorNiveles {

    private static final int[] ID_NIVELES = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
    private static final Arbol ARBOL = Arbol.getInstancia();
    private static final String BASE_DIR = "src/archivos/";

    public static void generarArbolNiveles() {
        for (int id : ID_NIVELES) {
            Nivel nivel = new Nivel();
            nivel.setId(id);
            ARBOL.agregar(nivel);
            nivel.setNumNivel(ARBOL.alturaNivel(id));
        }

        for (int i = 1; i < 5; i++) {
            crearNivel(i);
        }
    }

    private static void crearNivel(int altura) {
        List<String> historias = leerArchivo(BASE_DIR + "nivel_" + altura + "/historia.txt");
        List<String> acertijos = leerArchivo(BASE_DIR + "nivel_" + altura + "/acertijos.txt");
        List<Nivel> niveles = ARBOL.obtenerNodosDeNivel(altura);

        if (historias.isEmpty() || acertijos.isEmpty()) {
            System.err.println("Error: Archivos de historias o acertijos vacíos para el nivel " + altura);
            return;
        }

        // Mezclar los elementos para aleatoriedad
        Collections.shuffle(historias);
        Collections.shuffle(acertijos);
        Collections.shuffle(niveles);

        // Asignar datos a los niveles
        for (int i = 0; i < niveles.size(); i++) {
            asignarDatosANivel(niveles.get(i), historias.get(i), acertijos.get(i));
        }
    }

    private static List<String> leerArchivo(String ruta) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + ruta + " - " + e.getMessage());
        }
        return lineas;
    }

    private static void asignarDatosANivel(Nivel nivel, String historia, String acertijo) {
        String[] datosHistoria = historia.split(";");
        String[] datosAcertijo = acertijo.split(";");

        nivel.setTitulo(datosHistoria[0]);
        nivel.setHistoria(datosHistoria[1]);
        nivel.setAcertijo(datosAcertijo[0]);
        nivel.setRutaImagen(BASE_DIR + "imagenes/" + datosHistoria[0] + ".png");

        String[] respuestas = datosAcertijo[1].split("/");
        nivel.setSolucion(respuestas[0]);
        Collections.shuffle(Arrays.asList(respuestas));
        nivel.setRespuestas(respuestas);
    }
}
