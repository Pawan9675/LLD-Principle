// Admin.java - Implements all interfaces because admin can do everything
package Lesson5_InterfaceSegregationPrinciple.Example1.BetterCode;

public class Admin implements ICanAddProducts, ICanModifyProducts, 
                             ICanBuyProducts, ICanApproveProducts {
    
    @Override
    public void addProduct() {
        System.out.println("Admin adding a product to the system");
    }

    @Override
    public void modifyProduct() {
        System.out.println("Admin modifying any product in the system");
    }

    @Override
    public void buyProduct() {
        System.out.println("Admin buying a product");
    }

    @Override
    public void approveProduct() {
        System.out.println("Admin approving a product for sale");
    }
}