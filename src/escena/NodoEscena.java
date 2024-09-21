package escena;

public class NodoEscena {

    public NodoEscena next;
    public NodoEscena back;
    public Escena esc;

    public NodoEscena() {
        this.next = null;
        this.back = null;
        this.esc = null;
    }

}
