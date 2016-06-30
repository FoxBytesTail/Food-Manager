import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class functions as an ArrayList, dynamically increasing in size every time it needs to expand.
 */
public class ArrayList<T> implements Iterable {
    private Object[] objects;
    private int size;
    private int max = 10;

    /**
     * Default constructor for ArrayList
     * initializes values for objects instance variable
     * initializes values for size
     */
    public ArrayList() {
        size = 0;
        objects = new Object[10];
    }

    /**
     * Parametrized constructor for ArrayList
     * initializes size
     *
     * @param initSize the size for which to initialise the array to
     */
    public ArrayList(int initSize) {
        size = 0;
        objects = new Object[initSize];
    }

    /**
     * get()
     * Fetches the object at the specified index
     *
     * @param index
     * @return Object in the list
     */
    public T get(int index) {
        if (index > size || index < 0) {
            throw new PizzaException("Retrieval at invalid index");
        }
        return (T) objects[index];
    }

    /**
     * Return a new reference to the Objects array.
     * Using the Arrays functionality given to us by java allows us
     * to create a new reference to the array instead of giving a
     * reference to the current array ensuring privacy
     *
     * @return A new reference to the array object.
     */
    public Object[] getObjects() {
        return Arrays.copyOf(objects, objects.length);
    }

    /**
     * Swaps two elements within the ArrayList at their specified index locations.
     * @param first the first element that will be swapped
     * @param second the second element that will be swapped
     */
    public void swap(int first, int second) {
        Object temp = objects[first];
        objects[first] = objects[second];
        objects[second] = temp;
    }

    /**
     * 1) Sets an index of the array to the object taken in as an argument
     * 2) Increment size
     * 3) Checks if the size of the array is greater than the current objects.
     * 4) If that check is true, creates a new temporary copy of the array which is set to size,
     * and since size has
     * been incremented by 1, the new copy will always result in the array incrementing whenever an
     * element
     * exceeds the bounds of the array.
     *
     * @param obj   The object to insert at the index.
     * @param index
     */
    public void insert(T obj, int index) {
        if (index < 0 || index > size)
            throw new PizzaException();
        if (size == max)
            increaseSize();
        T that = (T) obj;

        insertElement(index);

        objects[index] = that;
        size++;
    }

    /**
     * Shifts the corresponding elements in the Arraylist to the right in order
     * to create room for the insertion of the element. Shifts each element
     * at the index one wishes to insert at and moves all those elements
     * over to the right by one.
     *
     * @param index The index at which the insertion will take place.
     */
    private void insertElement(int index) {
        for (int i = size - 1; i >= index; i--) {
            objects[i + 1] = objects[i];
        }
    }

    /**
     * If size is greater than zero, then call System.arraycopy, removing the specified index and
     * then copying the array
     * over with the specified index removed at that point and all proceeding elements decremented by 1.
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= max)
            throw new PizzaException("Insertion at invalid index");
        Object temp = removeAtIndex(index);
        size--;
        return (T) temp;
    }

    /**
     * Shifts the corresponding elements in the Arraylist to the left in order
     * to create allow for the deletion of an element. Shifts each element
     * at the index one to the left by one after removal and moves all those elements
     * over to the left by one at the point of removal to ensure that there are
     * no null elements within the array after a deletion is completed.
     *
     * @param index The index at which the insertion will take place.
     */
    private T removeAtIndex(int index) {
        Object temp = objects[index];
        for (int i = index; i < size; i++) {
            objects[i] = objects[i + 1];
        }
        return (T) temp;
    }

    /**
     * @return size
     * Method that returns the current size of the ArrayList. (Whenever an element is added to the array, the class
     * variable
     * size will increment, likewise - whenever an element is removed from the array the class variable size will
     * decrement
     */
    public int size() {
        return size;
    }

    /**
     * @return String
     * Method Logic:
     * Iterates through the Objects array, and if the element isn't null concatenates an element to the local String
     * retVal.
     */
    @Override
    public String toString() {
        String retVal = "";
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                retVal += objects[i].toString() + " " +
                        "\n";
            }
        }
        return retVal;
    }

    /**
     * Method that functions to check if the ArrayList is empty.
     * If the instance variable size, which keeps track of how many
     * elements are in the ArrayLis is equivalent to zero, then
     * return a boolean indicating that is true.
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Iterate through the array returning the index where there is a match. Otherwise, return -1.
     * @param ob the element to be found
     * @return the index at which the target was found, if not found return -1.
     */
    public int indexOf(Object ob) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == ob) {
                return i;
            }
        }
        return -1;
    }

    /**
     * increaseSize
     * Creates a temporary array with size 10 greater than the objects array
     * ccopies all values from the objects array into the tmeporary array
     * sets a reference for the temporary array pointing to the objects array.
     */
    private void increaseSize() {
        max = max + 10;
        Object[] temp = new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = objects[i];
        }
        objects = temp;
    }

    /**
     * @param ob
     * @return boolean
     * <p>
     * Description:
     * Returns a comparision between the object taken as an arguement and the current object of the class.
     */
    @Override
    public boolean equals(Object ob) {
        boolean result = false;
        if (ob instanceof ArrayList) {
            ArrayList that = (ArrayList) ob;
            result = (this.getObjects() == that.getObjects());
        }
        return result;
    }

    /**
     * iterator()
     * Method definition to satisfy Iterable's interface
     *
     * @return a reference to the IteratorArrayList inner class
     */
    public Iterator iterator() {
        return new IteratorArrayList(objects, size);
    }

    /**
     * This class defines the interface Iterator so that the objects in ArrayList have the functionality of
     * being iterable.
     */
    private class IteratorArrayList implements Iterator {
        private int position;
        private int length;
        private Object[] list;

        /**
         * iteratorArrayList
         * Paramaterized constructor for IteratorArrayList
         *
         * @param objects assigns a reference to the list
         * @param size    the amount of values in the arraylist
         */
        public IteratorArrayList(Object[] objects, int size) {
            list = objects.clone();
            length = size;
            position = 0;
        }

        /**
         * hasNext(0
         * Checks if the array has a next value by comparing its position and its length
         * If the element at the index (position) of the list is null then there is no next value.
         * This means that there is a precondition for every element being sequential in the arraylist.
         *
         * @return boolean
         */
        public boolean hasNext() {
            return position < length && list[position] != null;
        }

        /**
         * next()
         * Retrieves the next element in the list
         * If there is no element, throw an exception.
         *
         * @return Object
         */
        public Object next() {
            if (hasNext()) {
                Object curr = list[position];
                position++;
                return curr;
            }
            throw new NoSuchElementException();
        }

        /**
         * Remove()
         * Kept here to satisfy the compiler.
         * Choosing to not define remove and throwing an exception
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Tests the Arraylist class
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Pizza> p = new ArrayList<Pizza>();
        p.insert(new Pizza(), 0);
        p.insert(new Pizza(), 1);
        p.insert(new Pizza(), 2);
        p.insert(new Pizza(), 3);
        System.out.println(p.toString());

        System.out.println("REMOVING SECOND PIZZA");
        p.remove(1);

        System.out.println("Displaying pizzas again");
        System.out.println(p.toString());
    }
}
