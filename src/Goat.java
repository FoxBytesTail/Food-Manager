/**
 * This class defines Marinara, a child class of Cheese. This class contains a description
 * cost and caloric amount for the ingredient
 */
public class Goat extends Cheese{
    private static final int calories = 200;
    private static final Money cost = new Money(2,0);
    private static final String description = "The finest goat cheese";

    /**
     * Default constructor for Goat
     * calls the super constructor of Cheese.
     */
    public Goat(){
        super(description, cost, calories);
    }
}
