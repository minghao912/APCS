package Blocks;

import Exceptions.IncorrectBlockDefinitionException;
import UI.Game.Location;
import java.util.ArrayList;

/**
 * A {@code Block} is a collection of {@code Square} objects
 * that together form a playable block/tile.
 */
public class Block {
    private Square[][] shape;
    private double speed;
    private int currentRotation;
    private Location location;

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
     * Set the {@code Block} status to be in the
     * 'settled' mode.
     */
    public void settle() {
        for (int r = 0; r < shape.length; r++) 
            for (int c = 0; c < shape[0].length; c++)
                if (shape[r][c] != null)
                    shape[r][c].settle();
    }

    /**
     * @return whether the {@code Block} is settled.
     */
    public boolean isSettled() {
        for (int r = 0; r < shape.length; r++)
            for (int c = 0; c < shape[0].length; c++)
                if (shape[r][c] != null)
                    if (shape[r][c].isSettled())
                        return true;
        return false;
    }

    /**
     * Gets the {@code Square} objects located in the bottom row.
     * @return {@code ArrayList<Square>} the {@code Square} objects
     */
    public ArrayList<Square> getBottomSquares() {
        ArrayList<Square> list = new ArrayList<Square>();
        for (int c = 0; c < shape[shape.length - 1].length; c++)
            if (shape[shape.length - 1][c] != null)
                list.add(shape[shape.length - 1][c]);
        return list;
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

    /**
     * Set the {@code Location} of the {@code Block}.
     * @param location0
     */
    public void setLocation(Location location0) {
        this.location = location0;

        for (int r = 0; r < shape.length; r++)
            for (int c = 0; c < shape[0].length; c++)
                if (shape[r][c] != null)
                    shape[r][c].setLocation(new Location(location0.getR() + r, location0.getC() + c));
    }

    /**
     * @return the {@code Location} of the {@code Block}
     */
    public Location getLocation() {
        return location;
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