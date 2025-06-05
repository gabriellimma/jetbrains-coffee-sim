package machine.supplycalculator;

import machine.cashregister.CashRegister;

/**
 * The {@code SupplyCalculatorDialog} class is responsible for interacting with
 * the user via the console to determine how many cups of coffee can be made
 * based on the available supplies of water, milk, and coffee beans.
 * <p>
 * This class prompts the user to input the current supplies and the desired
 * number of cups. It then calculates whether the coffee machine can make the
 * requested amount, less, or even more cups than requested, and provides a
 * descriptive message back to the user.
 * </p>
 * <p>
 * It relies on the {@link SupplyCalculator} class to perform the actual
 * calculation of how many cups can be made with the available ingredients.
 * </p>
 *
 * @author Gabriel Lima
 */
public class SupplyCalculatorDialog {

    /**
     * Prints the current state of the coffee machine, including supplies and money.
     *
     * @param supply the supply calculator instance holding information about ingredients
     * @param cashRegister the cash register instance holding information about current money
     */
    public void printCoffeeMachineSupplies(SupplyCalculator supply, CashRegister cashRegister) {
        String COFFEE_MACHINE_HAS = "The coffee machine has:";
        System.out.println(COFFEE_MACHINE_HAS);

        // print the supplies without leading indentation
        System.out.printf("""
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """.stripIndent(),
                supply.getWaterSupply(),
                supply.getMilkSupply(),
                supply.getGramsCoffeeSupply(),
                supply.getDisposableCupsSupply(),
                cashRegister.getMoney());
    }
}
