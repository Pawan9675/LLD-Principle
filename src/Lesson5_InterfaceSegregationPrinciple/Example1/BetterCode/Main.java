// Main.java - Clean and simple code with good design
package Lesson5_InterfaceSegregationPrinciple.Example1.BetterCode;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== GOOD DESIGN - FOLLOWING ISP ===");
        
        // Create different users
        Seller seller = new Seller();
        Buyer buyer = new Buyer();
        Admin admin = new Admin();
        
        ProductService service = new ProductService();
        
        System.out.println("\n--- Testing Individual Capabilities ---");
        
        // Each user can only call methods they actually support
        buyer.buyProduct();           // ✅ Works perfectly
        seller.addProduct();          // ✅ Works perfectly  
        admin.approveProduct();       // ✅ Works perfectly
        
        // These won't even compile - which is GOOD!
        // buyer.approveProduct();    // ❌ Compile error - method doesn't exist
        // seller.approveProduct();   // ❌ Compile error - method doesn't exist
        
        System.out.println("\n--- Testing with Service Layer ---");
        
        // Service methods work with interfaces, not concrete classes
        service.processPurchase(buyer);        // Buyer can buy
        service.processPurchase(seller);       // Seller can also buy
        service.processPurchase(admin);        // Admin can also buy
        
        service.processProductAddition(seller); // Seller can add
        service.processProductAddition(admin);  // Admin can also add
        // service.processProductAddition(buyer); // ❌ Won't compile - Buyer can't add
        
        service.processApproval(admin);         // Only admin can approve
        // service.processApproval(seller);     // ❌ Won't compile - Seller can't approve
        // service.processApproval(buyer);      // ❌ Won't compile - Buyer can't approve
        
        System.out.println("\n--- Demonstrating Polymorphism ---");
        
        // We can treat objects by their specific capabilities
        ICanBuyProducts[] buyers = {buyer, seller, admin};
        for (ICanBuyProducts b : buyers) {
            b.buyProduct();
        }
        
        ICanAddProducts[] adders = {seller, admin}; // Only seller and admin can add
        for (ICanAddProducts a : adders) {
            a.addProduct();
        }
        
        // Only admin can approve
        ICanApproveProducts[] approvers = {admin};
        for (ICanApproveProducts a : approvers) {
            a.approveProduct();
        }
        
        System.out.println("\n--- Benefits Demonstrated ---");
        System.out.println("✅ No forced method implementations");
        System.out.println("✅ No exceptions thrown for unsupported operations");
        System.out.println("✅ No type checking needed");
        System.out.println("✅ Code won't even compile if you try wrong operations");
        System.out.println("✅ Each class only implements what it actually needs");
        System.out.println("✅ Easy to add new user types with different capabilities");

        System.out.println("\n INTERFACE SEGREGATION PRINCIPLE ACHIEVED!");
        System.out.println("Each interface has a single, clear responsibility.");
        System.out.println("Classes implement only the behaviors they actually possess.");
    }
}