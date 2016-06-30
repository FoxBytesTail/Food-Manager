/**
 * Class Fraction
 * Fraction is an immutable class that implements a simple fraction (a/b) and can simplify fractions after
 * an operation such as subtraction is performed.
 */
public class Fraction implements Comparable{
    final private int num;
    final private int denom;

    /**
     * Default no-arg Constructor for Fraction.
     * Instantiates a fraction object with num and denom 1/1
     */
    public Fraction(){
        this(1,1);
    }

    /**
     * Parameterized constructor for Fraction. Instantiates a fraction with the specified numerator and denominator
     * Invariants include negative denominators, negative numerators and a denonominator that is zero.
     * @param num the numerator of the fraction
     * @param denom the denominator of the fraction
     */
    public Fraction(int num, int denom) {
        if(denom < 0 || num < 0){
            throw new PizzaException("Invalid input");
        }
        if(denom == 0){
            throw new PizzaException("Denominator may not be set to zero.");
        }
        this.num = num;
        this.denom = denom;
    }

    /**
     * Copy constructor for the Fraction class
     * Assigns the numerator and denominator to the other Fraction object.
     * @param f the Fraction object that to be copied.
     */
    public Fraction(Fraction f){
        num = f.num;
        denom = f.denom;
    }

    /**
     * Get the numerator
     * @return the numerator.
     */
    public int getNum() {
        return num;
    }

    /**
     * Get the denominator
     * @return the denominator
     */
    public int getDenom() {
        return denom;
    }

    /**
     * Euclid's GCD reduction theorem, utilize recursion to find the greatest common denoominator for a fraction
     * object
     * @param num the numerator of the Fraction
     * @param denom the denominator of the Fraction
     * @return the greatest common denominator of the numerator and the denominator.
     */
    public int gcd(int num, int denom) {
        if (denom == 0) return num;
        return gcd(denom, num % denom);
    }

    /**
     * Returns a new Fraction object after simplifying its numerator and denominator by using the greatest common
     * denominator to reduce the fraction to its simplest terms.
     * @return a new Fraction object (Assignment can only happen once because of immutability).
     */
    public Fraction simplify() {
        int gcd = gcd(getNum(), getDenom());
        return new Fraction(getNum()/gcd, getDenom()/gcd);
    }

    /**
     * Subtract a fraction object from a Fraction object passed in as an argument.
     * Create a common denominator between the two fractions to faciliate the subtraction(not in simplified form)
     * Call the simplify method to return the most simplified value Fraction object.
     * @param frac A fraction object to subtract from this class.
     * @return a new reference to a Fraction object in its final most simplified form
     */
    public Fraction subtract(Fraction frac) {
        Fraction that = (Fraction) frac;

        int newDenom = this.denom * that.denom;
        int num1 = this.num * that.denom;
        int num2 = that.num * this.denom;
        int num = num1-num2;
        return new Fraction(num, newDenom).simplify();
    }

    /**
     * Equals functions to check for equality between two fraction objects.
     * Checks if Object is a Fraction object
     * Checks for equality between a Fraction's numerator and Denominator.
     * @param o the Object passed in (must be a Fraction object.
     * @return a boolean value representing if the equality comparison was correct.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Fraction)) {
            return false;
        }
        Fraction that = (Fraction) o;
        return this.getNum() == that.getNum() && this.getDenom() == that.getDenom();
    }

    /**
     * @return A string representation of the numerator and the denominator.
     */
    @Override
    public String toString() {
        return getNum() + "/" + getDenom();
    }

    /**
     * Calls the super constructor Clone() creating a shallow copy of the instance variables in the class.
     * @return a cloned object with a different reference from the original Fraction object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * compareTo compares two fraction objects against each other. If the object passed in as an argument
     * is a Fraction object, compare the two fractions.
     * In order to check for equality of the numerator and the denominator. Use the equality method
     * defined in Fraction in order to check for values.
     * If the values are not equal, create a new anonymous Fraction object and subtract the two values
     * returning an int comparison between the two objects.
     * @param o An object of type Fraction
     * @return The subtracted fraction's numerator as an integer value.
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Fraction)) {
            throw new PizzaException("Incomparable Objects");
        }
        Fraction that = (Fraction) o;
        if(this.equals(that)){
            return 0;
        }else{
            Fraction anonFrac = new Fraction(that.getNum(), that.getDenom());
            anonFrac.subtract(that);
            return anonFrac.getNum();
        }
    }

    /**
     * Tests the Fraction class
     * @param args
     */
    public static void main(String[] args){
        Fraction f = new Fraction();
        Fraction fSubtracted = f.subtract(new Fraction(1,8));
        System.out.println(fSubtracted);
        Fraction fSubtracted2 = fSubtracted.subtract(new Fraction(1,8));
        System.out.println(fSubtracted2);
    }
}