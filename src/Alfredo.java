/**
 * This class defines an alfredo, a child class of Base. This class contains a description
 * cost and caloric amount ofor the ingredient
 */
public class Alfredo extends Base{
    private static final int calories = 300;
    private static final Money cost = new Money(3,0);
    private static final String description = "Artisan Alfredo Sauce";

    /**
     * Default constructor for Alfredo
     * calls the super constructor of the Base.
     */
    public Alfredo(){
        super(description, cost, calories);
    }
}
