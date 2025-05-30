package machine.menu;

/**
 * Represents the types of coffee available in the machine,
 * each associated with a numeric code.
 * Used to map user input to specific coffee selections.
 */
public enum CoffeeOptions {
    ESPRESSO("1"),
    LATTE("2"),
    CAPPUCCINO("3"),
    BACK("back");

    /**
     * Numeric code corresponding to the coffee option (e.g., 1 for espresso).
     */
    private final String code;

    /**
     * Constructs a CoffeeOptions enum with an associated numeric code.
     *
     * @param code the numeric code of the coffee option
     */
    CoffeeOptions(String code) {
        this.code = code;
    }

    /**
     * Returns the numeric code of the coffee option.
     *
     * @return the numeric code
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the corresponding CoffeeOptions enum for a given numeric code.
     *
     * @param code the numeric code to look up
     * @return the corresponding CoffeeOptions enum
     * @throws IllegalArgumentException if the code does not match any option
     */
    public static CoffeeOptions fromCode(String code) {
        for(CoffeeOptions coffeeOption : CoffeeOptions.values()) {
            if(coffeeOption.getCode().equalsIgnoreCase(code)) {
                return coffeeOption;
            }
        }
        throw new IllegalArgumentException("Invalid Coffee Option");
    }
}
