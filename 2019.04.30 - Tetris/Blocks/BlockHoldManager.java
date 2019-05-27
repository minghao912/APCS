package Blocks;

import Game.Manager;
import Exceptions.ExceededMaximumCapacityException;

import java.util.ArrayList;

public class BlockHoldManager<T extends Block> extends Manager<T> {
    private int max;

    public BlockHoldManager(int maxHold) {
        super();
        this.max = maxHold;
    }

    /**
     * Gets the member at an index.
     * @param index the index to retrieve
     */
    public T getMember(int index) {
        return super.members.get(index);
    }

    /**
     * Holds the passed {@code Block}.
     * @param block the block to hold
     */
    public void holdBlock(T block) {
        this.add(block);
    }

    /**
     * Deletes the object at the index
     * from hold.
     */
    public void deleteHold(int index) {
        super.members.remove(index);
    }

    @Override
    protected void add(T newMember) throws ExceededMaximumCapacityException {
        if (super.members.size() >= max)
            throw new ExceededMaximumCapacityException("Hold has reached its maximum capacity.");
        super.add(newMember);
    }

    @Override
    protected T getNextMember() {
        return getMember(0);
    }
}