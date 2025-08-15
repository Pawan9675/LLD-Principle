// Main.java
package BuilderDesignPattern.BetterCode.BetterApproach2_UsingHashMapForParameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Better Approach #2: Using HashMap for Parameters ===\n");

        // Example 1: Successful product creation
        System.out.println("--- Example 1: Successful Product Creation ---");
        try {
            HashMap<String, Object> productData1 = new HashMap<>();
            productData1.put("name", "iPhone 15");
            productData1.put("desc", "Latest smartphone from Apple");
            productData1.put("price", 1000);
            productData1.put("brand", "Apple");
            productData1.put("category", "Electronics");
            productData1.put("discount", 10);
            productData1.put("createdAt", "2023-12-01");
            productData1.put("updatedAt", "2023-12-01");
            
            List<String> images = new ArrayList<>();
            images.add("image1.jpg");
            images.add("image2.jpg");
            productData1.put("images", images);
            
            Product p1 = new Product(productData1);
            p1.displayProduct();
            
        } catch (Exception e) {
            System.out.println("Failed to create product: " + e.getMessage());
        }

        // Example 2: Product with minimal data
        System.out.println("--- Example 2: Product with Minimal Data ---");
        try {
            HashMap<String, Object> productData2 = new HashMap<>();
            productData2.put("name", "Samsung Galaxy");
            productData2.put("price", 800);
            productData2.put("brand", "Samsung");
            
            Product p2 = new Product(productData2);
            p2.displayProduct();
            
        } catch (Exception e) {
            System.out.println("Failed to create product: " + e.getMessage());
        }

        // Example 3: Flexible property addition
        System.out.println("--- Example 3: Flexible Property Addition ---");
        try {
            HashMap<String, Object> productData3 = new HashMap<>();
            // Properties can be added in any order
            productData3.put("price", 1500);
            productData3.put("name", "MacBook Pro");
            productData3.put("category", "Laptop");
            productData3.put("brand", "Apple");
            productData3.put("desc", "Powerful laptop for professionals");
            
            Product p3 = new Product(productData3);
            p3.displayProduct();
            
        } catch (Exception e) {
            System.out.println("Failed to create product: " + e.getMessage());
        }

        System.out.println("=== Benefits of HashMap Approach ===");
        System.out.println("✅ No bloated constructor - only one parameter");
        System.out.println("✅ Validation BEFORE object creation");
        System.out.println("✅ Flexible - can add properties in any order");
        System.out.println("✅ No missing properties issue (HashMap always exists)");
    }
}