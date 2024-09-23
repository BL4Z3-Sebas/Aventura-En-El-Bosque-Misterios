package niveles;

import arbol.Nodo;

/**
 *
 * @author Alfonso
 */
public class Apuntador {

    private Nivel ubicacion;
    private Nodo nodo;
    private static Apuntador instancia;

    private Apuntador() {

    }

    public static Apuntador getInstancia() {
        if (instancia == null) {
            instancia = new Apuntador();
        }
        return instancia;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
        this.actualizarUbicacion();
    }

    public Nivel getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Nivel ubicacion) {
        this.ubicacion = nodo.getNivel();
    }

    private void actualizarUbicacion() {
        this.ubicacion = nodo.getNivel();
    }

    public void avanzar(String direccion) {
        if (direccion.equalsIgnoreCase("izquierda")) {
            this.nodo = nodo.getLeft();
        } else if (direccion.equalsIgnoreCase("derecha")) {
            this.nodo = nodo.getRight();
        }
        this.actualizarUbicacion();
    }

}
