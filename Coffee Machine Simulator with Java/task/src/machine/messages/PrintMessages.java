package machine.messages;

public class PrintMessages {

    public static void printAction() {
        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
    }

    public static void printWhatCoffeeToBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    public static void printHowManyWaterToFill() {
        System.out.println("Write how many ml of water you want to add:");
    }

    public static void printHowManyMilkToFill() {
        System.out.println("Write how many ml of milk you want to add:");
    }

    public static void printHowManyGramsCoffeeToFill() {
        System.out.println("Write how many grams of coffee beans you want to add:");
    }

    public static void printHowManyDisposableCupsToFill() {
        System.out.println("Write how many disposable cups you want to add:");
    }

    public static void printReadyToCleanMessage() {
        System.out.println("I need cleaning!");
    }

}
