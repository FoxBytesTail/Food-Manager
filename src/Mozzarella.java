/**
 * This class defines Marinara, a child class of Cheeese. This class contains a description
 * cost and caloric amount for the ingredient
 */
public class Mozzarella extends Cheese{
    private static final int calories = 110;
    private static final Money cost = new Money(1,50);
    private static final String description = "Mozzarella cheese";

    /**
     * Default constructor for Mozarella
     * calls the super constructor of Cheese.
     */
    public Mozzarella(){
        super(description, cost, calories);
    }
}