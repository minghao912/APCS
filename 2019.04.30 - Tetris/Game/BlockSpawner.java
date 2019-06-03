package Game;

import Blocks.Block;
import Blocks.BlockManager;

import java.util.TimerTask;

/**
 * The {@code SpawnBlock} class spawns a {@code Block} at a 
 * {@code Location} at the top of the {@code Grid}.
 */
public class BlockSpawner {
    Grid grid;
    BlockManager<Block> manager;

    /**
     * Creates a {@code BlockSpawner} thread with a default
     * time interval of 1 second.
     * @param grid the {@code Grid} to spawn {@code Block}s in
     * @param manager the {@code BlockManager} containing
     *        the {@code Block}s to spawn
     */
    public BlockSpawner(Grid grid, BlockManager<Block> manager) {
        this.grid = grid;
        this.manager = manager;
    }

    /**
     * Runs the {@code BlockSpawner}.
     */
    public void run() {
        manager.addToGrid(grid, new Location(0, getRandomIndex(0, grid.getSize()[1] - 1)));
    }
    
    private int getRandomIndex(int min, int max) {
        return (int) (Math.random() * (max - 1) + min);
    }
}