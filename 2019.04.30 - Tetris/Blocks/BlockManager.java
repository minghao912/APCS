package Blocks;

import Game.Grid;
import Game.Location;
import Game.Manager;
import Game.Counter;
import Exceptions.BlockOutOfBoundsException;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BlockManager<T extends Block> extends Manager<T> {
    public BlockManager(ArrayList<T> members) {
        super.members = new ArrayList<T>(members);
    }

    @Override
    protected T getNextMember() {
        return members.get(getRandomIndex(0, members.size() + 1));
    }

    /**
     * Adds a new {@code Block}, as determined
     * by {@code getNextMember()}, to the given
     * {@code Grid} at the given {@code Location}.
     * @param grid the grid to which the {@code Block}
     *             is to be added to
     * @param location the location for the {@code Block}
     */
    public void addToGrid(Grid grid, Location location) {
        Block nextBlock = Block.clone(getNextMember());
        try {
            grid.addBlock(nextBlock, location);
        } catch (Throwable e) {
            if (e instanceof BlockOutOfBoundsException) {   //Game over
                grid.gameOver();    //Dialog boxes ☎3
            } else throw e;
        }
    }

    private int getRandomIndex(int min, int max) {
        return (int) (Math.random() * (max - 1) + min);
    }
}