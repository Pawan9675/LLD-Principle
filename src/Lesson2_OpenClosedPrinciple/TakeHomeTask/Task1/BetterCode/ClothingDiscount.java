// ClothingDiscount.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task1.BetterCode;

public class ClothingDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.20; // 20% discount
    }
}
