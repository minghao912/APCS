package Blocks;

import Exceptions.IncorrectBlockDefinitionException;

/**
 * A Block is a collection of Squares
 * that together form a playable block/tile
 */
public class Block {
    private Square[][] shape;
    private double speed;
    private int currentRotation;

    public Block(Square[][] shape) throws IncorrectBlockDefinitionException{
        //Check shape to be a rectangle (non-staggered)
        int firstRowLength = shape[0].length;
        for (Square[] a : shape) {
            if (a.length != firstRowLength) throw new IncorrectBlockDefinitionException("Blocks must be defined in a rectangular, non-staggered 2D array.");
        }

        this.shape = shape;
        speed = 1;
        currentRotation = 0;
    }

    /**
     * @return the shape
     */
    public Square[][] getShape() {
        return shape;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the currentRotation
     */
    public int getCurrentRotation() {
        return currentRotation;
    }

    @Override
    public String toString() {
        String result = "";

        for (Square[] a : shape) {
            for (Square b : a) {
                if (b == null) result += "[ ]";
                else result += b;
            }
            result += "\n";
        }

        return result;
    }
}