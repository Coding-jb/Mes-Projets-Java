package goosegame;

/**
 * class for NoSuchCellException
 */
public class NoSuchCellException extends Exception{
    
    /**
    * Constructor of the Exception with a personalize message, 
    * @param msg the message to display to the user 
    */
    public NoSuchCellException(String msg) {
        super(msg);
    }
}
