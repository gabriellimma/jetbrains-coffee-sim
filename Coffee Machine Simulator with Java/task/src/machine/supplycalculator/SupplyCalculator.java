package machine.supplycalculator;

import machine.cashregister.CashRegister;
import machine.coffees.Coffee;

import java.util.stream.Stream;

/**
 * Manages the ingredient supplies for the coffee machine.
 * Responsible for tracking and updating water, milk, coffee beans, and disposable cups,
 * as well as determining if a coffee can be made based on current supplies.
 */
public class SupplyCalculator {

    private int waterSupply;
    private int milkSupply;
    private int gramsCoffeeSupply;
    private int disposableCupsSupply;
    public static int coffeesMade;


    /**
     * Initializes the supply calculator with specific amounts of ingredients.
     *
     * @param waterSupply the amount of water in milliliters
     * @param milkSupply the amount of milk in milliliters
     * @param gramsCoffeeSupply the amount of coffee beans in grams
     * @param disposableCupsSupply the number of disposable cups
     * @throws IllegalArgumentException if any of the inputs are negative
     */
    public SupplyCalculator(int waterSupply, int milkSupply, int gramsCoffeeSupply, int disposableCupsSupply) {
        if (waterSupply < 0 || milkSupply < 0 || gramsCoffeeSupply < 0 || disposableCupsSupply < 0) {
            throw new IllegalArgumentException("Supplies cannot be negative");
        }
        this.waterSupply = waterSupply;
        this.milkSupply = milkSupply;
        this.gramsCoffeeSupply = gramsCoffeeSupply;
        this.disposableCupsSupply = disposableCupsSupply;
    }

    /**
     * Adds the specified amounts to the current supplies.
     *
     * @param waterAmount amount of water to add in milliliters
     * @param milkAmount amount of milk to add in milliliters
     * @param gramsCoffeeAmount amount of coffee beans to add in grams
     * @param cupsAmount number of disposable cups to add
     * @throws IllegalArgumentException if any of the inputs are negative
     */
    public void fillSupplies(int waterAmount, int milkAmount, int gramsCoffeeAmount, int cupsAmount) {
        if (waterAmount < 0 || milkAmount < 0 || gramsCoffeeAmount < 0 || cupsAmount < 0) {
            throw new IllegalArgumentException("FillSupplies does not support negative arguments");
        }
        setWaterSupply(getWaterSupply() + waterAmount);
        setMilkSupply(getMilkSupply() + milkAmount);
        setGramsCoffeeSupply(getGramsCoffeeSupply() + gramsCoffeeAmount);
        setDisposableCupsSupply(getDisposableCupsSupply() + cupsAmount);
    }

    /**
     * Calculates the maximum number of cups that can be made with current supplies
     * for a given coffee recipe.
     *
     * @param coffee the coffee object with resource requirements
     * @return the number of cups that can be made
     */
    public int calculateSuppliesBeforeSell(Coffee coffee) {
        int cupsByWater = waterSupply / coffee.getWaterNeeded();
        int cupsByMilk = coffee.getMilkNeeded() != 0 ? milkSupply / coffee.getMilkNeeded() : Integer.MAX_VALUE;
        int cupsByCoffee = gramsCoffeeSupply / coffee.getCoffeeBeansNeeded();
        int disposableCupsNeeded = disposableCupsSupply / coffee.getDisposableCupsNeeded();

        return Stream.of(
                cupsByWater,
                cupsByMilk,
                cupsByCoffee,
                disposableCupsNeeded
        ).min(Integer::compare).orElse(0);
    }

    /**
     * Attempts to make a coffee and deducts the necessary supplies if successful.
     * If supplies are insufficient, prints an appropriate warning.
     *
     * @param coffee the coffee to be made
     * @param cashRegister the cash register to update with the coffee's price
     */
    public void sellCoffee(Coffee coffee, CashRegister cashRegister) {
        int maxCoffeeCups = calculateSuppliesBeforeSell(coffee);
        if(maxCoffeeCups == 0) {
            if (waterSupply < coffee.getWaterNeeded()) {
                System.out.println("Sorry, not enough water!");
                return;
            }

            if (milkSupply < coffee.getMilkNeeded()) {
                System.out.println("Sorry, not enough milk!");
                return;
            }

            if (gramsCoffeeSupply < coffee.getCoffeeBeansNeeded()) {
                System.out.println("Sorry, not enough coffee beans!");
                return;
            }

            if (disposableCupsSupply < coffee.getDisposableCupsNeeded()) {
                System.out.println("Sorry, not enough disposable cups!");
            }
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            coffeesMade++;
            setWaterSupply(getWaterSupply() - coffee.getWaterNeeded());
            setMilkSupply(getMilkSupply() - coffee.getMilkNeeded());
            setGramsCoffeeSupply(getGramsCoffeeSupply() - coffee.getCoffeeBeansNeeded());
            setDisposableCupsSupply(getDisposableCupsSupply() - coffee.getDisposableCupsNeeded());
            cashRegister.charge(coffee.getPrice());
        }
    }

    /**
     * Checks if the machine needs cleaning after making a set number of coffees.
     *
     * @return true if 10 or more coffees have been made
     */
    public static boolean isReadyToClean() {
        return coffeesMade >= 10;
    }

    /**
     * Resets the coffee count and prints a cleaning confirmation message.
     */
    public static void cleanMachine(){
        coffeesMade = 0;
        System.out.println("I have been cleaned!");
    }

    /**
     * Returns the current amount of water.
     *
     * @return the amount of water
     */
    public int getWaterSupply() {
        return waterSupply;
    }

    /**
     * Updates the amount of water in the machine.
     *
     * @param waterSupply the new amount to set
     */
    private void setWaterSupply(int waterSupply) {
        this.waterSupply = waterSupply;
    }

    /**
     * Returns the current amount of milk.
     *
     * @return the amount of milk
     */
    public int getMilkSupply() {
        return milkSupply;
    }

    /**
     * Updates the amount of milk in the machine.
     *
     * @param milkSupply the new amount to set
     */
    private void setMilkSupply(int milkSupply) {
        this.milkSupply = milkSupply;
    }

    /**
     * Returns the current amount of coffee beans.
     *
     * @return the amount of coffee beans
     */
    public int getGramsCoffeeSupply() {
        return gramsCoffeeSupply;
    }

    /**
     * Updates the amount of coffee beans in the machine.
     *
     * @param gramsCoffeeSupply the new amount to set
     */
    private void setGramsCoffeeSupply(int gramsCoffeeSupply) {
        this.gramsCoffeeSupply = gramsCoffeeSupply;
    }

    /**
     * Returns the current amount of disposable cups.
     *
     * @return the amount of disposable cups
     */
    public int getDisposableCupsSupply() {
        return disposableCupsSupply;
    }

    /**
     * Updates the amount of disposable cups in the machine.
     *
     * @param disposableCupsSupply the new amount to set
     */
    private void setDisposableCupsSupply(int disposableCupsSupply) {
        this.disposableCupsSupply = disposableCupsSupply;
    }
}
