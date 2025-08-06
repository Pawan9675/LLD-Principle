// Car.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task2.BetterCode;

public class Car extends Vehicle {
    @Override
    public InsuranceQuote evaluateInsurance() {
        // Car-specific insurance logic
        return new InsuranceQuote(); // can include logic or params if needed
    }
}
