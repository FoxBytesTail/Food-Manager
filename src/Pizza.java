import java.util.Iterator;

/**
 * Pizza is a class that initializes a random pizza in its default constructor
 * with and initailizes instance variables for the Pizza object. This class also
 * implements the PizzaComparable interface.
 */
public class Pizza implements PizzaComparable{
    private Fraction ratio;
    private Money cost;
    private Shape myShape;
    private int calories;
    private ArrayList<Ingredient> toppings;
    private int toppingsCount;

    /**
     * The default constructor for the pizza object.
     * Initializes, at random, ingredients to the pizza.
     * Instantiates, all other objects in order to give
     * Pizza its functionality in determining cost, shape,
     * and the ratio of the remaining pizza.
     */
    public Pizza() {
        ratio = new Fraction();
        cost = new Money(0, 0);
        calories = 0;
        toppings = new ArrayList<Ingredient>();
        toppingsCount = 0;

        if (Math.random() < 0.5) {
            setShape(new Circle());
        } else {
            setShape(new Square());
        }

        if (Math.random() < 0.5) {
            addIngredient(new Marinara());
        } else {
            addIngredient(new Alfredo());
        }

        if (Math.random() < 0.33) {
            addIngredient(new Olive());
        } else if (Math.random() > 0.33 && Math.random() < 0.66){
            addIngredient(new Pepper());
        }

        if (Math.random() < 0.5) {
            addIngredient(new Goat());
        } else if (Math.random() > 0.33 && Math.random() < 0.66){
            addIngredient(new Mozzarella());
        }

        if (Math.random() < 0.5) {
            addIngredient(new Sausage());
        } else if (Math.random() > 0.33 && Math.random() < 0.66){
            addIngredient(new Pepperoni());
        }
    }

    /**
     * Gets the ratio of the remaning pizza in the form of a Fraction object
     * @return A fraction object returning the remaining amount of pizza.
     */
    public Fraction getRatio() {
        return ratio;
    }

    /**
     * Retrives the amount of calories that the pizza has
     * accumulated from adding ingredients
     * at random to the pizza.
     * @return a caloric representation of the sum of all
     * the calories from the ingredients in the pizza object.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Checks if the calories from the ingredient is negative if it is, throw an exception
     * If the calories are positive add the calories to the instance variable of this
     * class that tracks the sum of the calories of the pizza.
     * @param calories a caloric represntation of the sum of the ingredients calories added to the pizza.
     */
    public void setCalories(int calories) {
        if (this.calories > 0) {
            this.calories = calories;
        } else {
            throw new PizzaException("Ingredient is incorrect");
        }
    }

    /**
     * Fetches new reference to the cost of the Pizza
     * @return uses the copy constructor in the Money class and returns a new copy of the amount of money
     * that the pizza costs.
     */
    public Money getCost() {
        return new Money(cost);
    }

    /**
     * Sets a new reference to the cost of the pizza. The new reference utilzies the copy constructor in
     * the Money class and assigns it to the cost instance variable within this class.
     * @param bill the bill to be copied.
     */
    public void setCost(Money bill) {
        this.cost = new Money(bill);
    }

    /**
     * Sets the shape of this object.
     * Calls the clone method within the shape object to set the shape of this object.
     * @param s the Shape passed in as a parameter into the Shape abstract class.
     */
    public void setShape(Shape s) {
        myShape = (Shape) s.copy();
    }

    /**
     * Gets the shape of this object.
     * Calls the clone method within the Shape class in order to create a copy
     * of that object and assigns it to the instance variable of this class.
     * @return a new reference to the shape object of this class.
     */
    public Shape getShape() {
        myShape = (Shape) myShape.copy();
        return myShape;
    }

    /**
     * Creates a double representaiton of the remaining area left by dividing the fractional
     * representation of this pizza and mulitiplying it by the area specified in the shape
     * class.
     * @return the remaining area of this pizza object.
     */
    public double getRemainingArea() {
        return ((double) getRatio().getNum() / (double) getRatio().getDenom()) * getShape().getArea();
    }

