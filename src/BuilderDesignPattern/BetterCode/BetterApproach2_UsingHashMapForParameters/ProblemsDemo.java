// ProblemsDemo.java - Demonstrates the specific problems with HashMap approach
package BuilderDesignPattern.BetterCode.BetterApproach2_UsingHashMapForParameters;

import java.util.HashMap;
import java.util.List;

public class ProblemsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Problems with HashMap Approach ===\n");
        
        // Problem 1: Missing Properties
        System.out.println("PROBLEM 1: Missing Properties");
        System.out.println("-----------------------------");
        try {
            HashMap<String, Object> incompleteData = new HashMap<>();
            incompleteData.put("name", "Incomplete Product");
            // Missing "price" - required property!
            
            System.out.println("Attempting to create product without price...");
            Product p1 = new Product(incompleteData);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Problem: Easy to forget required properties!");
        }
        System.out.println();

        // Problem 2: Spelling Mistakes in Keys
        System.out.println("PROBLEM 2: Spelling Mistakes in Keys");
        System.out.println("-----------------------------------");
        try {
            HashMap<String, Object> typoData = new HashMap<>();
            typoData.put("nam", "Typo Product");        // Should be "name"
            typoData.put("Price", 1000);               // Should be "price"
            typoData.put("brand", "Some Brand");
            
            System.out.println("Attempting to create product with typos in keys...");
            Product p2 = new Product(typoData);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Problem: Typos in HashMap keys cause failures!");
            System.out.println("'nam' instead of 'name', 'Price' instead of 'price'");
        }
        System.out.println();

        // Problem 3: Wrong Data Types
        System.out.println("PROBLEM 3: Wrong Data Types");
        System.out.println("---------------------------");
        try {
            HashMap<String, Object> wrongTypeData = new HashMap<>();
            wrongTypeData.put("name", "Wrong Type Product");
            wrongTypeData.put("price", "1000");  // String instead of Integer!
            wrongTypeData.put("brand", "Some Brand");
            
            System.out.println("Attempting to create product with wrong data type...");
            Product p3 = new Product(wrongTypeData);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Problem: HashMap doesn't enforce data types!");
            System.out.println("Easy to pass String '1000' instead of Integer 1000");
        }
        System.out.println();

        // Problem 4: Runtime Casting Issues
        System.out.println("PROBLEM 4: Runtime Casting Issues");
        System.out.println("---------------------------------");
        try {
            HashMap<String, Object> castingData = new HashMap<>();
            castingData.put("name", "Casting Problem Product");
            castingData.put("price", 1000.50); // Double instead of Integer!
            castingData.put("brand", "Some Brand");
            
            System.out.println("Attempting to create product with Double price...");
            Product p4 = new Product(castingData);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Problem: ClassCastException at runtime!");
            System.out.println("Trying to cast Double to Integer fails");
        }
        System.out.println();

        // Problem 5: No IDE Support
        System.out.println("PROBLEM 5: No IDE Support");
        System.out.println("-------------------------");
        System.out.println("Issues that cannot be demonstrated but exist:");
        System.out.println("❌ No auto-completion for HashMap keys");
        System.out.println("❌ No compile-time error checking");
        System.out.println("❌ No refactoring support (if you rename a property)");
        System.out.println("❌ No documentation/hints for valid keys");
        System.out.println();

        // Problem 6: Maintenance Nightmare
        System.out.println("PROBLEM 6: Maintenance Nightmare");
        System.out.println("--------------------------------");
        System.out.println("What happens when you add a new property?");
        System.out.println("1. Add it to the Product class");
        System.out.println("2. Update validation method");
        System.out.println("3. Find ALL places where HashMap is created");
        System.out.println("4. Update each HashMap manually");
        System.out.println("5. Hope you didn't miss any or make typos!");
        System.out.println();

        // Successful creation for comparison
        System.out.println("--- For Comparison: Successful Creation ---");
        try {
            HashMap<String, Object> goodData = new HashMap<>();
            goodData.put("name", "Good Product");
            goodData.put("price", 1000);
            goodData.put("brand", "Good Brand");
            
            Product goodProduct = new Product(goodData);
            goodProduct.displayProduct();
            
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}