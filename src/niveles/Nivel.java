package niveles;

import Sonido.Audio;

public class Nivel {

    private int id;
    private int numNivel;
    private String previa;
    private String titulo;
    private String historia;
    private String acertijo;
    private String[] respuestas;
    private String solucion;
    private Audio audio;
    private String rutaImagen;
    private boolean visitado;
    private boolean finalBueno;

    // Constructor predeterminado, con valores iniciales
    public Nivel() {
        this.visitado = false;
        this.finalBueno = false;
    }

    // Constructor sobrecargado para facilitar la creación de niveles con datos básicos
    public Nivel(int id, String titulo, String historia, String acertijo, String[] respuestas, String solucion, String rutaImagen) {
        this.id = id;
        this.titulo = titulo;
        this.historia = historia;
        this.acertijo = acertijo;
        this.respuestas = respuestas;
        this.solucion = solucion;
        this.rutaImagen = rutaImagen;
        this.visitado = false;
    }

    // Getters y Setters simplificados
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int numNivel) {
        this.numNivel = numNivel;
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

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    // Reemplazo de "+" por nueva línea al obtener el acertijo
    public String getAcertijo() {
        return acertijo != null ? acertijo.replace('+', '\n') : "";
    }

    public void setAcertijo(String acertijo) {
        this.acertijo = acertijo;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public boolean isFinalBueno() {
        return finalBueno;
    }

    public void setFinalBueno(boolean finalBueno) {
        this.finalBueno = finalBueno;
    }

    // Método auxiliar para imprimir detalles del nivel
    @Override
    public String toString() {
        return "Nivel{"
                + "id=" + id
                + ", titulo='" + titulo + '\''
                + ", historia='" + historia + '\''
                + ", acertijo='" + acertijo + '\''
                + ", respuestas=" + String.join(", ", respuestas)
                + ", solucion='" + solucion + '\''
                + ", rutaImagen='" + rutaImagen + '\''
                + ", visitado=" + visitado
                + '}';
    }
}
