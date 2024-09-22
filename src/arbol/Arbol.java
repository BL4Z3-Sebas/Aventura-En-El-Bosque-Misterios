package arbol;

import escena.Escena;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public boolean buscarElemento(Nodo nodo, String tituloHis) {
        if (nodo == null) {
            return false;
        }

        if (tituloHis.equals(nodo.getNivel().getTitulo()) && nodo.getNivel().isVisitado()) {
            return true;
        }
        return buscarElemento(nodo.getIzq(), tituloHis) || buscarElemento(nodo.getDer(), tituloHis);
    }
}
