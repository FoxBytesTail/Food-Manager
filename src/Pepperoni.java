/**
 * This class defines Pepperoni, a child class of Meat. This class contains a description
 * cost and caloric amount for the ingredient
 */
public class Pepperoni extends Meat{
    private static final int calories = 250;
    private static final Money cost = new Money(1,5);
    private static final String description = "Spicy Pepperonis";

    /**
     * Default constructor for Pepperoni
     * calls the super constructor of Meat.
     */
    public Pepperoni(){
        super(description, cost, calories);
    }
}
