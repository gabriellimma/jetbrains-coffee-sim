package machine.coffees;

import machine.menu.CoffeeOptions;

/**
 * A factory class for creating different types of coffee drinks based on user selection.
 * This class uses the {@link CoffeeOptions} enum to determine which coffee instance to create.
 */
public class CoffeeFactory {
    /**
     * Creates and returns a specific type of {@link Coffee} based on the given {@link CoffeeOptions}.
     *
     * @param option the selected coffee option
     * @return a new instance of a specific Coffee subclass (Espresso, Latte, Cappuccino)
     * @throws IllegalArgumentException if the coffee option is not recognized
     */
    public static Coffee createCoffee(CoffeeOptions option) {
        return switch (option) {
            case ESPRESSO -> new Espresso();
            case LATTE -> new Latte();
            case CAPPUCCINO -> new Cappuccino();
            default -> throw new IllegalArgumentException("Invalid coffee option: " + option);
        };
    }
}
