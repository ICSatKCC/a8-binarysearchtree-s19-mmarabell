/**
 * Pokemon Exception class.
 * @author Matthew Marabellas
 * @version 1.0
 * @since 3/28/2019
 */
 
public class PokemonException extends RuntimeException {
   
   /** Variable for thrown message. */
   private String message = "";
   
   /**
    * Get method for the message.
    * @return String message when exception thrown.
    */
   public String getMessage() {
      return this.message;
   }
   
   /**
    * Set method for the message.
    * @param mainMessage The Main Message that gets thrown.
    */
   public void setMessage(String mainMessage) {
      this.message = mainMessage;
   }
   /**
    * Constructor.
    * @param message describing the cause of the error
    */
	public PokemonException(String message) {
	      super(message);
   }
}