// Main.java - Demonstrates the Basic Builder Pattern
package BuilderDesignPattern.BetterCode.BetterApproach3_UsingBuilderClass_BasicBuilderPattern;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Better Approach #3: Using Builder Class (Basic Builder Pattern) ===\n");

        // Example 1: Complete product creation using Builder
        System.out.println("--- Example 1: Complete Product Creation ---");
        try {
            // Step 1: Create and configure Builder
            Builder b1 = new Builder();
            b1.setName("iPhone 15 Pro");
            b1.setDesc("Latest flagship smartphone from Apple");
            b1.setBrand("Apple");
            b1.setCategory("Electronics");
            b1.setPrice(1200);
            b1.setDiscount(10);
            b1.setCreatedAt("2023-12-01");
            b1.setUpdatedAt("2023-12-01");
            b1.addImage("front.jpg");
            b1.addImage("back.jpg");
            b1.addImage("side.jpg");
            
            // Optional: Show builder state before creating product
            b1.displayBuilderState();
            
            // Step 2: Create Product using Builder
            Product p1 = new Product(b1);
            p1.displayProduct();
            
        } catch (Exception e) {
            System.out.println("Failed to create product: " + e.getMessage());
        }

        // Example 2: Minimal product creation
        System.out.println("--- Example 2: Minimal Product Creation ---");
        try {
            Builder b2 = new Builder();
            b2.setName("Samsung Galaxy S24");
            b2.setBrand("Samsung");
            b2.setPrice(900);
            // Only required fields - optional fields remain null/default
            
            Product p2 = new Product(b2);
            p2.displayProduct();
            
        } catch (Exception e) {
            System.out.println("Failed to create product: " + e.getMessage());
        }

        // Example 3: Building step by step (flexible order)
        System.out.println("--- Example 3: Flexible Order of Configuration ---");
        try {
            Builder b3 = new Builder();
            
            // Properties can be set in ANY order
            b3.setPrice(1500);                    // Set price first
            b3.setDiscount(20);                   // Then discount
            b3.setBrand("Sony");                  // Then brand
            b3.setName("Sony WH-1000XM5");        // Then name
            b3.setCategory("Audio");              // Then category
            b3.setDesc("Premium noise-cancelling headphones");
            
            Product p3 = new Product(b3);
            p3.displayProduct();
            
        } catch (Exception e) {
            System.out.println("Failed to create product: " + e.getMessage());
        }

        System.out.println("=== Benefits of Basic Builder Pattern ===");
        System.out.println("✅ No bloated constructor - Product takes only Builder");
        System.out.println("✅ Validation BEFORE object creation - in Product constructor");
        System.out.println("✅ No missing properties - Builder always has all properties");
        System.out.println("✅ No spelling mistakes - using method calls, not string keys");
        System.out.println("✅ Type safety - each setter expects correct data type");
        System.out.println("✅ IDE support - auto-completion, error checking");
        System.out.println("✅ Flexible - can set properties in any order");
    }
}