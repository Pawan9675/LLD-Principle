// Main.java
package Lesson2_OpenClosedPrinciple.TakeHomeTask.Task1.BetterCode;

public class Main {
    public static void main(String[] args) {
        Product electronics = new Product(10000);
        Product clothing = new Product(2000);

        DiscountCalculator calculator = new DiscountCalculator();

        double electronicsDiscount = calculator.calculate(electronics, new ElectronicsDiscount());
        double clothingDiscount = calculator.calculate(clothing, new ClothingDiscount());

        System.out.println("Electronics Discount: ₹" + electronicsDiscount);
        System.out.println("Clothing Discount: ₹" + clothingDiscount);
    }
}
