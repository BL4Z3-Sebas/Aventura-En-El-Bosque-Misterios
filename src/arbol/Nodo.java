package arbol;


import niveles.Nivel;

public class Nodo {

    private Nodo izq;
    private Nodo der;
    private Nivel nivel;

   

    public Nodo(Nivel nivel) {
        this.nivel = nivel;
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

    public Nivel getNivel() {
        return nivel;
    }

}
