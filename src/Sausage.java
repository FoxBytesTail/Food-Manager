/**
 * This class defines Sausage, a child class of Meat. This class contains a description
 * cost and caloric amount for the ingredient
 */
public class Sausage extends Meat{
    private static final int calories = 275;
    private static final Money cost = new Money(2,50);
    private static final String description = "Sliced Italian Sausages";

    /**
     * Default constructor for Sausage
     * calls the super constructor of Meat.
     */
    public Sausage(){
        super(description, cost, calories);
    }
}
