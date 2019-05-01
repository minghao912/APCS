package Blocks;

import Exceptions.IncorrectBlockDefinitionException;

/**
 * A {@code Block} is a collection of {@code Square} objects
 * that together form a playable block/tile.
 */
public class Block {
    private Square[][] shape;
    private double speed;
    private int currentRotation;

    /**
     * Creates a {@code Block} with the given {@code Square[][]}.
     * @param shape
     * @throws IncorrectBlockDefinitionException
     */
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
     * @return  a clone of the 2D {@code Square[][]} array 
     *          that represents the {@code Block} object.
     */
    public Square[][] getShape() {
        //Make a clone, so the returned 2D array is not the same reference
        Square[][] clone = new Square[shape.length][];
        for (int r = 0; r < shape.length; r++) 
            clone[r] = shape[r].clone();
            
        return clone;
    }

    /**
     * @return  the set speed of the {@code Block}
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