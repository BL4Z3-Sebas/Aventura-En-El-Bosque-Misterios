package arbol;

import niveles.Nivel;

public class Arbol {

    private Nodo raiz;

    private static Arbol instancia;

    private Arbol() {
        this.raiz = null;
    }

    public static Arbol getInstancia() {
        if (instancia == null) {
            instancia = new Arbol();
        }
        return instancia;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void agregar(Nivel nivel) {
        Nodo nodo = new Nodo(nivel);

        if (raiz == null) {
            this.raiz = nodo;
            return;
        }

        agregarRecursivo(raiz, nodo);
    }

    public int alturaNivel(int id_nivel) {
        return alturaNivelRecursivo(raiz, id_nivel, 1);
    }

    public boolean buscarHistoria(String titulo) {
        return buscarHistoriaRecursivo(raiz, titulo);
    }

    public void actualizarNodo(Nivel nivelAntiguo, Nivel nivelNuevo) {
        Nodo nodo = buscarNodo(nivelAntiguo);
        if (nodo != null) {
            nodo.setNivel(nivelNuevo);
        }
    }

    public Nodo buscarNodo(Nivel nivel) {
        return buscarNodoRecursivo(raiz, nivel);
    }

//========================================================================//
//                         Metodos recursivos                             //
//========================================================================//
    private void agregarRecursivo(Nodo nodo, Nodo nuevo_nodo) {
        if (nuevo_nodo.getNivel().getId() < nodo.getNivel().getId()) {
            if (nodo.getLeft() == null) {
                nodo.setLeft(nuevo_nodo);
            } else {
                agregarRecursivo(nodo.getLeft(), nuevo_nodo);
            }
        } else {
            if (nodo.getRight() == null) {
                nodo.setRight(nuevo_nodo);
            } else {
                agregarRecursivo(nodo.getRight(), nuevo_nodo);
            }
        }
    }

    private int alturaNivelRecursivo(Nodo nodo, int id, int nivel) {
        if (nodo == null) {
            return -1; // no se encontró el nodo
        }

        if (id < nodo.getNivel().getId()) {
            return alturaNivelRecursivo(nodo.getLeft(), id, nivel + 1);

        } else if (id > nodo.getNivel().getId()) {
            return alturaNivelRecursivo(nodo.getRight(), id, nivel + 1);
        }

        return nivel; // se encontró el nodo
    }

    private boolean buscarHistoriaRecursivo(Nodo nodo, String titulo) {
        if (nodo == null) {
            return false;
        }

        if (titulo.equals(nodo.getNivel().getTitulo())) {
            return true;
        }
        return buscarHistoriaRecursivo(nodo.getLeft(), titulo)
                || buscarHistoriaRecursivo(nodo.getRight(), titulo);
    }

    private Nodo buscarNodoRecursivo(Nodo nodo, Nivel nivel) {
        if (nodo == null) {
            return null;
        }

        if (nivel.getId() < nodo.getNivel().getId()) {
            return buscarNodoRecursivo(nodo.getLeft(), nivel);
        } else if (nivel.getId() > nodo.getNivel().getId()) {
            return buscarNodoRecursivo(nodo.getRight(), nivel);
        }

        return nodo;
    }

}
