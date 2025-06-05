package machine.supplycalculator;

import machine.coffees.Espresso;
import machine.coffees.Latte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SupplyCalculatorTest {

    @Test
    void espressoCalculationIgnoresMilk() {
        SupplyCalculator sc = new SupplyCalculator(500, 100, 160, 10);
        int cups = sc.calculateSuppliesBeforeSell(new Espresso());
        // Water allows 2 cups, coffee beans allow 10 cups, cups allow 10.
        // Milk should not limit the result since espresso uses none.
        assertEquals(2, cups);
    }

    @Test
    void latteCalculationUsesMilk() {
        SupplyCalculator sc = new SupplyCalculator(1000, 300, 100, 10);
        int cups = sc.calculateSuppliesBeforeSell(new Latte());
        // Latte requires 350 water, 75 milk, 20 beans per cup
        // Water -> 2 cups, Milk -> 4 cups, Coffee -> 5 cups, Cups ->10
        // Expected minimum is 2 (by water)
        assertEquals(2, cups);
    }
}
