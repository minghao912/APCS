package Exceptions;

public class ExceededMaximumCapacityException extends RuntimeException {
    public ExceededMaximumCapacityException(String message) {
        super(message);
    }
}