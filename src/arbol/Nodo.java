package arbol;

import niveles.Nivel;

public class Nodo {

    private Nodo left;
    private Nodo right;
    private Nivel nivel;

    public Nodo() {
        this(null); // Llama al constructor que recibe un Nivel
    }

    public Nodo(Nivel nivel) {
        this.nivel = nivel;
        this.left = null;
        this.right = null;
    }

    public Nodo(int id) {
        this.nivel = new Nivel();
        this.nivel.setId(id);
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

    @Override
    public String toString() {
        return "Nodo{"
                + "nivel=" + (nivel != null ? nivel.getId() : "null")
                + ", left=" + (left != null ? left.nivel.getId() : "null")
                + ", right=" + (right != null ? right.nivel.getId() : "null")
                + '}';
    }
}
