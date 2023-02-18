package sml.customExceptions;

/**
 * Thrown to indicate that a method has been passed an illegal or
 * inappropriate SML file.
 *
 * @author Samuel Rakhes
 */
public class DuplicateLabelSMLInputException extends Exception {
    public DuplicateLabelSMLInputException(String errorMessage){
        super(errorMessage);
    }
}