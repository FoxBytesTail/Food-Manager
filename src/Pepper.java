import java.awt.Color;
/**
 * This class defines Pepper, a child class of Vegetable. This class contains a description
 * cost and caloric amount for the ingredient
 */
public class Pepper extends Vegetable {
    public static final Color color = Color.GREEN;
    public static final int calories = 50;
    public static final Money cost = new Money(0, 75);
    public static final String description = "The crunchiest bell peppers ";

    /**
     * Default constructor for Pepper
     * calls the super constructor of Vegetable.
     */
    public Pepper() {
        super(description, cost, calories, color);
    }

    /**
     * @return a tostring representation of Vegetable indicating the color of the vegetable along with its
     * description, cost, and calories.
     */
    @Override
    public String toString() {
        return description + "Color " + super.toString() + ", " + cost.toString() + ", Calories " + calories + "\n";
    }
}