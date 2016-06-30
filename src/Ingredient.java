public class Ingredient {
    private String description;
    private final Money cost;
    private final int calories;

    public Ingredient(String description, Money cost, int calories) {
        if (description != null && cost != null && calories > 0) {
            this.description = description;
            this.cost = cost;
            this.calories = calories;
        }else{
            throw new PizzaException("Error in ingredient");
        }
    }

    public Money getCost(){
        return new Money(cost);
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "Description " + description + ", " + cost.toString() + ", " + "Calories: " + calories + " \n";
    }

    public int getCalories(){
        return calories;
    }

    /**
     * Tests all instances of the child classes of Ingredient
     * @param args
     */
    public static void main(String[] args){
        Vegetable o = new Olive();
        Vegetable p = new Pepper();
        Meat s = new Sausage();
        Meat pep = new Pepperoni();
        Base m = new Marinara();
        Base a = new Alfredo();
        Cheese g = new Goat();
        Cheese moz = new Mozzarella();

        System.out.println(o);
        System.out.println(p);
        System.out.println(s);
        System.out.println(pep);
        System.out.println(m);
        System.out.println(a);
        System.out.println(g);
        System.out.println(moz);
    }
}
