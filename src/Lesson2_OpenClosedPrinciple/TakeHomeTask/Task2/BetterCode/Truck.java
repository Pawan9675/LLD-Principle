// Truck.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task2.BetterCode;

public class Truck extends Vehicle {
    @Override
    public InsuranceQuote evaluateInsurance() {
        // Truck-specific insurance logic
        return new InsuranceQuote(); // can include logic or params if needed
    }
}
