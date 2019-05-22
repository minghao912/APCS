package Game;

import Exceptions.ExceptionHandler;
import Exceptions.BlockOutOfBoundsException;
import Blocks.Block;
import Blocks.Square;
import Blocks.BlockManager;
import Game.Location.Direction;
import jdk.nashorn.internal.runtime.Context.ThrowErrorManager;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * A {@code Grid} represents the game field of Tetris.
 */
public class Grid {
    private Square[][] grid;
    private ArrayList<Block> blocks;
    private BlockSpawner spawner;
    private Block currentBlock;
    private static boolean gameOver;

    /**
     * Creates a new {@code Grid} with the given height and width.
     * @param height the height of the {@code Grid}
     * @param width the width of the {@code Grid}
     */
    public Grid(int height, int width) {
        grid = new Square[height][width];
        blocks = new ArrayList<Block>();
    }

    /**
     * Checks the passed {@code Block} to see if it can be placed
     * at the given {@code Location} without going out of bounds.
     * @param block the {@code Block} to be placed
     * @param location  the {@code Location} at which the {@code Block} is
     *                  to be placed
     * @return  whether or not the block can be placed inside the {@code Grid}
     *          at the given {@code Location}
     */
    private boolean blockPlaceable(Block block, Location location) {
        Square[][] tile = block.getShape();

        if (location.getR() < 0 || location.getR() >= grid.length || location.getC() < 0 || location.getC() >= grid[0].length)  //If the location doesn't exist
            return false;
        if (location.getR() + tile[0].length > grid[0].length - 1)  //If it goes out on the right
            return false;
        if (location.getC() + tile.length > grid.length - 1)    //If it goes out on the bottom
            return false;

        //Overlap detection (SEMI-WORKING)
        for (int r = 0; r < tile.length; r++) {
            for (int c = 0; c < tile[0].length; c++) { 
                System.out.println("> Checking if there's overlap at location (" + (location.getR() + r) + ", " + (location.getC() + c) + ")");
                if (tile[r][c] != null && grid[location.getR() + r][location.getC() + c] != null) {
                    return false;
                }
            }
        }

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

            block.setLocation(location);
            blocks.add(block);
            currentBlock = block;   //update current block to control
            System.out.println("> Block successfully added");
        }
    }

    /**
     * Retreives the {@code Square} at given {@code Location} coordinates.
     * @param location the {@code Location} to get the {@code Square} at
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

    /**
     * Standard update to the {@code Grid}; each block is moved one unit down.
     */
    public synchronized void regularStep() {
        if (gameOver) return;

        for (int r = grid.length - 2; r >= 0; r--) {    //Start up from bottom
            for (int c = 0; c < grid[0].length; c++) {
                //If the square is supposed to be moving
                if (grid[r][c] != null && !grid[r][c].isSettled()) {
                    grid[r + 1][c] = grid[r][c];
                    grid[r][c] = null;
                }
            }
        }
        
        updateBlockLocations();        
        checkIfSettled();   //Settle all blocks that have settled      
        //System.out.println(this);   //Display grid to console
    }

    /**
     * Update the {@code location} instance variables
     * of each {@code Block} in the {@code Grid}.
     */
    private void updateBlockLocations() {
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            System.out.println("> Updater checking a block");
            System.out.println("> Block " + i + " is settled: " + b.isSettled());
            if (!b.isSettled()) {
                b.setLocation(new Location(b.getLocation().getR() + 1, b.getLocation().getC()));
                System.out.println("> Updated location " + b.getLocation());
            }
        }
    }

    /**
     * Check if each {@code Block} in the {@code Grid}
     * is settled, i.e. can no longer move. If the {@code Block}
     * is settled, the instance variable {@code settled} of the 
     * {@code Block} will be changed to reflect this. 
     */
    private void checkIfSettled() {
        Block[] blockArray = blocks.toArray(new Block[0]);
        boolean blockSettled = false;

        for (Block b : blockArray) {
            if (b.isSettled()) 
                continue;

            Location loc = b.getLocation();
            Square[][] shape = b.getShape();
            System.out.println("> Now determining whether to settle " + loc);

            //Automatically settled if it's at the bottom
            if (loc.getR() + shape.length - 1 >= grid.length - 1) {
                System.out.println("> Block settled");
                b.settle();
                blockSettled = true;
            } else {
                //Get bottom blocks
                ArrayList<Square> bottomSquares = b.getOuterSquares();
                for (Square square : bottomSquares) {
                    System.out.println("> Checking new bottom square at " + square.getLocation());
                    if (grid[square.getLocation().getR() + 1][square.getLocation().getC()] != null) {   
                        System.out.println("> Block settled");                     
                        b.settle();
                        blockSettled = true;
                    }
                }
            }
        }

        if (blockSettled) {
            spawnNewBlock();
            blockSettled = false;
        }
    }

    /**
     * Spawns a new {@code Block} in the {@code Grid}.
     */
    public synchronized void spawnNewBlock() {
        //manager.addToGrid(this, new Location(0, new Random().nextInt(this.getSize()[1] - 2)));
        spawner.run();
        System.out.println("> Calling spawn");
    }

    /**
     * Moves the {@code Block} in the given {@code Direction}. A
     * {@code Direction} can either be {@code LEFT} or {@code RIGHT},
     * and is specified in {@link Direction}.
     */
    public synchronized void moveBlock(Block block, Direction direction) throws IllegalStateException {
        if (block == null) block = this.currentBlock;   //Move current control block if no block specified
        if (block.isSettled()) throw new IllegalStateException("The block that needs to be moved is not movable."); //Check if the block is movable

        Location oldLocation = block.getLocation(); //Store old location

        if (direction == Direction.RIGHT) {
            Square[][] shape = block.getShape();

            if (!blockMovable(block, oldLocation, direction)) return;

            //Modify grid
            for (int r = 0; r < shape.length; r++) {
                for (int c = shape[r].length - 1; c >= 0; c--) {    //work backwards
                    if (shape[r][c] != null) {
                        grid[oldLocation.getR() + r][oldLocation.getC() + c] = null;
                        try {
                            grid[oldLocation.getR() + r + 1][oldLocation.getC() + c + 1] = shape[r][c];
                        } catch (Throwable e) {
                            JOptionPane.showMessageDialog(null, "Block current location: " + oldLocation + "\nr: " + r + ", " + c);
                        }
                    }
                }
            }

            block.setLocation(new Location(oldLocation.getR() + 1, oldLocation.getC() + 1));    //update block location
        } else if (direction == Direction.LEFT) {          
            Square[][] shape = block.getShape();

            if (!blockMovable(block, oldLocation, direction)) return;

            //Modify grid
            for (int r = 0; r < shape.length; r++) {
                for (int c = 0; c < shape[r].length; c++) {    //work forwards
                    if (shape[r][c] != null) {
                        grid[oldLocation.getR() + r][oldLocation.getC() + c] = null;
                        try {
                            grid[oldLocation.getR() + r - 1][oldLocation.getC() + c - 1] = shape[r][c];
                        } catch (Throwable e) {
                            JOptionPane.showMessageDialog(null, "Block current location: " + oldLocation + "\nr: " + r + ", " + c);
                        }
                    }
                }
            }

            block.setLocation(new Location(oldLocation.getR() - 1, oldLocation.getC() - 1));    //update block location
        } else throw new IllegalStateException("The specified direction to move the block is invalid.");
    }

    private boolean blockMovable(Block block, Location location, Direction direction) {
        Square[][] shape = block.getShape();
        
        if (direction == Direction.RIGHT) {
            if (location.getC() + shape[0].length >= grid.length) return false;

            for (Square rs : block.getRightSquares()) {
                if (rs.getLocation().getC() >= grid.length - 2 || grid[rs.getLocation().getR()][rs.getLocation().getC() + 1] != null) {
                    return false;
                }
            }

            return true;
        } else if (direction == Direction.LEFT) {
            if (location.getC() == 0) return false;

            for (Square ls : block.getLeftSquares()) {
                if (grid[ls.getLocation().getR()][ls.getLocation().getC() - 1] != null) {
                    return false;
                }
            }

            return true;
        } else throw new IllegalStateException("The specified direction to move the block is invalid.");
    }

    /** 
     * Sets the {@code BlockSpawner} for the {@code Grid}
     * instance.
     */
    public void setSpawner(BlockSpawner s) {
        this.spawner = s;
    }

    /**
     * Sets the {@code Grid} into the 
     * game over state.
     */
    public static void gameOver() {
        Grid.gameOver = true;
    }

    /**
     * Returns {@code true} if the {@code Grid}
     * is in the 'Game Over' state.
     * @return if the game is over or not
     */
    public static boolean isGameOver() {
        return Grid.gameOver;
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Throwable e) {
            ExceptionHandler.showError(e);
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