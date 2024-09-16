package arbol;

import escena.Escena;

public class Nodo {

    public Nodo izq;
    public Nodo der;

    /**
     *
     */
    public Escena esc;

    public Nodo() {
        // Inicializa 'esc'
        this.esc = new Escena();
    }

}
