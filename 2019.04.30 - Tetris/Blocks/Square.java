package Blocks;

import java.awt.Color;

public class Square {
    private Color colour;

    public Square(Color colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "[x]";
    }
}