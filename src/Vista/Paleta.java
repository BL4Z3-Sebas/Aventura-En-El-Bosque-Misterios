package Vista;

import java.awt.Color;

/**
 *
 * @author Alfonso
 */
public enum Paleta {
    GRIS_OSCURO(new Color(150, 150, 150));

    private final Color color;

    private Paleta(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
