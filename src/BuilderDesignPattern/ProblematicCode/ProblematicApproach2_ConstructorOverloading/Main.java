// Main.java
package BuilderDesignPattern.ProblematicCode.ProblematicApproach2_ConstructorOverloading;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Constructor Overloading Examples ===\n");

        // Using Constructor 2: Just name and price
        Product p1 = new Product("iPhone", 1000);
        System.out.println("Product 1:");
        System.out.println("Name: " + p1.getName());
        System.out.println("Price: " + p1.getPrice());
        System.out.println("Brand: " + p1.getBrand()); // Will be null
        System.out.println();

        // Using Constructor 3: Name, description, and price
        Product p2 = new Product("iPhone", "Latest smartphone from Apple", 1000);
        System.out.println("Product 2:");
        System.out.println("Name: " + p2.getName());
        System.out.println("Desc: " + p2.getDesc());
        System.out.println("Price: " + p2.getPrice());
        System.out.println("Brand: " + p2.getBrand()); // Still null
        System.out.println();

        // Using Constructor 5: Name, price, and brand (different order)
        Product p3 = new Product("iPhone", 1000, "Apple");
        System.out.println("Product 3:");
        System.out.println("Name: " + p3.getName());
        System.out.println("Price: " + p3.getPrice());
        System.out.println("Brand: " + p3.getBrand());
        System.out.println("Desc: " + p3.getDesc()); // Will be null
        System.out.println();

        // Using Constructor 6: Name, description, price, and brand
        Product p4 = new Product("iPhone", "Latest smartphone", 1000, "Apple");
        System.out.println("Product 4:");
        System.out.println("Name: " + p4.getName());
        System.out.println("Desc: " + p4.getDesc());
        System.out.println("Price: " + p4.getPrice());
        System.out.println("Brand: " + p4.getBrand());
        System.out.println();

        // Using Constructor 1: All parameters
        Product p5 = new Product(
            "iPhone", 
            "Latest smartphone from Apple", 
            1000, 
            "Apple", 
            "Electronics", 
            10, 
            "2023-01-01", 
            "2023-01-01", 
            new ArrayList<>()
        );
        System.out.println("Product 5:");
        System.out.println("Name: " + p5.getName());
        System.out.println("Brand: " + p5.getBrand());
        System.out.println("Category: " + p5.getCategory());
        System.out.println();

        // PROBLEM DEMONSTRATION:
        // What if we want to create a product with name, brand, and price?
        // We cannot use Product(String name, String brand, int price) 
        // because it conflicts with Product(String name, String desc, int price)
        
        // We have to use a workaround like:
        Product p6 = new Product("Samsung Galaxy", 800, "Samsung"); // name, price, brand
        System.out.println("Product 6 (workaround):");
        System.out.println("Name: " + p6.getName());
        System.out.println("Price: " + p6.getPrice());
        System.out.println("Brand: " + p6.getBrand());
        System.out.println();

        System.out.println("=== Problems with Constructor Overloading ===");
        System.out.println("1. Constructor Explosion: Too many constructors to maintain");
        System.out.println("2. Signature Conflicts: Cannot have two constructors with same parameter types");
        System.out.println("3. Confusion: Hard to remember which constructor takes which parameters");
        System.out.println("4. Maintenance Nightmare: Adding new property requires many new constructors");
    }
}