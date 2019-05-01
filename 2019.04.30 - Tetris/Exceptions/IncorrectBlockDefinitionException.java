package Exceptions;

/**
 * Exception for an incorrect {@code Block} definition, i.e.
 * the 2D {@code Square} array passed to the {@code Block}
 * constructor is non-rectangular or staggered.
 */
public class IncorrectBlockDefinitionException extends RuntimeException {
    public IncorrectBlockDefinitionException(String errorMessage) {
        super(errorMessage);
    }
}