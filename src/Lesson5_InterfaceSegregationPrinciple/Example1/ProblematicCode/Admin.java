// Admin.java - This works fine because Admin needs all methods
package Lesson5_InterfaceSegregationPrinciple.Example1.ProblematicCode;

public class Admin implements User {
    
    @Override
    public boolean canBuyProducts() {
        return true; // Admin can buy
    }

    @Override
    public boolean canModifyProducts() {
        return true; // Admin can modify
    }

    @Override
    public boolean canAddProducts() {
        return true; // Admin can add
    }

    @Override
    public boolean canApproveProducts() {
        return true; // Admin can approve
    }

    @Override
    public void approveProduct() {
        System.out.println("Admin approving a product for sale");
    }
    
    @Override
    public void buyProduct() {
        System.out.println("Admin buying a product");
    }
    
    @Override
    public void addProduct() {
        System.out.println("Admin adding a product to the system");
    }
    
    @Override
    public void modifyProduct() {
        System.out.println("Admin modifying any product in the system");
    }
}