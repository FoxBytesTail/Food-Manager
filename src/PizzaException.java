/**
 * PizzaException is a subclass to the RuntimeException class and handles a
 * majority of the exceptions caused by invalid or mis-calculated
 * data.
 */
public class PizzaException extends RuntimeException{
    /**
     * Calls the default constructor of RuntimeException
     */
    public PizzaException(){
        super();
    }

    /**
     * Calls a parameterized constructor of RuntimeException with a
     * message to help troubleshoot the error.
     * @param msg
     */
    public PizzaException(String msg){
        super(msg);
    }
}
