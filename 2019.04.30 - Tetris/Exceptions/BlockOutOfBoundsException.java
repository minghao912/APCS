package Exceptions;

import Blocks.Block;
import Game.Location;

/**
 * Exception for a {@code Block} placed out of the bounds of a {@code Grid}.
 */
public class BlockOutOfBoundsException extends RuntimeException {
    public BlockOutOfBoundsException(Location location, Block block) {
        super("Block " + block.getID() + " out of bounds at: (" + location.getR() + ", " + location.getC() + ")");
    }
}