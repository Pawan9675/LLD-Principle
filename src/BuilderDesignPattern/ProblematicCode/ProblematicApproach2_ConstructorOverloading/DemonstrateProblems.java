// DemonstrateProblems.java - Shows the specific problems
package BuilderDesignPattern.ProblematicCode.ProblematicApproach2_ConstructorOverloading;

public class DemonstrateProblems {
    
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Constructor Overloading Problems ===\n");
        
        // Problem 1: Constructor Explosion
        System.out.println("PROBLEM 1: Constructor Explosion");
        System.out.println("With just 4 properties, we could need 2^4 = 16 constructors!");
        System.out.println("With 8 properties, we could need 2^8 = 256 constructors!");
        System.out.println("This becomes completely unmanageable.\n");
        
        // Problem 2: Signature Conflicts
        System.out.println("PROBLEM 2: Signature Conflicts");
        System.out.println("These two constructors CANNOT coexist:");
        System.out.println("Product(String name, String desc, int price)");
        System.out.println("Product(String name, String brand, int price)");
        System.out.println("Both have signature: (String, String, int)");
        System.out.println("Compiler cannot tell them apart!\n");
        
        // Problem 3: Parameter Order Confusion
        System.out.println("PROBLEM 3: Parameter Order Confusion");
        System.out.println("Look at these similar constructors:");
        System.out.println("Product(String name, int price, String brand)");
        System.out.println("Product(String name, String desc, int price)");
        System.out.println("Easy to mix up the order and pass wrong values!\n");
        
        // Problem 4: Not Extendable
        System.out.println("PROBLEM 4: Not Extendable");
        System.out.println("If we add a new property like 'warranty':");
        System.out.println("- Need to create many more constructors");
        System.out.println("- Existing code might break");
        System.out.println("- Maintenance becomes nightmare\n");
        
        // The ONLY benefit
        System.out.println("THE ONLY BENEFIT:");
        System.out.println("- Solves the 'forced default values' problem");
        System.out.println("- Can choose which properties to set");
        System.out.println("But creates 2 bigger problems in return!");
    }
}