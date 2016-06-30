import java.awt.Color;
/**
 * This class defines Olive, a child class of Vegetable. This class contains a description
 * cost and caloric amount for the ingredient
 */
public class Olive extends Vegetable{
    public static final Color color = Color.BLACK;
    public static final int calories = 60;
    public static final Money cost = new Money(1,0);
    public static final String description = "Savory Olives";

    /**
     * Default constructor for Olive
     * calls the super constructor of Vegetable.
     */
    public Olive(){
        super(description, cost, calories, color);
    }


    /**
     * @return a tostring representation of Vegetable indicating the color of the vegetable along with its
     * description, cost, and calories.
     */
    @Override
    public String toString(){
        return description + ", Color " + super.toString() + ", "
                + cost.toString() + ", " + "Calories, " + calories + "\n";
    }
}