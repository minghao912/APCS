package Blocks;

import java.awt.Color;

/**
 * A <code>Square</code> represents a single
 * square of a <code>Block</code>
 */
public class Square {
    private Color colour;

    /**
     * Creates a <code>Square</code> of color <code>color</code>
     * @param color
     */
    public Square(Color color) {
        this.colour = color;
    }

    @Override
    public String toString() {
        return "[x]";
    }
}