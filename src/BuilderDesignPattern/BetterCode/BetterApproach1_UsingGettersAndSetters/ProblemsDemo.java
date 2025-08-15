// ProblemsDemo.java - Demonstrates the specific problems with this approach
package BuilderDesignPattern.BetterCode.BetterApproach1_UsingGettersAndSetters;

public class ProblemsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Demonstrating Problems with Getter/Setter Approach ===\n");
        
        // Problem 1: Validation happens AFTER object creation
        System.out.println("PROBLEM 1: Validation After Object Creation");
        System.out.println("------------------------------------------");
        
        Product product = new Product(); // Object already created!
        System.out.println("Product object created (even before setting any values)");
        
        // Now validation happens when we call setters
        product.setPrice(-100); // This will show warning but object already exists
        product.setName("");    // This will show warning but object already exists
        
        System.out.println("Issue: Object exists in memory even with invalid data!");
        System.out.println("In real applications, this could mean:");
        System.out.println("- Invalid data gets saved to database");
        System.out.println("- Other parts of code might access invalid object");
        System.out.println();
        
        // Problem 2: Cannot prevent object creation with invalid data
        System.out.println("PROBLEM 2: Cannot Prevent Invalid Object Creation");
        System.out.println("-----------------------------------------------");
        
        Product invalidProduct = new Product(); // Object is created regardless!
        // Even if we never call setters, object exists
        
        System.out.println("Invalid product exists: " + (invalidProduct != null));
        System.out.println("Name: " + invalidProduct.getName()); // null
        System.out.println("Price: " + invalidProduct.getPrice()); // 0 (default)
        System.out.println("This invalid product could be used elsewhere in code!");
        System.out.println();
        
        // Problem 3: Object is mutable (can be changed after creation)
        System.out.println("PROBLEM 3: Object is Mutable");
        System.out.println("----------------------------");
        
        Product mutableProduct = new Product();
        mutableProduct.setName("Original Name");
        mutableProduct.setPrice(1000);
        
        System.out.println("Original: " + mutableProduct.getName() + ", $" + mutableProduct.getPrice());
        
        // Someone else can change it later!
        mutableProduct.setName("Changed Name");
        mutableProduct.setPrice(2000);
        
        System.out.println("Changed:  " + mutableProduct.getName() + ", $" + mutableProduct.getPrice());
        System.out.println("Problem: Object can be modified after creation");
        System.out.println("This makes it hard to guarantee object consistency");
        System.out.println();
        
        // Problem 4: No guarantee all required fields are set
        System.out.println("PROBLEM 4: No Required Field Validation");
        System.out.println("--------------------------------------");
        
        Product incompleteProduct = new Product();
        incompleteProduct.setName("Incomplete Product");
        // Forgot to set price! But object is still valid
        
        System.out.println("Product created without price: " + incompleteProduct.getName());
        System.out.println("Price: " + incompleteProduct.getPrice()); // 0 - is this valid?
        System.out.println("Problem: No way to ensure all required fields are set");
        System.out.println();
        
        // Real-world scenario
        System.out.println("REAL-WORLD IMPACT:");
        System.out.println("=================");
        System.out.println("Imagine this product gets saved to database:");
        System.out.println("- Name: " + (incompleteProduct.getName() != null ? incompleteProduct.getName() : "NULL"));
        System.out.println("- Price: " + incompleteProduct.getPrice() + " (Is free product intended?)");
        System.out.println("- Brand: " + (incompleteProduct.getBrand() != null ? incompleteProduct.getBrand() : "NULL"));
        System.out.println("Database now has incomplete/invalid data!");
    }
}