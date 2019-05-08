package Blocks;
import UI.Game.Location;

import java.awt.Color;

/**
 * A <code>Square</code> represents a single
 * square of a <code>Block</code>
 */
public class Square {
    private Color colour;
    private boolean settled;    //true 
    private Location location;

    /**
     * Creates a <code>Square</code> of color <code>color</code>
     * @param color the colour of the {@code Square}
     */
    public Square(Color color) {
        this.colour = color;
        this.settled = false;
    }

    /**
     * Set the {@code Location} of the {@code Square}
     * within the {@code Grid}.
     * @param location0 the {@code Location} of the {@code Square}
     */
    public void setLocation(Location location0) {
        this.location = location0;
    }

    /**
     * @return the {@code Location} of the {@code Square}
     */
    public Location getLocation() {
        return location;
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

    /**
     * Change the status of the {@code Square} to settled.
     */
    public void settle() {
        this.settled = true;
    }

    @Override
    public String toString() {
        return "[x]";
    }
}