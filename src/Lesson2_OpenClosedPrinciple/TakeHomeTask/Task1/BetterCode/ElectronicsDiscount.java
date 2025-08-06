// ElectronicsDiscount.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task1.BetterCode;

public class ElectronicsDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.10; // 10% discount
    }
}
