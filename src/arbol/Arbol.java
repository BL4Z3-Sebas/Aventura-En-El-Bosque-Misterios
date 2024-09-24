package arbol;

import java.util.ArrayList;
import niveles.Nivel;

public class Arbol {

    private Nodo raiz;
    private static final Arbol INSTANCIA = new Arbol();

    private Arbol() {
        this.raiz = null;
    }

    public static Arbol getInstancia() {
        return INSTANCIA;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void agregar(Nivel nivel) {
        Nodo nuevoNodo = new Nodo(nivel);
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            agregarRecursivo(raiz, nuevoNodo);
        }
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

    public ArrayList<Nivel> obtenerNodosDeNivel(int nivel) {
        ArrayList<Nivel> niveles = new ArrayList<>();
        obtenerNodosDeNivelRecursivo(raiz, nivel, 1, niveles);
        return niveles;
    }

    public void mostrarHistorias() {
        mostrarHistoriasRecursivo(raiz);
    }

    //========================================================================//
    //                         Metodos recursivos                             //
    //========================================================================//
    
    private void agregarRecursivo(Nodo actual, Nodo nuevoNodo) {
        if (nuevoNodo.getNivel().getId() < actual.getNivel().getId()) {
            if (actual.getLeft() == null) {
                actual.setLeft(nuevoNodo);
            } else {
                agregarRecursivo(actual.getLeft(), nuevoNodo);
            }
        } else {
            if (actual.getRight() == null) {
                actual.setRight(nuevoNodo);
            } else {
                agregarRecursivo(actual.getRight(), nuevoNodo);
            }
        }
    }

    private int alturaNivelRecursivo(Nodo actual, int id, int nivel) {
        if (actual == null) {
            return -1; // nodo no encontrado
        }

        if (id == actual.getNivel().getId()) {
            return nivel; // nodo encontrado
        }

        if (id < actual.getNivel().getId()) {
            return alturaNivelRecursivo(actual.getLeft(), id, nivel + 1);
        } else {
            return alturaNivelRecursivo(actual.getRight(), id, nivel + 1);
        }
    }

    private boolean buscarHistoriaRecursivo(Nodo actual, String titulo) {
        if (actual == null) {
            return false;
        }

        if (titulo.equals(actual.getNivel().getTitulo())) {
            return true;
        }

        return buscarHistoriaRecursivo(actual.getLeft(), titulo) 
                || buscarHistoriaRecursivo(actual.getRight(), titulo);
    }

    private Nodo buscarNodoRecursivo(Nodo actual, Nivel nivel) {
        if (actual == null) {
            return null;
        }

        if (nivel.getId() == actual.getNivel().getId()) {
            return actual;
        }

        if (nivel.getId() < actual.getNivel().getId()) {
            return buscarNodoRecursivo(actual.getLeft(), nivel);
        } else {
            return buscarNodoRecursivo(actual.getRight(), nivel);
        }
    }

    private void obtenerNodosDeNivelRecursivo(Nodo actual, int nivelDeseado, int nivelActual, ArrayList<Nivel> niveles) {
        if (actual == null) {
            return;
        }

        if (nivelActual == nivelDeseado) {
            niveles.add(actual.getNivel());
        }

        obtenerNodosDeNivelRecursivo(actual.getLeft(), nivelDeseado, nivelActual + 1, niveles);
        obtenerNodosDeNivelRecursivo(actual.getRight(), nivelDeseado, nivelActual + 1, niveles);
    }

    private void mostrarHistoriasRecursivo(Nodo actual) {
        if (actual == null) {
            return;
        }

        System.out.println(actual.getNivel().getTitulo());
        mostrarHistoriasRecursivo(actual.getLeft());
        mostrarHistoriasRecursivo(actual.getRight());
    }
}
