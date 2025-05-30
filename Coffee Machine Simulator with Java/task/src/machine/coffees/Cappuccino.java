package machine.coffees;


/**
 * Represents a cappuccino coffee with specific amounts of water, coffee beans, milk, and price.
 * This class extends the base {@code Coffee} class and includes milk as an additional ingredient.
 */
public class Cappuccino extends Coffee {
    private final int milkNeeded;

    /**
     * Constructs a customized cappuccino with the specified ingredient amounts and price.
     *
     * @param waterNeeded the amount of water required for the cappuccino
     * @param coffeeBeansNeeded the amount of coffee beans required
     * @param milkNeeded the amount of milk required
     * @param price the selling price of the cappuccino
     */
    public Cappuccino(int waterNeeded, int coffeeBeansNeeded, int milkNeeded, int price) {
        super(waterNeeded, coffeeBeansNeeded, price);
        this.milkNeeded = milkNeeded;
    }

    /**
     * Constructs a default cappuccino with predefined values:
     * 200 ml water, 12 g coffee beans, 100 ml milk, and price of 6.
     */
    public Cappuccino() {
        super(200, 12, 6);
        milkNeeded = 100;
    }

    /**
     * Returns the amount of milk required for the cappuccino.
     *
     * @return the milk requirement in milliliters
     */
    public int getMilkNeeded() {
        return milkNeeded;
    }
}
