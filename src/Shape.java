import java.awt.Color;

/* abstract class Shape
 * This is the superclass for all shape objects made.
 */

public abstract class Shape implements Cloneable{
    // integer instance variables.
    private final Color c;

    /**
     * Shape constructor.
     */
    public Shape(Color c) {
        this.c = c;
    }

    /**
     * this method left blank as there is no algorithm generic enough to calculate all areas of various shapes.
     *
     * @return set to -1
     */
    public abstract double getArea();

    /**
     * Implements a clone of the Shape by using the interface Cloneable
     * and calling the super.clone method.
     */
    protected abstract Object cloneCopy() ;

    public Object copy() {
        return cloneCopy();
    }

    /**
     * Tests for cloning, area, and color in the Shape hierarchy
     * @param args
     */
    public static void main(String[] args){
        Shape c = new Circle();
        Shape s = new Square();
        //Before cloning
        System.out.println(System.identityHashCode(c));
        //After cloning
        System.out.println(System.identityHashCode(c.copy()));

        System.out.println(c.getArea() + "\n");

        //Before cloning
        System.out.println(System.identityHashCode(s));
        s.copy();
        //After cloning
        System.out.println(System.identityHashCode(s.copy()));

        System.out.println(s.getArea());
    }
}