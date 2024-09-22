package archivos;

/**
 *
 * @author Alfonso
 */
public enum Intro {
    HISTORIA("\tAño 4202. La humanidad vivía su mejor momento. Dominaban todo el "
            + "sistema solar, la necesidad de energía y recursos no era un "
            + "problema, pero, aun con una vida que para otras especies seria "
            + "perfecta, su curiosidad y deseo por llevar las leyes naturales "
            + "al extremo tendría consecuencias.\n\t"
            + "El científico Alex Stomps acababa de descubrir la manera de "
            + "acceder a la forma más pura de energía, aquella que mantiene al "
            + "universo en expansión. La energía oscura.\n\t"
            + "La primera idea en brotar de la mente del doctor Stomps, fue "
            + "usar esta energía tan refinada para distorsionar la realidad y "
            + "manipular el flujo del tiempo. Moverse en la línea temporal con "
            + "la misma facilidad que caminar hacia adelante o hacia atrás. Fue "
            + "el único error en la vida del prodigioso doctor Stomps.\n\t"
            + "Al primer intento de canalizar la energía oscura para "
            + "concentrarla en un punto, el peor escenario posible se volvió "
            + "realidad. El espacio tiempo empezó a inflarse, tanto así que "
            + "todo en el laboratorio donde se realizaba el experimento empezó "
            + "a desgarrarse, pero no físicamente, sino en el tiempo, todo "
            + "parecía hecho con partes de distintas edades. El doctor Stomps "
            + "ordeno detener la inyección de energía, pero era tarde, "
            + "demasiado tarde.\n\t"
            + "La inflación provocó tal explosión que generó dos brechas que "
            + "conducían a realidades alternativas, una a la izquierda y otra a"
            + " la derecha del punto inicial de concentración de energía "
            + "oscura, absorbieron muchos objetos de los alrededores, "
            + "incluyendo la solución a este terrible suceso, el contenedor de "
            + "energía oscura. Además, se descubrió que las realidades dentro "
            + "de las brechas también estaban fragmentadas en sus dos brechas "
            + "propias.\n\t"
            + "Desde aquel incidente han pasado ya 253 años, ha habido miles de "
            + "valientes hombres y mujeres que se han aventurado en la búsqueda "
            + "del contenedor, pero ninguno de ellos ha vuelto ¿crees tener lo "
            + "suficiente para reparar la realidad?");

    private String texto;

    private Intro(String texto) {
        this.texto = texto;
    }

    public String getText() {
        return texto;
    }

}
