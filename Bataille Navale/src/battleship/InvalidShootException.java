package battleship;
/**
 * class for InvalidShootException
 */
public class InvalidShootException extends Exception {
   /**
    * Message display by this exception
    * @param message the message to display
    */
   public InvalidShootException(String message) {
      super(message);
   }
}
