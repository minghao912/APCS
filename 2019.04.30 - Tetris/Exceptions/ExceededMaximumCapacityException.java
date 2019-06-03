package Exceptions;

/**
 * The maximum capacity of the object has been exceeded.
 */
public class ExceededMaximumCapacityException extends RuntimeException {    // ☎7
    /**
     * Creates the {@code Exception}.
     * @param max the maximum capacity of the object
     */
    public ExceededMaximumCapacityException(int max) {
        super("Exceeded the maximum capacity of " + max);
    }
}