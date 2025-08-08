// Main.java - Problems with the bad design
package Lesson5_InterfaceSegregationPrinciple.Example1.ProblematicCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BAD DESIGN - VIOLATING ISP ===");
        
        List<User> users = new ArrayList<>();
        users.add(new Seller());
        users.add(new Buyer());
        users.add(new Admin());

        // Problem 1: We need to check user type before calling methods
        for (User user : users) {
            System.out.println("\nUser: " + user.getClass().getSimpleName());
            
            // Safe operations for all users
            if (user.canBuyProducts()) {
                user.buyProduct();
            }
            
            // Dangerous operations - need type checking!
            if (user instanceof Admin) {
                user.approveProduct(); // Only admin should do this
            }
            
            // What if we accidentally call wrong methods?
            try {
                if (user instanceof Buyer) {
                    user.addProduct(); // This will throw exception!
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        
        // Problem 2: Code is fragile and needs lots of type checking
        User someUser = new Buyer();
        if (someUser.canApproveProducts()) {
            someUser.approveProduct();
        } else {
            System.out.println("User cannot approve products");
        }

        System.out.println("\n❌ PROBLEMS WITH THIS DESIGN:");
        System.out.println("1. Seller and Buyer forced to implement methods they don't use");
        System.out.println("2. Many methods return false or throw exceptions");
        System.out.println("3. Code is confusing and error-prone");
        System.out.println("4. Adding new methods to User interface breaks all classes");
    }
}