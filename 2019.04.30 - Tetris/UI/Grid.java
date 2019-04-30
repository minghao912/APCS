package UI;

import Exceptions.BlockOutOfBoundsException;

import Blocks.Block;
import Blocks.Square;

public class Grid {
    private Square[][] grid;

    public Grid(int height, int width) {
        grid = new Square[height][width];
    }

    public void addBlock(Block block, Location location) {
        Square[][] tile = block.getShape();

        if (location.getX() + tile[0].length > grid[0].length - 1) throw new BlockOutOfBoundsException()
    }
}