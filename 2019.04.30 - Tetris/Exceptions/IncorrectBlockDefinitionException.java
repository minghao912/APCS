package Exceptions;

public class IncorrectBlockDefinitionException extends RuntimeException {
    public IncorrectBlockDefinitionException(String errorMessage) {
        super(errorMessage);
    }
}