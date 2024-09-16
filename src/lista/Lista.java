package lista;

public class Lista {

    public Nodo cabeza;

    public void añadir(String cad) {
        if (this.cabeza == null) {
            this.cabeza = new Nodo(cad);  // Create the head if it doesn't exist
        } else {
            añadirRecursivo(this.cabeza, cad);
        }
    }

    private void añadirRecursivo(Nodo nodo, String cad) {
        if (nodo.next == null) {
            nodo.next = new Nodo(cad);  // Create a new node when reaching the end
        } else {
            añadirRecursivo(nodo.next, cad);
        }
    }

    public void showLista() {
        showListaRecursivo(this.cabeza);
    }

    private void showListaRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.dia);
            
            //showListaRecursivo(nodo.next);
        }
    }
}

