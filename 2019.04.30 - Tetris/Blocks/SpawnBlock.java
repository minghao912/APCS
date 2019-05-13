package Blocks;

import Game.BlockSpawner;
import Game.Grid;

import java.util.Timer;

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

    public synchronized void spawn() {
        //Timer timer = new Timer(true);
        //timer.schedule(new BlockSpawner(grid, manager), 33L);

        new BlockSpawner(grid, manager).run();
    }
}