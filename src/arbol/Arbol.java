package arbol;

import escena.Escena;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = new Nodo(new Escena());
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

//        private void ejecutarRecursivo(Nodo nodo) {
//        if (nodo != null) {
//            try {
//                nodo.getEsc().ejecutar();
//            } catch (IOException ex) {
//            
//            }
//            if (nodo.getIzq() != null && nodo.getDer() != null) {
//                Scanner sc = new Scanner(System.in);
//                int i;
//                i = sc.nextInt();
//                if (i == 1) {
//                    ejecutarRecursivo(nodo.getIzq());
//                } else {
//                    ejecutarRecursivo(nodo.getDer());
//                }
//            }
//        }
//    }
}
