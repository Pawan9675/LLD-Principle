// VehicleInsuranceEvaluator.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task2.BetterCode;

public class VehicleInsuranceEvaluator {
    public InsuranceQuote evaluateInsurance(Vehicle vehicle) {
        return vehicle.evaluateInsurance();  // ✅ No need for instanceof
    }
}
