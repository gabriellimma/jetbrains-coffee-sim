
package machine.coffees;

/**
 * Represents a basic coffee drink with defined requirements for water, coffee beans, and price.
 * This class provides default behavior for milk and disposable cups, which can be overridden by subclasses.
 */
public class Coffee {

    private final int waterNeeded;
    private final int coffeeBeansNeeded;
    private final int price;

    /**
     * Constructs a coffee object with the specified amounts of water, coffee beans, and selling price.
     *
     * @param waterNeeded the amount of water required for the coffee
     * @param coffeeBeansNeeded the amount of coffee beans required
     * @param price the selling price of the coffee
     */
    public Coffee(int waterNeeded, int coffeeBeansNeeded, int price) {
        this.waterNeeded = waterNeeded;
        this.coffeeBeansNeeded = coffeeBeansNeeded;
        this.price = price;
    }

    /**
     * Returns the amount of water required to make the coffee.
     *
     * @return the required water in milliliters
     */
    public int getWaterNeeded() {
        return waterNeeded;
    }

    /**
     * Returns the amount of coffee beans required to make the coffee.
     *
     * @return the required coffee beans in grams
     */
    public int getCoffeeBeansNeeded() {
        return coffeeBeansNeeded;
    }

    /**
     * Returns the amount of milk required to make the coffee.
     * This base implementation returns 0, and should be overridden in subclasses that require milk.
     *
     * @return the required milk in milliliters
     */
    public int getMilkNeeded() {
        return 0;
    }

    /**
     * Returns the number of disposable cups required to serve the coffee.
     * By default, this is 1.
     *
     * @return the number of disposable cups
     */
    public int getDisposableCupsNeeded() {
        return 1;
    }

    /**
     * Returns the selling price of the coffee.
     *
     * @return the coffee price
     */
    public int getPrice() {
        return price;
    }
}
