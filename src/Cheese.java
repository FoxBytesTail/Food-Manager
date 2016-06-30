/**
 * Cheese is an interior class between Ingredient and its derived classes Mozzarella, and Goat.
 */
public class Cheese extends Ingredient{
    /**
     * A parameterized constructor which calls the super constructor of Ingredient
     * @param description the description of the ingredients
     * @param cost the cost of the ingredients
     * @param calories the amount of calories defined in the ingredients.
     */
    public Cheese(String description, Money cost, int calories){
        super(description, cost, calories);
    }
}
