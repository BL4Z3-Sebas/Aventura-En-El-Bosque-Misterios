package niveles;

import arbol.Arbol;
import arbol.Nodo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GeneradorNiveles {

//    int[] id_niveles = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
    static int[] id_niveles_temp = {8, 4, 12};

    public static Nivel crearNivel(Nivel lvl, int nivel) {
        String dir = "src/archivos/nivel_" + String.valueOf(nivel);

        try {
            BufferedReader br = new BufferedReader(new FileReader(dir + "/historia.txt"));
            String linea = br.readLine();
            String[] datos = linea.split(";");
            lvl.setTitulo(datos[0]);
            lvl.setHistoria(datos[1]);
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader(dir + "/acertijos.txt"));
            String linea2 = br2.readLine();
            String[] datos2 = linea2.split(";");
            lvl.setAcertijo(datos2[0]);
            String res = datos2[1];
            lvl.setRespuetas(res.split("/"));
            lvl.setSolucion(lvl.getRespuetas()[0]);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return lvl;
    }

    public static void generarArbolNiveles() {
        Arbol a = Arbol.getInstancia();
        for (int id : id_niveles_temp) {
            Nivel nivel = new Nivel();
            nivel.setId(id);
            a.agregar(nivel);
            nivel.setNum_nivel(a.alturaNivel(id));
            nivel = crearNivel(nivel, nivel.getNum_nivel());
//            a.actualizarNodo(nivel, nivel);
        }
    }
}
