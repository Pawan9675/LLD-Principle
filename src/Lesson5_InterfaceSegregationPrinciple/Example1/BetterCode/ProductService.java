// ProductService.java - Service class that works with different user types
package Lesson5_InterfaceSegregationPrinciple.Example1.BetterCode;

public class ProductService {
    
    // Method that works with anyone who can buy products
    public void processPurchase(ICanBuyProducts buyer) {
        buyer.buyProduct();
        System.out.println("Purchase processed successfully!");
    }
    
    // Method that works with anyone who can add products
    public void processProductAddition(ICanAddProducts seller) {
        seller.addProduct();
        System.out.println("Product addition processed!");
    }
    
    // Method that works with anyone who can approve products
    public void processApproval(ICanApproveProducts approver) {
        approver.approveProduct();
        System.out.println("Product approval processed!");
    }
    
    // Method that works with anyone who can modify products
    public void processModification(ICanModifyProducts modifier) {
        modifier.modifyProduct();
        System.out.println("Product modification processed!");
    }
}