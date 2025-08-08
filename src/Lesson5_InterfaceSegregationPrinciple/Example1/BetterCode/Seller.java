// Seller.java - Only implements interfaces for capabilities it actually has
package Lesson5_InterfaceSegregationPrinciple.Example1.BetterCode;

public class Seller implements ICanModifyProducts, ICanBuyProducts, ICanAddProducts {
    
    @Override
    public void buyProduct() {
        System.out.println("Seller buying a product from another seller");
    }

    @Override
    public void modifyProduct() {
        System.out.println("Seller modifying their existing product");
    }

    @Override
    public void addProduct() {
        System.out.println("Seller adding a new product to sell");
    }
    
    // Notice: Seller doesn't implement ICanApproveProducts
    // So it doesn't have approveProduct() method at all!
    // No forced implementation, no exceptions to throw!
}