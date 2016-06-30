import java.awt.Color;

/**
 * Circle implements the cloneable object.
 * Circle is a representation of all Pizza objects that gain a circle in their instance variable.
 */
public class Circle extends Shape implements Cloneable {
    private int radius;

    /**
     * The default constructor for Circle.
     */
    public Circle() {
        this(25, Color.red);
    }

    /**
     * A paramterized constructor for Circle
     * @param radius the radius of the circle
     * @param color the color of the circle
     */
    public Circle(int radius, Color color) {
        super(color);
        setRadius(radius);
    }

    /**
     * Sets values for the radius of the pizza.
     * @param radius the radius of the pizzae
     */
    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new PizzaException("Dimensions cannot be less than or equal to zero");
        }
        this.radius = radius;
    }

    /**
     * Gets the radius
     * @return the radius of the circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Get the area
     * @return return a double representation of the circle's area.
     */
    @Override
    public double getArea() {
        return Math.pow(getRadius(), 2) * Math.PI;
    }

    /**
     * Get a shallow copy of the Shape class's instance variables by implementing Cloneable.
     * @return a clone of Circle.
     */
    @Override
    protected Object cloneCopy() {
        try {
            return (Circle) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return a toString representation of the circle and giving it a description.
     */
    @Override
    public String toString() {
        return "Pan Pizza, Radius: " + radius;
    }
}
