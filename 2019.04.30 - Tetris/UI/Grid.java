package UI;

import Exceptions.BlockOutOfBoundsException;
import Blocks.*;

/**
 * A {@code Grid} represents the game field of Tetris.
 */
public class Grid {
    private Square[][] grid;

    /**
     * Creates a new {@code Grid} with the given height and width.
     * @param height
     * @param width
     */
    public Grid(int height, int width) {
        grid = new Square[height][width];
    }

    /**
     * Checks the passed {@code Block} to see if it can be placed
     * at the given {@code Location} without going out of bounds.
     * @param block
     * @param location
     * @return  whether or not the block can be placed inside the {@code Grid}
     *          at the given {@code Location}
     */
    private boolean blockPlaceable(Block block, Location location) {
        Square[][] tile = block.getShape();

        if (location.getMap().get("x") + tile[0].length > grid[0].length - 1)
            return false;

        return true;
    }

    /**
     * Adds a {@code Block} to the coordinates represented by the
     * passed {@code Location} object.
     * @param block to be placed
     * @param location of the top left corner of the area the {@code Block} is to be placed in
     */
    public void addBlock(Block block, Location location) {
        //Error if the block will be placed outside of the area
        if (!blockPlaceable(block, location)) throw new BlockOutOfBoundsException(location);
        else System.out.println("Block placed successfully!");  //Placeholder
    }
}