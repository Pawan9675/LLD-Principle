// Main.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task2.BetterCode;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle truck = new Truck();

        VehicleInsuranceEvaluator evaluator = new VehicleInsuranceEvaluator();

        InsuranceQuote carQuote = evaluator.evaluateInsurance(car);
        InsuranceQuote truckQuote = evaluator.evaluateInsurance(truck);

        System.out.println("Car Insurance Evaluated: " + carQuote);
        System.out.println("Truck Insurance Evaluated: " + truckQuote);
    }
}
