// Main.java
package BuilderDesignPattern.BetterCode.BetterApproach1_UsingGettersAndSetters;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Better Approach #1: Using Getters and Setters ===\n");

        // Creating Product objects using setters - Much cleaner and readable!
        
        // Example 1: Basic product creation
        System.out.println("--- Example 1: Basic Product Creation ---");
        Product p1 = new Product();
        p1.setName("iPhone 15");
        p1.setDesc("This is the latest iPhone from Apple");
        p1.setBrand("Apple");
        p1.setCategory("Electronics");
        p1.setPrice(1000);
        p1.setDiscount(10);
        p1.setCreatedAt("2023-12-01");
        p1.setUpdatedAt("2023-12-01");
        
        p1.displayProduct();

        // Example 2: Product with only essential information
        System.out.println("--- Example 2: Product with Minimal Info ---");
        Product p2 = new Product();
        p2.setName("Samsung Galaxy");
        p2.setPrice(800);
        p2.setBrand("Samsung");
        // Notice: We don't have to set ALL properties!
        
        p2.displayProduct();

        // Example 3: Product with images
        System.out.println("--- Example 3: Product with Images ---");
        Product p3 = new Product();
        p3.setName("MacBook Pro");
        p3.setDesc("Powerful laptop for professionals");
        p3.setBrand("Apple");
        p3.setPrice(2500);
        p3.setCategory("Laptop");
        
        // Adding images one by one
        p3.addImage("image1.jpg");
        p3.addImage("image2.jpg");
        p3.addImage("image3.jpg");
        
        p3.displayProduct();

        // Example 4: Demonstrating validation
        System.out.println("--- Example 4: Validation Examples ---");
        Product p4 = new Product();
        
        // These will trigger validation warnings
        p4.setName("");           // Empty name warning
        p4.setPrice(-500);        // Negative price warning
        p4.setDiscount(150);      // Invalid discount warning
        p4.setBrand("");          // Empty brand warning
        
        // Set valid values
        p4.setName("Valid Product");
        p4.setPrice(100);
        p4.setDiscount(20);
        p4.setBrand("Valid Brand");
        
        p4.displayProduct();

        // Example 5: Flexible order of setting properties
        System.out.println("--- Example 5: Flexible Property Setting ---");
        Product p5 = new Product();
        
        // Properties can be set in ANY order - very flexible!
        p5.setPrice(1500);        // Set price first
        p5.setBrand("Sony");      // Then brand
        p5.setDiscount(15);       // Then discount
        p5.setName("Sony Camera"); // Then name
        p5.setCategory("Photography"); // Finally category
        
        p5.displayProduct();

        System.out.println("=== Benefits and Problems Summary ===");
        System.out.println("✅ BENEFITS:");
        System.out.println("   - Readable: Easy to understand what each value represents");
        System.out.println("   - Manageable: Easy to add new properties");
        System.out.println("   - Extendable: No breaking changes when adding properties");
        System.out.println("   - Flexible: Can set properties in any order");
        System.out.println("   - Optional Properties: Don't need to set all properties");
        System.out.println();
        System.out.println("❌ PROBLEMS:");
        System.out.println("   - Validation After Creation: Validation happens after object exists");
        System.out.println("   - Not Immutable: Object can be changed after creation");
        System.out.println("   - No Pre-Creation Validation: Cannot validate before object creation");
    }
}