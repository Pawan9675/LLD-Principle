// MethodChainingExplanation.java - Detailed explanation of how method chaining works
package BuilderDesignPattern.BetterCode.Final_Solution_AdvancedBuilderPattern;

public class MethodChainingExplanation {
    
    public static void main(String[] args) {
        System.out.println("=== Understanding Method Chaining in Builder Pattern ===\n");
        
        // Step-by-step explanation of what happens during method chaining
        System.out.println("STEP-BY-STEP BREAKDOWN:");
        System.out.println("When we write this beautiful code:");
        System.out.println("Product p = Product.getBuilder().setName(\"iPhone\").setPrice(1000).build();");
        System.out.println();
        
        System.out.println("Here's what happens internally:");
        System.out.println("==============================");
        
        // Step 1
        System.out.println("STEP 1: Product.getBuilder()");
        System.out.println("- Calls static method getBuilder() in Product class");
        System.out.println("- Creates new Builder instance (let's call it 'builder1')");
        System.out.println("- Returns builder1 to us");
        Product.Builder step1 = Product.getBuilder();
        System.out.println("- Result: We now have a Builder object\n");
        
        // Step 2
        System.out.println("STEP 2: .setName(\"iPhone\")");
        System.out.println("- Calls setName(\"iPhone\") on builder1");
        System.out.println("- Sets builder1.name = \"iPhone\"");
        System.out.println("- Returns builder1 (the same object!)");
        Product.Builder step2 = step1.setName("iPhone");
        System.out.println("- Result: builder1 now has name set, and we still have builder1\n");
        
        // Step 3
        System.out.println("STEP 3: .setPrice(1000)");
        System.out.println("- Calls setPrice(1000) on builder1 (same object from step 2)");
        System.out.println("- Sets builder1.price = 1000");
        System.out.println("- Returns builder1 (still the same object!)");
        Product.Builder step3 = step2.setPrice(1000);
        System.out.println("- Result: builder1 now has name AND price set\n");
        
        // Step 4
        System.out.println("STEP 4: .build()");
        System.out.println("- Calls build() on builder1 (same object with all our data)");
        System.out.println("- build() calls new Product(this) where 'this' is builder1");
        System.out.println("- Product constructor validates builder1 data");
        System.out.println("- If valid: creates new Product object with builder1's data");
        System.out.println("- Returns the new Product object");
        
        try {
            Product step4 = step3.setBrand("Apple").build(); // Added brand for validation
            System.out.println("- Result: We have a validated Product object!\n");
            step4.displayProduct();
        } catch (Exception e) {
            System.out.println("- Error: " + e.getMessage() + "\n");
        }
        
        // The magic of 'return this'
        System.out.println("THE MAGIC OF 'return this':");
        System.out.println("==========================");
        System.out.println("Each setter method ends with 'return this;'");
        System.out.println("'this' refers to the current Builder object");
        System.out.println("By returning the same object, we can call another method on it");
        System.out.println();
        System.out.println("Without 'return this' (wouldn't work):");
        System.out.println("builder.setName(\"iPhone\");  // Returns void");
        System.out.println("// Can't call .setPrice() because setName() returned nothing!");
        System.out.println();
        System.out.println("With 'return this' (works perfectly):");
        System.out.println("builder.setName(\"iPhone\")   // Returns the same Builder");
        System.out.println("       .setPrice(1000);      // Can call setPrice() on the returned Builder");
        System.out.println();
        
        // Demonstrating that it's all the same object
        System.out.println("PROOF IT'S THE SAME OBJECT:");
        System.out.println("===========================");
        Product.Builder originalBuilder = Product.getBuilder();
        Product.Builder afterSetName = originalBuilder.setName("Test Product");
        Product.Builder afterSetPrice = afterSetName.setPrice(100);
        Product.Builder afterSetBrand = afterSetPrice.setBrand("Test Brand");
        
        System.out.println("originalBuilder == afterSetName? " + (originalBuilder == afterSetName));
        System.out.println("afterSetName == afterSetPrice? " + (afterSetName == afterSetPrice));
        System.out.println("afterSetPrice == afterSetBrand? " + (afterSetPrice == afterSetBrand));
        System.out.println("All are the SAME object - just with more data set each time!\n");
        
        // Create final product to show it works
        try {
            Product finalProduct = afterSetBrand.build();
            System.out.println("Final product created successfully:");
            finalProduct.displayProduct();
        } catch (Exception e) {
            System.out.println("Error creating final product: " + e.getMessage());
        }
    }
}