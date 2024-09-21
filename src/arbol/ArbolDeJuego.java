/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

import niveles.GeneradorNiveles;
import niveles.Nivel;

/**
 *
 * @author andre
 */
public class ArbolDeJuego {

    private Arbol arbol = new Arbol();

    public Arbol getArbol() {
        return arbol;
    }

    public void hacerJuego() {
        Nivel nivel = GeneradorNiveles.crearNivel("Nivel_1");      
        Nivel nivel2 = GeneradorNiveles.crearNivel("Nivel_2");;
        
            
    }

}
