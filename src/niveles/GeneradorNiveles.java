package niveles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GeneradorNiveles {

    public static Nivel crearNivel(String nivel) {
        String dir = "src/archivos/" + nivel;
        Nivel lvl = new Nivel();

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
            lvl.setRespuetas(res.split("\t"));
            lvl.setSolucion(lvl.getRespuetas()[0]);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return lvl;
    }
}
