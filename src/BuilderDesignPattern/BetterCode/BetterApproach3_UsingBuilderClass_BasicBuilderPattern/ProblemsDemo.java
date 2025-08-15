// ProblemsDemo.java - Shows remaining problems with Basic Builder Pattern
package BuilderDesignPattern.BetterCode.BetterApproach3_UsingBuilderClass_BasicBuilderPattern;

public class ProblemsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Remaining Problems with Basic Builder Pattern ===\n");
        
        // Problem 1: Two separate classes
        System.out.println("PROBLEM 1: Two Separate Classes");
        System.out.println("-------------------------------");
        System.out.println("We now have TWO classes: Product.java and Builder.java");
        System.out.println("Problems:");
        System.out.println("- Both classes need to be maintained together");
        System.out.println("- If Product gets new property, Builder must be updated too");
        System.out.println("- They are tightly coupled but live in separate files");
        System.out.println("- Harder to keep them synchronized\n");
        
        // Problem 2: User can pass null Builder
        System.out.println("PROBLEM 2: User Can Pass Null Builder");
        System.out.println("------------------------------------");
        try {
            System.out.println("What if someone does this?");
            System.out.println("Product p = new Product(null);");
            
            // This will cause NullPointerException
            Product nullProduct = new Product(null);
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            System.out.println("Problem: User can pass null instead of Builder object!");
            System.out.println("This defeats the purpose of validation\n");
        }
        
        // Problem 3: User must know about Builder
        System.out.println("PROBLEM 3: User Must Know About Builder");
        System.out.println("--------------------------------------");
        System.out.println("Current usage requires knowing TWO classes:");
        System.out.println("1. Builder - to configure the product");
        System.out.println("2. Product - the actual object we want");
        System.out.println();
        System.out.println("User workflow:");
        System.out.println("Step 1: Import Builder class");
        System.out.println("Step 2: Create new Builder()");
        System.out.println("Step 3: Configure Builder with setters");
        System.out.println("Step 4: Create Product(builder)");
        System.out.println();
        System.out.println("Problem: Why should user care about Builder?");
        System.out.println("They just want to create a Product!\n");
        
        // Problem 4: Extra steps for users
        System.out.println("PROBLEM 4: Extra Steps for Users");
        System.out.println("-------------------------------");
        System.out.println("Compare to simple approaches:");
        System.out.println();
        System.out.println("Setter approach (simple but problematic):");
        System.out.println("Product p = new Product();");
        System.out.println("p.setName('iPhone');");
        System.out.println();
        System.out.println("Builder approach (better but more complex):");
        System.out.println("Builder b = new Builder();");
        System.out.println("b.setName('iPhone');");
        System.out.println("Product p = new Product(b);");
        System.out.println();
        System.out.println("Problem: More code for users to write and remember\n");
        
        // Problem 5: Constructor is still public
        System.out.println("PROBLEM 5: Constructor is Still Public");
        System.out.println("-------------------------------------");
        System.out.println("Current Product constructor is public");
        System.out.println("This means users can still do wrong things:");
        System.out.println("- Pass null: new Product(null)");
        System.out.println("- Pass wrong objects if they extend Builder");
        System.out.println("- Create Products in unintended ways");
        System.out.println("Problem: No control over how Product is created\n");
        
        // Show what we want to achieve
        System.out.println("WHAT WE WANT TO ACHIEVE:");
        System.out.println("=======================");
        System.out.println("Ideal usage (what we want):");
        System.out.println("Product p = Product.builder()");
        System.out.println("                   .setName('iPhone')");
        System.out.println("                   .setPrice(1000)");
        System.out.println("                   .setBrand('Apple')");
        System.out.println("                   .build();");
        System.out.println();
        System.out.println("Benefits of ideal approach:");
        System.out.println("✅ Only one class to import (Product)");
        System.out.println("✅ Fluent, chain-like syntax");
        System.out.println("✅ Cannot pass null or wrong objects");
        System.out.println("✅ Builder and Product are tightly integrated");
        System.out.println("✅ Less code for users to write");
        System.out.println();
        System.out.println("This leads us to the FINAL Builder Pattern solution!");
    }
}