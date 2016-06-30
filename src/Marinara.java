/**
 * This class defines Marinara, a child class of Base. This class contains a description
 * cost and caloric amount ofor the ingredient
 */
public class Marinara extends Base{
    private static final int calories = 150;
    private static final Money cost = new Money(2,0);
    private static final String description = "Artisan Marinara Sauce";

    /**
     * Default constructor for Marinara
     * calls the super constructor of the Base.
     */
    public Marinara(){
        super(description, cost, calories);
    }
}
