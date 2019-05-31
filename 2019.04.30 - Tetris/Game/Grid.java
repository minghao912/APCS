package Game;

import Exceptions.ExceptionHandler;
import Exceptions.BlockOutOfBoundsException;
import Exceptions.ExceededMaximumCapacityException;
import Blocks.Block;
import Blocks.Square;
import Blocks.BlockHoldManager;
import Blocks.BlockManager;
import Game.Location.Direction;
import UI.HoldPanel;

import java.util.ArrayList;
import java.util.function.Function;;
import javax.swing.JOptionPane;

/**
 * A {@code Grid} represents the game field of Tetris.
 */
public class Grid {
    private Square[][] grid;
    private ArrayList<Block> blocks;
    private Block currentBlock;
    private BlockSpawner spawner;
    private BlockHoldManager<Block> holdManager;
    private int currentHoldIndex;
    private HoldPanel holdPanel;
    private volatile Lock lock;  //For inter-class locking only
    private boolean gameOver;

    //For rotation
    private Function<Square[][], Square[][]> clockwiseRotate;
    private Function<Square[][], Square[][]> counterclockwiseRotate;

    /**
     * Creates a new {@code Grid} with the given height and width.
     * @param height the height of the {@code Grid}
     * @param width the width of the {@code Grid}
     */
    public Grid(int height, int width, Lock lock) {
        grid = new Square[height][width];
        blocks = new ArrayList<Block>();
        holdManager = new BlockHoldManager<Block>(Counter.maxHoldCount);
        gameOver = false;
        this.lock = lock;

        setUpRotateAlgorithms();
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
        System.out.println("> Checking block placability");
        Square[][] tile = block.getShape();

        if (location.getR() < 0 || location.getR() >= grid.length || location.getC() < 0 || location.getC() >= grid[0].length)  //If the location doesn't exist
            return false;
        if (location.getC() + tile[0].length > grid[0].length)  //If it goes out on the right
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
        if (!blockPlaceable(block, location)) 
            throw new BlockOutOfBoundsException(location, block);
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
            block.setGridIndex(blocks.size() - 1);
            currentBlock = block;   //update current block to control
            System.out.println("> Block successfully added");
        }
    }

    /**
     * Retrieves the {@code Square} at given {@code Location} coordinates.
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
        synchronized (lock) {
            if (gameOver) return;
            
            System.out.println("> Starting step");
            
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
            System.out.println("> End step");
        }
    }

    /**
     * Update the {@code location} instance variables
     * of each {@code Block} in the {@code Grid}.
     */
    private synchronized void updateBlockLocations() {
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            System.out.println("> Updater checking Block " + b.getID());
            System.out.println("> Block is settled: " + b.isSettled());
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
    private synchronized void checkIfSettled() {
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
            clearLines();  
            spawnNewBlock();
            blockSettled = false;
        }
    }

    /**
     * Spawns a new {@code Block} in the {@code Grid}.
     */
    private synchronized void spawnNewBlock() {
        spawner.run();
        System.out.println("> Calling spawn");
    }

    /**
     * Moves the {@code Block} in the given {@code Direction}. A
     * {@code Direction} can either be {@code LEFT} or {@code RIGHT},
     * and is specified in {@link Direction}.
     */
    public synchronized void moveBlock(Block block, Direction direction) throws IllegalStateException {
        System.out.println("> Starting move");

        if (block == null) block = this.currentBlock;   //Move current control block if no block specified
        if (block.isSettled()) throw new IllegalStateException("The block that needs to be moved is not movable."); //Check if the block is movable

        Location oldLocation = block.getLocation(); //Store old location

        if (direction == Direction.RIGHT) {
            Square[][] shape = block.getShape();

            if (!blockMovable(block, oldLocation, direction)) return;

            //Modify grid
            for (int r = 0; r < shape.length; r++)
                for (int c = 0; c < shape[r].length; c++)   //work backwards
                    if (shape[r][c] != null)
                        grid[oldLocation.getR() + r][oldLocation.getC() + c] = null;

            for (int r = 0; r < shape.length; r++)
                for (int c = 0; c < shape[r].length; c++)
                    if (shape[r][c] != null)
                        grid[oldLocation.getR() + r][oldLocation.getC() + c + 1] = shape[r][c];

            //this line can go fuck itself
            block.setLocation(new Location(oldLocation.getR(), oldLocation.getC() + 1));    //update block location
        } else if (direction == Direction.LEFT) {          
            Square[][] shape = block.getShape();

            if (!blockMovable(block, oldLocation, direction)) return;

            //Modify grid
            for (int r = 0; r < shape.length; r++)
                for (int c = 0; c < shape[r].length; c++)   //work forwards
                    if (shape[r][c] != null)
                        grid[oldLocation.getR() + r][oldLocation.getC() + c] = null;

            for (int r = 0; r < shape.length; r++)
                for (int c = 0; c < shape[r].length; c++)
                    if (shape[r][c] != null)
                        grid[oldLocation.getR() + r][oldLocation.getC() + c - 1] = shape[r][c];

            block.setLocation(new Location(oldLocation.getR(), oldLocation.getC() - 1));    //update block location
        } else throw new IllegalStateException("The specified direction to move the block is invalid.");

        checkIfSettled();
        System.out.println("> End move");
    }

    /**
     * Checks if the block can be moved.
     * @param block the {@code Block} to be moved
     * @param location the {@code Location} of the {@code Block}
     * @param direction the {@code Direction} of the movement
     * @return {@code true} if the block can be moved,
     *         {@code false} if not
     */
    private boolean blockMovable(Block block, Location location, Direction direction) {
        Square[][] shape = block.getShape();
        
        if (direction == Direction.RIGHT) {
            if (location.getC() + shape[0].length >= grid.length - 1) return false;

            try {
                for (Square rs : block.getRightSquares()) {
                    if (rs.getLocation().getC() >= grid.length - 2 || grid[rs.getLocation().getR()][rs.getLocation().getC() + 1] != null) {
                        return false;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
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
     * Clears any lines in the {@code Grid} that have
     * been cleared by the user.
     */
    public synchronized void clearLines() {
        System.out.println("> Checking for cleared lines");

        ArrayList<Integer> rowsCleared = new ArrayList<Integer>();

        for (int r = grid.length - 1; r >= 0; r--) {    //Goes backwards
            if (checkLineClear(r))
                rowsCleared.add(r);
        }

        rowsCleared.forEach(row -> {
            for (int c = 0; c < grid[row].length; c++) {
                grid[row][c] = null;
            }

            for (int r = row - 1; r >= 0; r--) {
                for (int c = 0; c < grid[row].length; c++) {
                    grid[r + 1][c] = grid[r][c];
                    grid[r][c] = null;
                }
            }

            System.out.println("> Line cleared");
        });

        Counter.linesCleared += rowsCleared.size(); //Add to the counter
        System.out.println("> Finish cleared lines check");
    }

    /**
     * Checks if the given row in the {@code Grid}
     * has been cleared.
     * @param row the row to check
     * @return whether of not the row is clear
     */
    private synchronized boolean checkLineClear(int row) {
        boolean rowClear = true;

        for (int c = 0; c < grid[row].length; c++) {
            if (grid[row][c] == null) {
                rowClear = false;
                break;
            }
        }

        return rowClear;
    }

    /**
     * Sets the {@code clockwiseRotate} and {@code counterclockwiseRotate}
     * {@code Function}s to predetermined rotation algorithms.
     */
    private void setUpRotateAlgorithms() {
        counterclockwiseRotate = (a) -> {
            Square[][] b = new Square[a[0].length][a.length];
            for (int r = 0; r < a[0].length; r++)
                for (int c = a.length - 1; c >= 0; c--)
                    b[r][c] = a[a.length - c - 1][r];
            return b;
        };

        clockwiseRotate = (a) -> {
            Square[][] b = new Square[a[0].length][a.length];
            for (int r = 0; r < a[0].length; r++)
                for (int c = 0; c < a.length; c++) 
                    b[r][c] = a[c][a[0].length - r - 1];
            return b;
        };
    }

    /**
     * Rotates the passed {@code Block} in the
     * given {@code Direction}.
     * @param block the {@code Block} to be moved
     * @param direction the {@code Direction} of rotation - either
     *                  {@code CLOCKWISE} or {@code COUNTERCLOCKWISE}
     * @throws IllegalArgumentException if the rotation direction is invalid
     */
    public synchronized void rotateBlock(Block block, Direction direction) throws IllegalArgumentException {
        if (block == null) 
            block = this.currentBlock;
        if (direction != Direction.CLOCKWISE && direction != Direction.COUNTERCLOCKWISE)
            throw new IllegalArgumentException("The rotation direction is invalid.");

        //Don't rotate if out of bounds
        if (block.getLocation().getC() + block.getShape().length >= grid[0].length)
            return;
        
        System.out.println("> Rotating Block " + block.getID());

        Square[][] shape = block.getShape();
        Square[][] newShape;
        if (direction == Direction.COUNTERCLOCKWISE) {
            newShape = counterclockwiseRotate.apply(shape);
        } else if (direction == Direction.CLOCKWISE) {
            newShape = clockwiseRotate.apply(shape);
        } else newShape = null;

        removeBlock(block);
        try {
            this.addBlock(new Block(newShape), block.getLocation());
        } catch (BlockOutOfBoundsException e) {
            this.addBlock(new Block(shape), block.getLocation());
        }
    }

    /**
     * Removes the passed {@code Block} from the {@code Grid}
     * @param block the {@code Block} to remove
     */
    private synchronized void removeBlock(Block block) {
        Square[][] shape = block.getShape();
        Location loc = block.getLocation();

        for (int r = 0; r < shape.length; r++) {
            for (int c = 0; c < shape[r].length; c++) {
                if (shape[r][c] != null) {
                    grid[loc.getR() + r][loc.getC() + c] = null;
                }
            }
        }

        blocks.remove(block.getGridIndex());
    }

    /**
     * Holds the given {@code Block} and spawns a new one.
     * @param block the {@code Block} to hold
     * @param spawnNewBlock whether or not to spawn a new {@code Block} after holding
     */
    public void holdBlock(Block block, boolean spawnNewBlock) {
        if (block == null) 
            block = this.currentBlock;

        try {
            holdManager.holdBlock(block);
        } catch (ExceededMaximumCapacityException e) { //Hold has reached its maximum capacity
            Block previousHold = retrieveHold(currentHoldIndex++ % Counter.maxHoldCount);
            holdBlock(block, false);
            Location oldLoc = block.getLocation();
            removeBlock(block);

            try {
                this.addBlock(previousHold, oldLoc);
            } catch (BlockOutOfBoundsException err) {
                return;
            }
            holdPanel.repaint();
            return;
        }
        holdPanel.repaint();

        System.out.println("> Holding Block " + block.getID());

        if (spawnNewBlock) {
            removeBlock(block);
            spawnNewBlock();
        }
    }

    /**
     * Retrieves the {@code i}th {@code Block} from
     * hold and replaces it with the current one.
     * @param i the {@code Block} to retrieve
     */
    public Block retrieveHold(int i) {
        Block block = holdManager.getMember(i);
        holdManager.deleteHold(i);
        return block;
    }

    /** 
     * Sets the {@code BlockSpawner} for the {@code Grid}
     * instance.
     * @param s the {@code BlockSpawner} to be assigned
     */
    public void setSpawner(BlockSpawner s) {
        this.spawner = s;
    }

    public void setHoldPanel(HoldPanel hpanel) {
        this.holdPanel = hpanel;
    }

    /**
     * @return the hold manager
     */
    public BlockHoldManager<Block> getHoldManager() {
        return this.holdManager;
    }

    /**
     * Sets the {@code Grid} into the 
     * game over state.
     */
    public void gameOver() {
        this.gameOver = true;
        System.out.println("> Game over state triggered");
    }

    /**
     * Returns {@code true} if the {@code Grid}
     * is in the 'Game Over' state.
     * @return if the game is over or not
     */
    public boolean isGameOver() {
        return this.gameOver;
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