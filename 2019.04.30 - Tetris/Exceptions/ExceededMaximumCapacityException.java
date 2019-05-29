package Exceptions;

public class ExceededMaximumCapacityException extends RuntimeException {
    public ExceededMaximumCapacityException(int max) {
        super("Exceeded the maximum capacity of " + max);
    }
}