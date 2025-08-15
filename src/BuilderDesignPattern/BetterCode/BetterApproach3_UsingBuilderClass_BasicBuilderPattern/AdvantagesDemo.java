// AdvantagesDemo.java - Shows advantages over previous approaches
package BuilderDesignPattern.BetterCode.BetterApproach3_UsingBuilderClass_BasicBuilderPattern;

public class AdvantagesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Advantages of Builder Pattern over Previous Approaches ===\n");
        
        // Advantage 1: Type Safety
        System.out.println("ADVANTAGE 1: Type Safety");
        System.out.println("------------------------");
        System.out.println("HashMap approach: map.put(\"price\", \"1000\"); // String - WRONG!");
        System.out.println("Builder approach:  builder.setPrice(1000);   // Integer - CORRECT!");
        System.out.println("Benefit: Compiler catches type errors immediately\n");
        
        // Advantage 2: IDE Support
        System.out.println("ADVANTAGE 2: IDE Support");
        System.out.println("-----------------------");
        System.out.println("HashMap: No auto-completion for keys, easy to make typos");
        System.out.println("Builder: Full IDE support - auto-completion, parameter hints");
        System.out.println("Example: When you type 'builder.', IDE shows all available methods\n");
        
        // Advantage 3: Compile-time vs Runtime errors
        System.out.println("ADVANTAGE 3: Compile-time vs Runtime Errors");
        System.out.println("------------------------------------------");
        System.out.println("HashMap: builder.setPrice(\"wrong\"); // Compiles but fails at runtime");
        System.out.println("Builder: builder.setPrice(\"wrong\");  // Won't even compile!");
        System.out.println("Benefit: Catch errors during development, not in production\n");
        
        // Advantage 4: No spelling mistakes
        System.out.println("ADVANTAGE 4: No Spelling Mistakes");
        System.out.println("---------------------------------");
        try {
            Builder correctBuilder = new Builder();
            
            // These will cause compile errors if methods don't exist:
            correctBuilder.setName("Product");      // ✅ Correct
            // correctBuilder.setNam("Product");     // ❌ Won't compile
            // correctBuilder.setPric(100);          // ❌ Won't compile
            correctBuilder.setPrice(100);           // ✅ Correct
            
            System.out.println("All method names are enforced by compiler!");
            System.out.println("No more typos like 'setNam' or 'setPric'\n");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Advantage 5: Clear validation
        System.out.println("ADVANTAGE 5: Clear Validation");
        System.out.println("----------------------------");
        try {
            Builder validBuilder = new Builder();
            validBuilder.setName("Valid Product");
            validBuilder.setBrand("Valid Brand");
            validBuilder.setPrice(100);
            
            // Validation happens here, BEFORE Product exists
            Product validProduct = new Product(validBuilder);
            System.out.println("✅ Product created successfully with validation!");
            
        } catch (Exception e) {
            System.out.println("❌ Validation failed: " + e.getMessage());
        }
        System.out.println();
        
        // Demonstration of flexibility
        System.out.println("ADVANTAGE 6: Flexible Configuration");
        System.out.println("----------------------------------");
        
        Builder flexibleBuilder = new Builder();
        System.out.println("Setting properties in random order:");
        System.out.println("1. Setting price first...");
        flexibleBuilder.setPrice(500);
        
        System.out.println("2. Then brand...");
        flexibleBuilder.setBrand("Flexible Brand");
        
        System.out.println("3. Then name...");
        flexibleBuilder.setName("Flexible Product");
        
        System.out.println("4. Order doesn't matter - all information is preserved!");
        
        try {
            Product flexibleProduct = new Product(flexibleBuilder);
            System.out.println("✅ Product created successfully regardless of order!\n");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}