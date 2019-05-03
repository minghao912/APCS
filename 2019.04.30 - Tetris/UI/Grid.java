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

        if (location.getR() + tile[0].length > grid[0].length - 1)
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
        else {
            Square[][] blockShape = block.getShape();

            for (int r = 0; r < blockShape.length; r++) {
                for (int c = 0; c < blockShape[0].length; c++) {
                    if (blockShape[r][c] != null)
                        grid[location.getR() + r][location.getC() + c] = blockShape[r][c];
                }
            }
        }

        //else System.out.println("Block placed successfully!");  //Placeholder
    }

    /**
     * Retreives the {@code Square} at given {@code Location} coordinates.
     * @param location
     * @return the {@code Square} at the passed {@code Location}
     */
    public Square getSquareAt(Location location) {
        return grid[location.getR()][location.getC()];
    }

    /**
     * Gets the size of the {@code Grid} in the format [rows, columns].
     * @return {@code int[]} [rows, columns]
     */
    public int[] getSize() {
        return new int[] {grid.length, grid[0].length};
    }

    //Still needs work
    public void regularStep() {
        for (int r = grid.length - 2; r >= 0; r--) {    //Start up from bottom
            for (int c = 0; c < grid[0].length; c++) {
                //If the square is supposed to be moving
                if (grid[r][c] != null && !grid[r][c].isSettled()) {
                    grid[r + 1][c] = grid[r][c];
                    grid[r][c] = null;
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (Square[] a : grid) {
            for (Square b : a) {
                if (b == null) result += "[ ]";
                else result += b;
            }
            result += "\n";
        }

        return result;
    }
}