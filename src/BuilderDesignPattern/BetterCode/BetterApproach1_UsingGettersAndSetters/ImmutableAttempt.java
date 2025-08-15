// ImmutableAttempt.java - Shows why this approach doesn't work for immutable objects
package BuilderDesignPattern.BetterCode.BetterApproach1_UsingGettersAndSetters;

public class ImmutableAttempt {
    
    public static void main(String[] args) {
        System.out.println("=== Why Getter/Setter Approach Fails for Immutable Objects ===\n");
        
        System.out.println("IMMUTABLE OBJECTS: Objects that cannot be changed after creation");
        System.out.println("Examples: String, Integer, LocalDate in Java");
        System.out.println("Benefits: Thread-safe, predictable, no side effects");
        System.out.println();
        
        System.out.println("PROBLEM: Setters violate immutability principle");
        System.out.println("If Product should be immutable:");
        System.out.println("- Cannot have setters (they modify object state)");
        System.out.println("- Must set all values during construction");
        System.out.println("- But constructor with many parameters is problematic!");
        System.out.println();
        
        System.out.println("EXAMPLE: Trying to make Product immutable");
        System.out.println("----------------------------------------");
        
        // This is what we want to achieve but cannot with setters:
        System.out.println("Desired usage:");
        System.out.println("Product p = createImmutableProduct()");
        System.out.println("    .withName(\"iPhone\")");
        System.out.println("    .withPrice(1000)");
        System.out.println("    .withBrand(\"Apple\")");
        System.out.println("    .build(); // Creates immutable object");
        System.out.println();
        System.out.println("p.setPrice(2000); // Should NOT be allowed!");
        System.out.println();
        
        System.out.println("CONCLUSION:");
        System.out.println("Getter/Setter approach is incompatible with immutable objects");
        System.out.println("We need a different approach for immutable object creation");
    }
}