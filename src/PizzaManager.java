import java.util.Iterator;
import java.util.Scanner;

/*  PizzaManager Skeleton File
 *  CSS 161, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Start by reading the documentation(comments), and then the code.  Find the 
 *  empty stub methods you are to fill in using a Top-Down approach (see the
 *  assignment for more information on this and Stepwise Refinement)
 * 
 *  Author: Rob Nash with minor edits by Johnny Lin
 */

public class PizzaManager {
    ArrayList<Pizza> pizzaData = new ArrayList<Pizza>();

    /* 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection;

        Scanner foo = new Scanner(System.in);

        while (true) {
            displayAllPizzas();
            displayInstructions();

            selection = (char) foo.next().charAt(0);

            switch (selection) {
                case 'A':
                case 'a':
                    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                    addPizza();
                    break;
                case 'H':
                case 'h':
                    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                    for (int i = 0; i < 100; i++) {
                        addPizza();
                    }
                    break;
                case 'E':
                case 'e':
                    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                    eatSomePizza(foo);
                    break;
                case 'P':
                case 'p':
                    System.out.println("Sorting pizzas by (P)rice");
                    sortByPrice();
                    break;
                case 'S':
                case 's':
                    System.out.println("Sorting pizzas by (S)ize");
                    sortBySize();
                    break;
                case 'C':
                case 'c':
                    System.out.println("Sorting pizzas by (C)alories");
                    sortByCalories();
                    break;
                case 'B':
                case 'b':
                    System.out.println("(B)inary search over pizzas by calories(int).  " +
                            "Sorting first.  What calorie count are you looking for?");
                    int calories = foo.nextInt();
                    System.out.println(binarySearchByCalories(calories));
                    break;
                case 'Q':
                case 'q':
                    System.out.println("(Q)uitting!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unrecognized input - try again");
            }
        }
    }

    /**
     * eatSomePizza requests a Fractional representation of the amount of pizza that
     * the user wishes to eat. It also asks from which index to eat the Pizza from.
     * If the resulting subtraction ends in a negative value of the Fraction object,
     * throw an exception. If the resulting fraction is zero, remove the pizza from
     * the ArrayList.
     *
     * @param keys
     */
    private void eatSomePizza(Scanner keys) {
        keys = new Scanner(System.in);
        int numerator;
        int denominator;
        int index;
        String temp = keys.next();
        String[] tempArr = temp.split("/");
        numerator = Integer.parseInt(tempArr[0]);
        denominator = Integer.parseInt(tempArr[1]);
        System.out.println("At what index?");
        index = keys.nextInt();

        pizzaData.get(index).eatSomePizza(new Fraction(numerator, denominator));

        if (pizzaData.get(index).getRemainingArea() == 0) {
            pizzaData.remove(index);
        } else if (denominator < 0 || pizzaData.get(index).getRatio().getNum() <= 0) {
            throw new PizzaException("Invalid pizza amount");
        }
    }

    /**
     * Adds a pizza to the ArrayLIst by calling Pizza's insert method along with
     * how big the size of the ArrayList is. ArrayList is dynamically resizable,
     * therefore there is no need to worry about how many Pizza objects are
     * added into the ArrayList.
     */
    private void addPizza() {
        pizzaData.insert(new Pizza(), pizzaData.size());
    }

    /**
     * Utilizes the iterator functionality as part of the ArrayList implementation
     * and runs over the ArrayList taking the next Pizza object and implicitily
     * calling its toString method to display the Pizza objects within the
     * PizzaData arrayList
     */
    private void displayAllPizzas() {
        Iterator pizzaIterator = pizzaData.iterator();
        for (Object p : pizzaData) {
            Object pizza = pizzaIterator.next();
            System.out.println(pizza);
        }
    }

    /**
     * sorBySize implements a selection sort and sorts based on a ascending
     * (least to greatest) order. It does so by comparing two elements in an array
     * and swapping them to a position that is earlier in the ArrayList if that
     * element is greater than the other element. In this example, if the price
     * in the Pizza object is lower than another, swap the two elements
     * making sure to not swap if the two values are the same.
     */
    private void sortByPrice() {
        int min;
        for (int index = 0; index < pizzaData.size() - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < pizzaData.size(); scan++) {
                if (pizzaData.get(scan).compareTo(pizzaData.get(min)) < 0) {
                    min = scan;
                }
                pizzaData.swap(index, min);
            }
        }
    }

    /**
     * sorBySize implements a selection sort and sorts based on a decending
     * (greatest to least) order. It does so by comparing two elements in an array
     * and swapping them to a position that is earlier in the ArrayList if that
     * element is greater than the other element. In this example, if the area
     * in the Pizza object is lower than another, swap the two elements
     * making sure to not swap if the two values are the same.
     */
    private void sortBySize() {
        int max;
        for (int index = 0; index < pizzaData.size(); index++) {
            max = index;
            for (int scan = index + 1; scan < pizzaData.size(); scan++) {
                if (pizzaData.get(scan).compareToBySize(pizzaData.get(max)) > 0) {
                    max = scan;
                }
            }
            if (max != index) {
                pizzaData.swap(index, max);
            }
        }
    }

    /**
     * sortByCalories implements a selection sort and sorts based on a decending
     * (greatest to least) order. It does so by comparing two elements in an array
     * and swapping them to a position that is earlier in the ArrayList if that
     * element is greater than the other element. In this example, if the calorie
     * value in the Pizza object is lower than another, swap the two elements
     * making sure to not swap if the two values are the same.
     */
    private void sortByCalories() {
        int max;
        for (int index = 0; index < pizzaData.size(); index++) {
            max = index;
            for (int scan = index + 1; scan < pizzaData.size(); scan++) {
                if (pizzaData.get(scan).compareToByCalories(pizzaData.get(max)) > 0) {
                    max = scan;
                }
            }
            if (max != index) {
                pizzaData.swap(index, max);
            }
        }
    }

    /**
     * binarySearchByCalories implements a binary search over the ArrayList.
     * After sorting the array, implement the binary search over the array-
     * list and determine a value that corresponds to the amount of calories
     * that was passed in as an argument into the method.
     * If that is sucessful return the index at which the element was found
     * in the ArrayList. If it is not found return -1, indicating that the
     * element within the ArrayList could not be found.
     *
     * @param cals The target to search for.
     * @return The index at which the target was found or -1 for not found.
     */
    private int binarySearchByCalories(int cals) {
        sortByCalories();
        int start = 0;
        int end = pizzaData.size();
        while (start <= end) {
            int mid = (start + end) / 2;
            if (cals == pizzaData.get(mid).getCalories()) {
                return mid;
            }
            if (cals > pizzaData.get(mid).getCalories()) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /*
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------" +
            "------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas" +
            " by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by" +
            " calories\n(Q)uit\nIf you want to see a detailed description of the ingredients uncomment the block in"
            + " Pizza's toString method.";

    /**
     * Displays the instructions for the user to view what their options are.
     */
    private void displayInstructions() {
        System.out.println(instructions);
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}