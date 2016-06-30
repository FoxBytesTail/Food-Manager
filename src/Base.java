/**
 * Base is an interior class between Ingredient and its derived classes Marinara, and Alfredo.
 */
public class Base extends Ingredient{
    /**
     * A parameterized constructor which calls the super constructor of Ingredient
     * @param description the description of the ingredients
     * @param cost the cost of the ingredients
     * @param calories the amount of calories defined in the ingredients.
     */
    public Base(String description, Money cost, int calories){
        super(description, cost, calories);
    }
}
