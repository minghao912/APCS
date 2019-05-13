package Blocks;

import Game.Grid;
import Game.Location;
import Game.Manager;

import java.util.ArrayList;

public class BlockManager<T extends Block> extends Manager<T> {
    public BlockManager(ArrayList<T> members) {
        super.members = new ArrayList<T>(members);
    }

    @Override
    protected T getNextMember() {
        return members.get(getRandomIndex(0, members.size()));
    }

    public void addToGrid(Grid grid, Location location) {
        Block nextBlock = getNextMember();
        grid.addBlock(nextBlock, location);
    }

    private int getRandomIndex(int min, int max) {
        return (int) (Math.random() * (max - 1) + min);
    }
}