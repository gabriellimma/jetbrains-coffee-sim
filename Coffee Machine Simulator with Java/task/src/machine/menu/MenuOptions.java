package machine.menu;

/**
 * Enum representing the available menu options in the Coffee Machine Simulator.
 * Each option corresponds to a user command such as buying coffee, filling supplies,
 * taking money, cleaning the machine, displaying remaining supplies, or exiting.
 */
public enum MenuOptions {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    CLEAN("clean"),
    REMAINING("remaining"),
    EXIT("exit");

    /**
     * The string representation of the menu option used for matching user input.
     */
    private final String value;

    /**
     * Constructs a MenuOptions enum constant with a corresponding string value.
     *
     * @param value the string representation of the menu option
     */
    MenuOptions(String value) {
        this.value = value;
    }

    /**
     * Returns the string representation of the menu option.
     *
     * @return the menu option as a string
     */
    public String getValue() {
        return value;
    }

    /**
     * Converts a string to a corresponding MenuOptions enum constant.
     *
     * @param input the string input (e.g., "buy", "fill", "take")
     * @return the corresponding MenuOptions enum, or null if no match is found
     */
    public static MenuOptions fromString(String input) {
        for (MenuOptions option : MenuOptions.values()) {
            if (option.getValue().equalsIgnoreCase(input)) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid option");
    }
}
