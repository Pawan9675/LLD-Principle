// Main.java - Demonstrates the Advanced Builder Pattern (Version 4)
package BuilderDesignPattern.BetterCode.Final_Solution_AdvancedBuilderPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Final Solution: Advanced Builder Pattern (Version 4) ===\n");
        
        // Example 1: Method Chaining - The Beautiful Syntax!
        System.out.println("--- Example 1: Method Chaining (The Beautiful Syntax!) ---");
        try {
            Product product1 = Product.getBuilder()
                                .setName("iPhone 15 Pro")
                                .setDesc("Latest flagship smartphone from Apple")
                                .setPrice(1200)
                                .setBrand("Apple")
                                .setCategory("Electronics")
                                .setDiscount(10)
                                .setCreatedAt("2023-12-01")
                                .setUpdatedAt("2023-12-01")
                                .addImage("iphone_front.jpg")
                                .addImage("iphone_back.jpg")
                                .addImage("iphone_side.jpg")
                                .build(); // This creates the final Product with validation!
            
            product1.displayProduct();
            
        } catch (Exception e) {
            System.out.println("❌ Failed to create product: " + e.getMessage());
        }

        // Example 2: Step by step building (same Builder, different style)
        System.out.println("--- Example 2: Step by Step Building ---");
        try {
            // Get Builder instance
            Product.Builder builder = Product.getBuilder();
            
            // Configure step by step (properties can be set in ANY order)
            builder.setPrice(900);                    // Set price first
            builder.setBrand("Samsung");              // Then brand  
            builder.setName("Samsung Galaxy S24");    // Then name
            builder.setCategory("Smartphone");        // Then category
            builder.setDiscount(15);                  // Then discount
            
            // Optional: Show current state before building
            builder.showCurrentState();
            
            // Create the final Product
            Product product2 = builder.build();
            product2.displayProduct();
            
        } catch (Exception e) {
            System.out.println("❌ Failed to create product: " + e.getMessage());
        }

        // Example 3: Minimal configuration (only required fields)
        System.out.println("--- Example 3: Minimal Configuration ---");
        try {
            Product product3 = Product.getBuilder()
                                .setName("MacBook Air")
                                .setBrand("Apple") 
                                .setPrice(999)
                                .build(); // Only required fields, others remain default
            
            product3.displayProduct();
            
        } catch (Exception e) {
            System.out.println("❌ Failed to create product: " + e.getMessage());
        }

        // Example 4: Validation in action (this will fail)
        System.out.println("--- Example 4: Validation in Action (Intentional Failure) ---");
        try {
            Product product4 = Product.getBuilder()
                                .setName("Invalid Product")
                                .setBrand("Test Brand")
                                .setPrice(-100)  // Invalid price!
                                .build();
            
            product4.displayProduct();
            
        } catch (Exception e) {
            System.out.println("❌ Expected validation error: " + e.getMessage());
        }

        // Example 5: Advanced image handling
        System.out.println("--- Example 5: Advanced Image Handling ---");
        try {
            Product product5 = Product.getBuilder()
                                .setName("Sony Camera")
                                .setBrand("Sony")
                                .setPrice(1500)
                                .setCategory("Photography")
                                .addImage("camera_front.jpg")
                                .addImage("camera_back.jpg")
                                .showCurrentState()  // Show state in the middle of chaining!
                                .addImage("camera_lens.jpg")
                                .clearImages()       // Clear all images
                                .addImage("final_image.jpg")  // Add new image
                                .build();
            
            product5.displayProduct();
            
        } catch (Exception e) {
            System.out.println("❌ Failed to create product: " + e.getMessage());
        }

        System.out.println("=== Why Version 4 is Perfect ===");
        System.out.println("✅ Single entry point: Product.getBuilder()");
        System.out.println("✅ Method chaining: .setName().setPrice().build()");
        System.out.println("✅ Cannot pass null - no public constructors");
        System.out.println("✅ Builder and Product in same file - easy maintenance");
        System.out.println("✅ Validation before object creation");
        System.out.println("✅ Immutable Product objects after creation");
        System.out.println("✅ Type-safe with full IDE support");
        System.out.println("✅ Flexible - properties in any order");
        System.out.println("✅ Clean, readable, professional code");
    }
}