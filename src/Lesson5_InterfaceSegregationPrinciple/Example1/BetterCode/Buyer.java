// Buyer.java - Only implements what it actually needs
package Lesson5_InterfaceSegregationPrinciple.Example1.BetterCode;

public class Buyer implements ICanBuyProducts {
    
    @Override
    public void buyProduct() {
        System.out.println("Buyer purchasing a product");
    }
    
    // Buyer doesn't have any other methods - perfect!
    // No forced implementations, no exceptions to throw!
}