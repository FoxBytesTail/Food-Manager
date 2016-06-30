import java.awt.Color;
/**
 * Square implements the cloneable object.
 * Square is a representation of all Pizza objects that gain a Square in their instance variable.
 */
public class Square extends Shape implements Cloneable {
    private int length;
    /**
     * The default constructor for Square.
     */
    public Square(){
        this(25, Color.RED);
    }
    /**
     * A paramterized constructor for Square
     * @param length the length of the Square
     * @param color the color of the Square
     */
    public Square(int length, Color color) {
        super(color);
        setLength(length);
    }

    /**
     * Sets values for the length of the pizza.
     * @param length the radiulengths of the pizzae
     */
    public void setLength(int length) {
        if(length <= 0){
            throw new PizzaException("Dimensions cannot be less than or equal to zero");
        }
        this.length = length;
    }

    /**
     * Gets the length
     * @return the length of the Square
     */
    public int getLength() {
        return length;
    }

    /**
     * Get the area
     * @return return a double representation of the Square's area.
     */
    @Override
    public double getArea() {
        return Math.pow(getLength(), 2);
    }

    /**
     * Get a shallow copy of the Shape class's instance variables by implementing Cloneable.
     * @return a clone of Square.
     */
    @Override
    protected Object cloneCopy() {
        try {
            return (Shape) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return a toString representation of the Square and giving it a description.
     */
    @Override
    public String toString(){
        return "Square Pizza, Radius: " + length;
    }
}
