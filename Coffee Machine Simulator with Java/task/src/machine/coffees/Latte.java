package machine.coffees;

/**
 * Represents a latte coffee with specific amounts of water, coffee beans, milk, and price.
 * This class extends the base {@code Coffee} class and includes milk as an additional required ingredient.
 */
public class Latte extends Coffee {

    private final int milkNeeded;

    /**
     * Constructs a customized latte with the specified ingredient amounts and price.
     *
     * @param waterNeeded the amount of water required for the latte
     * @param coffeeBeansNeeded the amount of coffee beans required
     * @param milkNeeded the amount of milk required
     * @param price the selling price of the latte
     */
    public Latte(int waterNeeded, int coffeeBeansNeeded, int milkNeeded, int price) {
        super(waterNeeded, coffeeBeansNeeded, price);
        this.milkNeeded = milkNeeded;
    }

    /**
     * Constructs a default latte with 350 ml of water, 20 g of coffee beans,
     * 75 ml of milk, and a price of 7.
     */
    public Latte() {
        super(350, 20, 7);
        milkNeeded = 75;
    }

    /**
     * Returns the amount of milk required for the latte.
     *
     * @return the milk requirement in milliliters
     */
    public int getMilkNeeded() {
        return milkNeeded;
    }
}
