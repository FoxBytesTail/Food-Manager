/*
 *  Class PizzaComparable
 * This interface can do everything the Comparable interface can and more
 *  */
public interface PizzaComparable extends Comparable {
    /**
     * Checks if a pizza's cost is greater than another pizza's cost.
     * First checks if the Object that is being compared is a Pizza object.
     * If it isn't throw an exception, if not continue.
     * Invokes the cost of the instance variable and compares it to the argument
     * that was passed into the method.
     * @param o a Pizza object
     * @return an integer representing the comparison between two Money objects.
     */
    @Override
    public int compareTo(Object o);            //a.k.a compareToByPrice

    /**
     * Checks if a pizza's size is greater than another pizza's size.
     * First checks if the Object that is being compared is a Pizza object.
     * If it isn't throw an exception, if not continue.
     * Invokes the remainingArea of the pizza and subtracts this from
     * the remaining area that was passed into the method.
     * @param o a Pizza object
     * @return an integer representing the comparison between the remaining area of the Pizza.
     */
    //non-overrides
    public int compareToBySize(Object o);        //a.k.a. compareToByAreaLeft

    /**
     * Checks if a pizza's size is greater than another pizza's calories.
     * First checks if the Object that is being compared is a Pizza object.
     * If it isn't throw an exception, if not continue.
     * Invokes getcalories of the pizza and subtracts this from
     * the calories that was passed into the method.
     * @param o a Pizza object
     * @return an integer representing the comparison between two caloric values.
     */
    public int compareToByCalories(Object o);

}