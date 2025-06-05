package machine.supplycalculator;

import machine.cashregister.CashRegister;

/**
 * Prints the current state of the coffee machine.
 * <p>
 * The class retrieves supply amounts from a {@link SupplyCalculator}
 * and the available money from a {@link CashRegister} and then
 * displays them to the console.
 * </p>
 * <p>
 * This dialog does not prompt the user for input or calculate
 * how many cups can be prepared.
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
        System.out.printf("""
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        $%d of money
                        
                        """,
                supply.getWaterSupply(),
                supply.getMilkSupply(),
                supply.getGramsCoffeeSupply(),
                supply.getDisposableCupsSupply(),
                cashRegister.getMoney());
    }
}
