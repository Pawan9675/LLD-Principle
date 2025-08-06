// DiscountCalculator.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task1.BetterCode;

public class DiscountCalculator {
    public double calculate(Product product, DiscountStrategy strategy) {
        return strategy.calculateDiscount(product);
    }
}
