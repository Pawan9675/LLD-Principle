// Buyer.java - Forced to implement methods it doesn't need
package Lesson5_InterfaceSegregationPrinciple.Example1.ProblematicCode;

public class Buyer implements User {
    
    @Override
    public boolean canBuyProducts() {
        return true; // Buyers can buy products
    }

    @Override
    public boolean canModifyProducts() {
        return false; // Buyers CANNOT modify products
    }

    @Override
    public boolean canAddProducts() {
        return false; // Buyers CANNOT add products
    }

    @Override
    public boolean canApproveProducts() {
        return false; // Buyers CANNOT approve products
    }

    @Override
    public void approveProduct() {
        // Buyer doesn't need this but is FORCED to implement it!
        throw new UnsupportedOperationException("Buyer cannot approve products!");
    }
    
    @Override
    public void buyProduct() {
        System.out.println("Buyer purchasing a product");
    }
    
    @Override
    public void addProduct() {
        // Buyer doesn't need this but is FORCED to implement it!
        throw new UnsupportedOperationException("Buyer cannot add products!");
    }
    
    @Override
    public void modifyProduct() {
        // Buyer doesn't need this but is FORCED to implement it!
        throw new UnsupportedOperationException("Buyer cannot modify products!");
    }
}