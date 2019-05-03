package Blocks;

import java.awt.Color;

/**
 * A <code>Square</code> represents a single
 * square of a <code>Block</code>
 */
public class Square {
    private Color colour;
    private boolean settled;    //true 

    /**
     * Creates a <code>Square</code> of color <code>color</code>
     * @param color
     */
    public Square(Color color) {
        this.colour = color;
        this.settled = false;
    }

    /**
     * @return the color of the {@code Square}
     */
    public Color getColor() {
        return colour;
    }

    /**
     * @return if the {@code Square} is settled
     */
    public boolean isSettled() {
        return settled;
    }

    @Override
    public String toString() {
        return "[x]";
    }
}