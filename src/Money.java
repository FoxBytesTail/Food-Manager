import java.io.Serializable;

/**
 * Class Money
 * Money is designed to operate on the premises on Dollars and Cents.
 * Money is a class that implements the Comparable, Clonable, and Serializable interface.
 */
public class Money implements Comparable<Money>, Cloneable, Serializable{
    private final static int MIN = 0;
    private final static int MAX = 100;
    private int dollar;
    private int cent;

    /**
     * Constructor for the Money Class assigns dollars to dol.
     *
     * @param dol
     */
    public Money(int dol) {
        this.setDollar(dol);
    }

    /**
     * This constructor initializes dollars and cents accordingly. Param: int, int
     * Creates and initializes variables of class money
     *
     * @param dol
     * @param cent
     */
    public Money(int dol, int cent) {
        this.setMoney(dol, cent);
    }

    /**
     * Copy constructor
     * This constructor could redirect to the one above. Param: object
     * Creates and initializes a new copy constructor of the class Money.
     *
     * @param other
     */
    public Money(Money other) {
        this.setCent(other.cent);
        this.setDollar(other.dollar);
    }

    /**
     * Return dollars
     *
     * @return dollars
     */
    public int getDollar() {
        return this.dollar;
    }

    /**
     * return cent
     *
     * @return cent
     */
    public int getCent() {
        return this.cent;
    }

    /**
     * return total money
     *
     * @return double
     */
    public double getMoney() {
        return (double) getDollar() + ((double) getCent() / 100);
    }

    /**
     * Class Invariants: Dollars will never be under the value of zero.
     * If the Dollar value is set less than zero a mss will be printed
     * to console and an error thrown.
     *
     * @param dol
     */
    public void setDollar(int dol) {
        if (dol >= MIN)
            this.dollar = dol;
        else {
            System.out.println("ERROR: You must enter a dollar amount greater than zero");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Class Invariants: Dollars and Cents will never be under the value of zero
     * cents will never be above a 100. If any of these conditions are not met a msg
     * will be printed to console and an error thrown.
     *
     * @param cent
     */
    public void setCent(int cent) {
        if (cent > MIN || cent < MAX)
            this.cent = cent;
        else {
            System.out.println("ERROR: You must enter a cent amount between 1 and 100");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Invokies setDollar, and setCent
     *
     * @param dol
     * @param cent
     */
    public void setMoney(int dol, int cent) {
        setDollar(dol);
        setCent(cent);
    }

    /**
     * Adds the dollar which is accepted as a paramter so long as the dollar is greater than zero
     *
     * @param dol
     */
    void add(int dol) {
        if (dol > MIN)
            setDollar(getDollar() + dol);
        else {
            System.out.println("ERROR: You may not add a dollar amount less than zero");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Adds to dollars and cents. Also ensures internal cent value never exceeds 100.
     *
     * @param dol
     * @param cents
     */
    void add(int dol, int cents) {
        if (dol < MIN || cents < MIN || cents > MAX) {
            System.out.println("ERROR: You must enter a dollar/cent amount" +
                    " greater than zero and a cent value less than 100");
            throw new IllegalArgumentException();
        } else {
            if ((getCent() + cents) > MAX) {
                setCent((getCent() + cents) % MAX);
                dol++;
                setMoney(getDollar() + dol, getCent());
            } else {
                setCent(cents + getCent());
                setMoney(getDollar() + dol, getCent());
            }
        }
    }

    /**
     * Adds to this object the dollars and cents stored in the other object. Calls the function add
     *
     * @param other
     */
    void add(Money other) {
        add(other.getDollar(), other.getCent());
    }

    /**
     * Determines if this money object is equal to the other Money object. Compares cents and dollars.
     *
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money)) {
            return false;
        }
        Money that = (Money) o;
        return (this.getDollar() == that.getDollar() && this.getCent() == that.getCent());
    }

    /**
     * Returns a string represntation of the object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "The price is $" + String.format("%.2f", getMoney());
    }

    /**
     * compareTo returns < 0 if 'this' is less than 'other'
     * compareTo returns > 0 if 'this' is greater than 'other;
     * compareTo returns 0 if 'this' == 'other'
     * @param o A Money object
     * @return An integer determinng the comparison between two dates.
     */
    public int compareTo(Money o){
        if(o instanceof Money) {
            Double amt1 = this.getMoney();
            Double amt2 = o.getMoney();
            return Double.compare(amt1, amt2);
        }else
            throw new IllegalArgumentException();
    }

    /**
     * clone
     * This method redefines the inherited version of clone because it is declared as protected by the Object class.
     *
     * @return a copy of the object with a different reference
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}