    /**
     * Add an ingredient to the ArrayList.
     * Increases calories correspondingly.
     * Adds to the cost correspondingly.
     * Adds to the toppings arraylist for the pizza.e
     * @param a the ingredients to add to the pizza object.
     */
    public void addIngredient(Ingredient a) {
        calories += a.getCalories();
        cost.add(a.getCost());
        toppings.insert(a, toppingsCount++);
    }

    /**
     * This function serves to call the subtract function in the Fration class and subtracts
     * a fractional value from the Fraction instance variable and assigns a new reference
     * to the Fraction object that was subtracted to this Fraction object.
     * @param amt the fraction to be subtracted from this fraction.
     */
    public void eatSomePizza(Fraction amt) {
        ratio = new Fraction(ratio).subtract(amt);
    }

    /**
     * Checks if a pizza's cost is greater than another pizza's cost.
     * First checks if the Object that is being compared is a Pizza object.
     * If it isn't throw an exception, if not continue.
     * Invokes the cost of the instance variable and compares it to the argument
     * that was passed into the method.
     * @param o a Pizza object
     * @return an integer representing the comparison between two Money objects.
     */
    public int compareTo(Object o) {
        if (!(o instanceof Pizza)) {
            throw new PizzaException("Invalid Pizza");
        }
        Pizza that = (Pizza) o;
        return this.getCost().compareTo(that.getCost());
    }

    /**
     * Checks if a pizza's size is greater than another pizza's size.
     * First checks if the Object that is being compared is a Pizza object.
     * If it isn't throw an exception, if not continue.
     * Invokes the remainingArea of the pizza and subtracts this from
     * the remaining area that was passed into the method.
     * @param o a Pizza object
     * @return an integer representing the comparison between the remaining area of the Pizza.
     */
    public int compareToBySize(Object o) {
        if (!(o instanceof Pizza)) {
            throw new PizzaException("Invalid Pizza");
        }
        Pizza that = (Pizza) o;
        return (int)(this.getRemainingArea() - that.getRemainingArea());
    }


    /**
     * Checks if a pizza's size is greater than another pizza's calories.
     * First checks if the Object that is being compared is a Pizza object.
     * If it isn't throw an exception, if not continue.
     * Invokes getcalories of the pizza and subtracts this from
     * the calories that was passed into the method.
     * @param o a Pizza object
     * @return an integer representing the comparison between two caloric values.
     */
    public int compareToByCalories(Object o) {
        if (!(o instanceof Pizza)) {
            throw new PizzaException("Invalid Pizza");
        }
        Pizza that = (Pizza) o;
        return this.getCalories() - that.getCalories();
    }

    /**
     * @return a toString representation of this object's cost, size, calories, remaining area, and fractional
     * representation of it.
     */
    public String toString() {
        String s = "";
        Iterator pizzaIterator = toppings.iterator();

        //Uncomment for a detailed description of the Pizza's ingredients.
//        for (Object p : toppings) {
//            Object pizza = pizzaIterator.next();
//            s += p.toString() + " ";
//        }
        s += myShape.toString() + "\n" + cost.toString() + "\n" + " Total calories " + getCalories() + "\n"
                + " Fraction left " + getRatio().toString() + " Remaining area " + getRemainingArea() + "\n";
        return s;
    }

    /**
     * Temporary testing driver for the Pizza class.
     * @param args
     */
    public static void main(String[] args) {
        Pizza p = new Pizza();
        p.eatSomePizza(new Fraction(1,2));
        System.out.println(p.getRemainingArea());
        p.eatSomePizza(new Fraction(1, 8));
        System.out.println(p.ratio);
        System.out.println(p.getRemainingArea());
        p.eatSomePizza(new Fraction(1, 8));
        System.out.println(p.ratio);
        System.out.println(p.getRemainingArea());
        System.out.println(p.toString());
    }
}