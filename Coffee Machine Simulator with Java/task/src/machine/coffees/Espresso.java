package machine.coffees;

/**
 * Represents an espresso coffee with specific amounts of water, coffee beans, and price.
 * This class extends the base {@code Coffee} class with preset or custom values.
 */
public class Espresso extends Coffee{

    /**
     * Constructs a customized espresso with the specified ingredient amounts and price.
     *
     * @param waterNeeded the amount of water required for the espresso
     * @param coffeeBeansNeeded the amount of coffee beans required
     * @param price the selling price of the espresso
     */
    public Espresso(int waterNeeded, int coffeeBeansNeeded, int price) {
        super(waterNeeded, coffeeBeansNeeded, price);
    }

    /**
     * Constructs a default espresso with 250 ml of water, 16 g of coffee beans, and a price of 4.
     */
    public Espresso() {
        super(250, 16, 4);
    }
}
