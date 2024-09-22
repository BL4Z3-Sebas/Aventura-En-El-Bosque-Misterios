package niveles;

import java.io.InputStream;
import musica.Audio;

public class Nivel {

    private int num_nivel;
    private String previa;
    private String titulo;
    private String historia;
    private String acertijo;
    private String[] respuetas;
    private String solucion;
    private boolean visitado;
    private Audio audio;

    public Nivel() {
    }

    public String getSolucion() {
        return solucion;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public int getNum_nivel() {
        return num_nivel;
    }

    public void setNum_nivel(int num_nivel) {
        this.num_nivel = num_nivel;
    }

    public String getAcertijo() {
        return acertijo;
    }

    public void setAcertijo(String acertijo) {
        this.acertijo = acertijo;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String[] getRespuetas() {
        return respuetas;
    }

    public void setRespuetas(String[] respuetas) {
        this.respuetas = respuetas;
    }

    public String getPrevia() {
        return previa;
    }

    public void setPrevia(String previa) {
        this.previa = previa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAudio(String cad) {
        InputStream audioStream = getClass().getResourceAsStream(cad);
        if (audioStream != null) {
            this.audio.setSound(audioStream);
        } else {
            System.err.println("No se encontró el archivo de sonido");
        }
        this.audio = audio;
    }

}
