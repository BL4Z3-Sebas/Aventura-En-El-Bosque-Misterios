package arbol;

import escena.Escena;

public class Nodo {

    private Nodo izq;
    private Nodo der;
    private Escena esc;
    
    public Nodo() {
    }
    

    public Nodo(Escena escena) {
        this.esc = escena;
        this.izq = null;
        this.der = null;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public Escena getEsc() {
        return esc;
    }

    public void setEsc(Escena esc) {
        this.esc = esc;
    }
}
