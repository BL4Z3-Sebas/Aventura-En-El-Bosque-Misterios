package arbol;

import escena.Escena;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
        // Inicializa 'raiz' como un nuevo nodo
        this.raiz = new Nodo(new Escena());
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

}
