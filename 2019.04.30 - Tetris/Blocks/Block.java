package Blocks;

import Exceptions.IncorrectBlockDefinitionException;
import Game.Location;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A {@code Block} is a collection of {@code Square} objects
 * that together form a playable block/tile.
 */
public class Block {
    private Square[][] shape;
    private Location location;
    private String id;
    private int gridIndex;
    private boolean settled;

    /**
     * Creates a {@code Block} with the given {@code Square[][]}.
     * @param shape the {@code Square[][]} representing the shape of the {@code Block}
     * @throws IncorrectBlockDefinitionException if the {@code Block} is not defined correctly,
     *                                           i.e. it is not in a rectangular {@code Square[][]}
     */
    public Block(Square[][] shape) throws IncorrectBlockDefinitionException{
        //Check shape to be a rectangle (non-staggered)
        int firstRowLength = shape[0].length;
        for (Square[] a : shape) {
            if (a.length != firstRowLength) throw new IncorrectBlockDefinitionException("Blocks must be defined in a rectangular, non-staggered 2D array.");
        }

        this.settled = false;
        this.shape = shape;
        this.id = UUID.randomUUID().toString(); // ☎2
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
        settled = true;
    }

    /**
     * @return whether the {@code Block} is settled.
     */
    public boolean isSettled() {
        return this.settled;
    }

    /**
     * Gets the {@code Square} objects located on the outside 
     * edges of the {@code Block}.
     * @return {@code ArrayList<Square>} the {@code Square} objects
     */
    public ArrayList<Square> getOuterSquares() {
        ArrayList<Square> list = new ArrayList<Square>();

        //Get edge squares (not in bottom row)
        for (int r = 0; r < shape.length - 1; r++)
            for (int c = 0; c < shape[0].length; c++)
                if (shape[r][c] != null && shape[r + 1][c] == null)
                    list.add(shape[r][c]);

        //Get bottom row squares
        for (int c = 0; c < shape[shape.length - 1].length; c++)
            if (shape[shape.length - 1][c] != null)
                list.add(shape[shape.length - 1][c]);

        return list;
    }

    /**
     * Gets the {@code Square} objects located on the left
     * edge of the {@code Block}.
     * @return {@code ArrayList<Square>} the {@code Square} objects
     */
    public ArrayList<Square> getLeftSquares() {
        ArrayList<Square> list = new ArrayList<Square>();

        for (int r = 0; r < shape.length; r++)
            if (shape[r][0] != null) 
                list.add(shape[r][0]);

        list.forEach(sq -> System.out.println(sq.getLocation()));
        return list;
    }

    /**
     * Gets the {@code Square} objects located on the right
     * edge of the {@code Block}.
     * @return {@code ArrayList<Square>} the {@code Square} objects
     */
    public ArrayList<Square> getRightSquares() {
        ArrayList<Square> list = new ArrayList<Square>();

        for (int r = 0; r < shape.length; r++)
            if (shape[r][shape[r].length - 1] != null) 
                list.add(shape[r][shape[r].length - 1]);

        return list;
    }

    /**
     * Clones the passed {@code Block}.
     * @param block the {@code Block} to be cloned
     * @return the cloned {@code Block}
     */
    public static Block clone(Block block) {
        Square[][] oldShape = block.getShape();
        Square[][] newShape = new Square[oldShape.length][oldShape[0].length];

        for (int r = 0; r < oldShape.length; r++)
            for (int c = 0; c < oldShape[0].length; c++) 
                if (oldShape[r][c] != null)
                    newShape[r][c] = new Square(oldShape[r][c].getColor());

        return new Block(newShape);
    }

    /**
     * @return the unique ID of the {@code Block}
     */
    public String getID() {
        return this.id;
    }

    /**
     * Set the {@code Location} of the {@code Block}.
     * @param location0 the {@code Location} of the top-left corner of the {@code Block}
     */
    public void setLocation(Location location0) {
        this.location = location0;

        for (int r = 0; r < shape.length; r++)
            for (int c = 0; c < shape[0].length; c++)
                if (shape[r][c] != null)
                    shape[r][c].setLocation(new Location(location0.getR() + r, location0.getC() + c));
    }

    /**
     * @param index the index to assign
     */
    public void setGridIndex(int index) {
        this.gridIndex = index;
    }

    /**
     * @return the index of the {@code Block}
     *         within the {@code Grid}'s list
     */
    public int getGridIndex() {
        return this.gridIndex;
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