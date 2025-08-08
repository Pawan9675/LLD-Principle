// Seller.java - Forced to implement methods it doesn't need
package Lesson5_InterfaceSegregationPrinciple.Example1.ProblematicCode;

public class Seller implements User {
    
    @Override
    public boolean canBuyProducts() {
        return true; // Sellers can buy from other sellers
    }

    @Override
    public boolean canModifyProducts() {
        return true; // Sellers can modify their own products
    }

    @Override
    public boolean canAddProducts() {
        return true; // Sellers can add new products
    }

    @Override
    public boolean canApproveProducts() {
        return false; // Sellers CANNOT approve products
    }

    @Override
    public void approveProduct() {
        // Seller doesn't need this but is FORCED to implement it!
        throw new UnsupportedOperationException("Seller cannot approve products!");
    }
    
    @Override
    public void buyProduct() {
        System.out.println("Seller buying a product from another seller");
    }
    
    @Override
    public void addProduct() {
        System.out.println("Seller adding a new product to sell");
    }
    
    @Override
    public void modifyProduct() {
        System.out.println("Seller modifying their existing product");
    }
}