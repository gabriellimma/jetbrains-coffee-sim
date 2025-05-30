package machine.menu;

import machine.cashregister.CashRegister;
import machine.messages.PrintMessages;
import machine.supplycalculator.SupplyCalculator;
import machine.supplycalculator.SupplyCalculatorDialog;
import machine.coffees.*;

import java.util.Scanner;

/**
 * Represents the main menu interface for the Coffee Machine Simulator.
 * This class manages user interactions such as buying coffee, refilling supplies,
 * taking money, cleaning the machine, and displaying remaining resources.
 */
public class Menu {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Displays the main menu and handles user input to perform different actions
     * such as buy, fill, take, clean, check remaining supplies, or exit.
     */
    public static void showMenu() {

        SupplyCalculator supplyCalculator = new SupplyCalculator(400, 540, 120, 9);
        CashRegister cashRegister = new CashRegister(550);
        SupplyCalculatorDialog SDC = new SupplyCalculatorDialog();
        boolean showMenu = true;

        while (showMenu) {
            PrintMessages.printAction();
            MenuOptions option = MenuOptions.fromString(sc.nextLine());

            switch (option) {
                case BUY -> {
                    if(SupplyCalculator.isReadyToClean()) {
                        PrintMessages.printReadyToCleanMessage();
                    } else {
                        showBuyMenu(supplyCalculator, cashRegister);
                    }
                }
                case FILL -> {
                    showFillMenu(supplyCalculator);
                    System.out.println();
                }
                case TAKE -> {
                    showTakeMenu(cashRegister);
                }
                case CLEAN -> {
                    SupplyCalculator.cleanMachine();
                }
                case REMAINING -> {
                    SDC.printCoffeeMachineSupplies(supplyCalculator, cashRegister);
                }
                case EXIT -> {
                    showMenu = false;
                }
            }
        }

    }

    /**
     * Displays the coffee selection menu and processes the coffee purchase.
     *
     * @param supplyCalculator the current supply calculator managing resources
     * @param cashRegister the cash register handling transactions
     */
    private static void showBuyMenu(SupplyCalculator supplyCalculator, CashRegister cashRegister) {
        PrintMessages.printWhatCoffeeToBuy();
        CoffeeOptions coffeeOptions = CoffeeOptions.fromCode(sc.nextLine().trim());

        if(coffeeOptions == CoffeeOptions.BACK) {
            return;
        }

        Coffee coffee = CoffeeFactory.createCoffee(coffeeOptions);
        supplyCalculator.sellCoffee(coffee, cashRegister);
    }

    /**
     * Prompts the user to input amounts for refilling water, milk, coffee beans,
     * and disposable cups, then updates the supply calculator accordingly.
     *
     * @param supplyCalculator the supply calculator to be updated
     */
    public static void showFillMenu(SupplyCalculator supplyCalculator) {
        PrintMessages.printHowManyWaterToFill();
        int water = sc.nextInt();
        PrintMessages.printHowManyMilkToFill();
        int milk = sc.nextInt();
        PrintMessages.printHowManyGramsCoffeeToFill();
        int coffee = sc.nextInt();
        PrintMessages.printHowManyDisposableCupsToFill();
        int cups = sc.nextInt();
        sc.nextLine();
        supplyCalculator.fillSupplies(water, milk, coffee, cups);
    }

    /**
     * Executes the action to take all money from the cash register.
     *
     * @param cashRegister the cash register from which to withdraw money
     */
    public static void showTakeMenu(CashRegister cashRegister) {
        cashRegister.take();
    }
}
