// Product.java
package BuilderDesignPattern.ProblematicCode.ProblematicApproach2_ConstructorOverloading;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String desc;
    private int price;
    private String brand;
    private String category;
    private int discount;
    private String createdAt;
    private String updatedAt;
    private List<String> images;

    // Constructor 1: All parameters
    Product(String name, String desc, int price, String brand, String category, 
            int discount, String createdAt, String updatedAt, ArrayList<String> images) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.discount = discount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.images = images;
    }

    // Constructor 2: Just name and price (minimal required info)
    Product(String name, int price) {
        this.name = name;
        this.price = price;
        // Other fields will have default values (null for objects, 0 for primitives)
    }

    // Constructor 3: Name, description, and price
    Product(String name, String desc, int price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    // Constructor 4: Name, brand, and price - THIS WILL NOT COMPILE!
    // This constructor has the same signature as Constructor 3: (String, String, int)
    // The compiler cannot differentiate between them
    /*
    Product(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    */

    // Constructor 5: Name, price, and brand (different order)
    Product(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    // Constructor 6: Name, description, price, and brand
    Product(String name, String desc, int price, String brand) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.brand = brand;
    }

    // Constructor 7: Name, description, price, brand, and category
    Product(String name, String desc, int price, String brand, String category) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }

    // We could keep adding more constructors, but this becomes unmanageable!
    // With just 5 main properties (name, desc, price, brand, category), 
    // we could theoretically need 2^5 = 32 different constructors!

    // Getters for testing purposes
    public String getName() { return name; }
    public String getDesc() { return desc; }
    public int getPrice() { return price; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }
}