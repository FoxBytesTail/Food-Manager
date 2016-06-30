import java.awt.Color;
/**
 * Vegetable is an interior class between Ingredient and its derived classes Pepper, and Olive.
 */
public class Vegetable extends Ingredient{
    Color myColor;
    /**
     * A parameterized constructor which calls the super constructor of Ingredient
     * @param description the description of the ingredients
     * @param cost the cost of the ingredients
     * @param calories the amount of calories defined in the ingredients.
     */
    public Vegetable(String description, Money cost, int calories, Color color){
        super(description, cost, calories);
        this.myColor = color;
    }

    /**
     * Gets the color object
     * @return a color
     */
    public Color getMyColor(){
        return myColor;
    }

    /**
     * Sets the color object, if the color object is not null.
     * @param myColor the color to be assigned.
     */
    public void setMyColor(Color myColor) {
        if(myColor != null)
        this.myColor = myColor;
    }

    /**
     * A to string representation of the color that was assigned.
     * @return
     */
    @Override
    public String toString(){
        return myColor.toString();
    }

    /**
     * An equality function.
     * Checks if a color object is equal to the other color object.
     * @param other an Object of the Vegetable class.
     * @return a boolean statement deetermining the equality of teh color objects.
     */
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Vegetable)){
            return false;
        }
        else{
            Vegetable that = (Vegetable) other;
            return this.myColor.equals(that.getMyColor());
        }
    }
}
