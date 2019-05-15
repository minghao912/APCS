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

    public void addToGrid(Grid grid, Location location) {
        Block nextBlock = Block.clone(getNextMember());
        try {
            grid.addBlock(nextBlock, location);
        } catch (Throwable e) {
            if (e instanceof BlockOutOfBoundsException) {   //Game over
                JOptionPane.showMessageDialog(null, "You Lost!\nLines Cleared: " + Counter.linesCleared, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else throw e;
        }
    }

    private int getRandomIndex(int min, int max) {
        return (int) (Math.random() * (max - 1) + min);
    }
}