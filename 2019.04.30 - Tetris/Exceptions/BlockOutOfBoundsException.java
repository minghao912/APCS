package Exceptions;

import UI.Game.Location;

/**
 * Exception for a {@code Block} placed out of the bounds of a {@code Grid}.
 */
public class BlockOutOfBoundsException extends RuntimeException {
    public BlockOutOfBoundsException(Location location) {
        super("Block out of bounds at: (" + location.getR() + ", " + location.getC() + ")");
    }
}