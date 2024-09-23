package niveles;

import arbol.Arbol;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GeneradorNiveles {

    private static final int[] id_niveles = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
    private static final Arbol arbol = Arbol.getInstancia();

    public static void crearNivel(int altura) {
        String dir = "src/archivos/nivel_" + String.valueOf(altura);

        try {
            ArrayList<String> historias = new ArrayList<>();
            ArrayList<Nivel> niveles = arbol.obtenerNodosDeNivel(altura);
            ArrayList<String> acertijos = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(dir + "/historia.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                historias.add(linea);
            }
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader(dir + "/acertijos.txt"));
            String linea2;
            while ((linea2 = br2.readLine()) != null) {
                acertijos.add(linea2);
            }
            br.close();

            Collections.shuffle(historias);
            Collections.shuffle(acertijos);
            Collections.shuffle(niveles);

            for (int i = 0; i < niveles.size(); i++) {
                Nivel nivel = niveles.get(i);
                String[] datosHistorias = historias.get(i).split(";");
                String[] datosAcertijos = acertijos.get(i).split(";");

                nivel.setTitulo(datosHistorias[0]);
                nivel.setHistoria(datosHistorias[1]);
                nivel.setAcertijo(datosAcertijos[0]);

                String[] respuestas = datosAcertijos[1].split("/");
                nivel.setSolucion(respuestas[0]);
                Collections.shuffle(Arrays.asList(respuestas));
                nivel.setRespuetas(respuestas);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void generarArbolNiveles() {
        for (int id : id_niveles) {
            Nivel nivel = new Nivel();
            nivel.setId(id);
            arbol.agregar(nivel);
            nivel.setNum_nivel(arbol.alturaNivel(id));

        }
        for (int i = 1; i < 5; i++) {
            crearNivel(i);
        }
    }
}
