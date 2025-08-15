// Main.java
package BuilderDesignPattern.ProblematicCode.ProblematicApproach1_ConstructorWithManyParameters;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creating a Product object - Notice how messy and confusing this is!
        Product p = new Product(
            "Iphone",                    // name
            "This is an Iphone",         // description  
            1000,                        // price
            "Apple",                     // brand
            "Mobile",                    // category
            10,                          // discount
            "2022-09-09",               // createdAt
            "2022-09-09",               // updatedAt
            new ArrayList<>()            // images (empty list)
        );
        
        System.out.println("Product created successfully!");
        
        // What if we want to create another product?
        // We have to remember the exact order again!
        Product p2 = new Product(
            "MacBook Pro",               // name
            "Laptop from Apple",         // description
            2000,                        // price
            "Apple",                     // brand
            "Laptop",                    // category
            5,                           // discount
            "2022-10-01",               // createdAt
            "2022-10-01",               // updatedAt
            new ArrayList<>()            // images
        );
        
        System.out.println("Second product created successfully!");
    }
}