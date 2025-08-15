// AdvancedProblems.java - Shows more complex issues with HashMap approach
package BuilderDesignPattern.BetterCode.BetterApproach2_UsingHashMapForParameters;

import java.util.HashMap;
import java.util.ArrayList;

public class AdvancedProblems {
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Problems with HashMap Approach ===\n");
        
        // Problem: Complex validation scenarios
        System.out.println("PROBLEM: Complex Validation Scenarios");
        System.out.println("------------------------------------");
        
        // What if validation depends on multiple properties?
        try {
            HashMap<String, Object> complexData = new HashMap<>();
            complexData.put("name", "Premium Product");
            complexData.put("price", 50);        // Low price
            complexData.put("category", "premium"); // But premium category
            complexData.put("brand", "Luxury Brand");
            
            System.out.println("Creating product with price-category mismatch...");
            // Current validation cannot easily check if premium products should have high prices
            Product p1 = new Product(complexData);
            p1.displayProduct();
            System.out.println("Problem: Hard to validate relationships between properties!");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        // Problem: Error messages are not user-friendly
        System.out.println("PROBLEM: Poor Error Messages");
        System.out.println("---------------------------");
        try {
            HashMap<String, Object> badData = new HashMap<>();
            badData.put("name", "");  // Empty name
            badData.put("price", -100); // Negative price
            
            Product p2 = new Product(badData);
            
        } catch (Exception e) {
            System.out.println("Generic error: " + e.getMessage());
            System.out.println("Problem: User doesn't know exactly what went wrong!");
            System.out.println("Was it the empty name? Negative price? Both?");
        }
        System.out.println();
        
        // Problem: Thread safety concerns
        System.out.println("PROBLEM: Thread Safety Concerns");
        System.out.println("------------------------------");
        
        HashMap<String, Object> sharedData = new HashMap<>();
        sharedData.put("name", "Shared Product");
        sharedData.put("price", 1000);
        
        System.out.println("What if multiple threads modify the same HashMap?");
        System.out.println("Thread 1: sharedData.put('price', 1500);");
        System.out.println("Thread 2: sharedData.put('price', 800);");
        System.out.println("Thread 3: new Product(sharedData);");
        System.out.println("Problem: Race conditions can create inconsistent objects!");
        System.out.println();
        
        // Problem: No compile-time safety
        System.out.println("PROBLEM: No Compile-Time Safety");
        System.out.println("------------------------------");
        System.out.println("These errors are only discovered at RUNTIME:");
        System.out.println();
        
        // Simulate what could go wrong
        String[] commonMistakes = {
            "map.put('Name', value);     // Capital 'N'",
            "map.put('price ', value);   // Extra space", 
            "map.put('pric', value);     // Typo",
            "map.put('discount', '10');  // String instead of int",
            "map.put('price', null);     // Null value"
        };
        
        System.out.println("Common mistakes that compile but fail at runtime:");
        for (String mistake : commonMistakes) {
            System.out.println("❌ " + mistake);
        }
        
        System.out.println();
        System.out.println("CONCLUSION:");
        System.out.println("HashMap approach solves the bloated constructor problem");
        System.out.println("and enables pre-creation validation, BUT:");
        System.out.println("❌ Prone to spelling mistakes");
        System.out.println("❌ No type safety");
        System.out.println("❌ No IDE support");
        System.out.println("❌ Hard to maintain");
        System.out.println("❌ Runtime errors instead of compile-time errors");
        System.out.println();
        System.out.println("We need a better approach that combines benefits without these issues!");
    }
}