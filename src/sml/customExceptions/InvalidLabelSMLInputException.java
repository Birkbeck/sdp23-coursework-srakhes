package sml.customExceptions;

/**
 * Thrown to indicate that a method has been passed an illegal or
 * inappropriate label within SML file.
 *
 * @author Samuel Rakhes
 */
public class InvalidLabelSMLInputException extends Exception {

    public InvalidLabelSMLInputException(){
//        super(errorMessage);
    }
    public InvalidLabelSMLInputException(String errorMessage){
        super(errorMessage);
    }
}