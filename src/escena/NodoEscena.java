/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escena;

/**
 *
 * @author andre
 */
public class NodoEscena {
    public NodoEscena next;
    public NodoEscena back;
    public Escena esc;

    public NodoEscena() {
        this.next = null;
        this.back = null;
        this.esc = null;
    }
    
}
