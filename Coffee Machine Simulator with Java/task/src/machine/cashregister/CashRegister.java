package machine.cashregister;

/**
 * Represents a cash register in the coffee machine simulation.
 */
public class CashRegister {
    private int money;

    /**
     * Initializes the cash register with a starting amount of money.
     *
     * @param money the initial amount of money in the register
     * @throws IllegalArgumentException if the initial amount is negative
     */
    public CashRegister(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("Cash register should not be initialized with negative numbers.");
        }
        this.money = money;
    }

    /**
     * Returns the current amount of money in the register.
     *
     * @return the current money amount
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the internal amount of money in the register.
     *
     * @param money the new amount to set
     */
    private void setMoney(int money) {
        this.money = money;
    }

    /**
     * Adds a specified amount of money to the register.
     *
     * @param money the amount to add
     * @throws IllegalArgumentException if the amount is negative
     */
    public void charge(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("charge amount can't be negative.");
        }
        setMoney(getMoney() + money);
    }

    /**
     * Empties the register and prints the amount that was removed.
     */
    public void take() {
        int money = getMoney();
        setMoney(0);
        System.out.printf("I gave you $%d%n%n", money);
    }
}
