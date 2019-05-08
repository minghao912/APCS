package Blocks;

import Game.BlockSpawner;
import Game.Grid;
import Blocks.BlockManager;

/**
 * Literally the only purpose of this
 * is to run the {@code BlockSpawner}.
 */
public class SpawnBlock {
    private Grid grid;
    private BlockManager manager;

    public SpawnBlock(Grid grid, BlockManager manager) {
        this.grid = grid;
        this.manager = manager;
    }

    public void spawn() {
        new Thread(new BlockSpawner(grid, manager)).run();
    }
}