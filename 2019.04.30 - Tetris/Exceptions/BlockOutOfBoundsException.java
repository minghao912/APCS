package Exceptions;

public class BlockOutOfBoundsException extends RuntimeException {
    public BlockOutOfBoundsException(String errorMessage) {
        super(errorMessage);
    }
}