package arbol;

//import escena.Escena;
import niveles.Nivel;

public class Nodo {

    private Nodo left;
    private Nodo right;
    private Nivel nivel;
//    private Escena esc;

   

    public Nodo(Nivel nivel) {
        this.nivel = nivel;
        this.left = null;
        this.right = null;
    }

    public Nodo(int id) {
        Nivel n = new Nivel();
        n.setId(id);
        this.nivel = n;
        this.left = null;
        this.right = null;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
