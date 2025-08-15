// Product.java
package BuilderDesignPattern.BetterCode.BetterApproach2_UsingHashMapForParameters;

import java.util.ArrayList;
import java.util.HashMap;
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

    // Constructor takes HashMap instead of individual parameters
    Product(HashMap<String, Object> mp) {
        // BENEFIT: We can do validation BEFORE object creation!
        System.out.println("Starting product creation with validation...");
        
        // Validation before setting any values
        if (!validateProductData(mp)) {
            throw new IllegalArgumentException("Invalid product data provided!");
        }
        
        // Extract and set values from HashMap
        this.name = (String) mp.get("name");
        this.desc = (String) mp.get("desc");
        
        // Handle price with validation
        Object priceObj = mp.get("price");
        if (priceObj != null) {
            this.price = (Integer) priceObj;
        } else {
            this.price = 0; // default value
        }
        
        this.brand = (String) mp.get("brand");
        this.category = (String) mp.get("category");
        
        // Handle discount
        Object discountObj = mp.get("discount");
        if (discountObj != null) {
            this.discount = (Integer) discountObj;
        } else {
            this.discount = 0; // default value
        }
        
        this.createdAt = (String) mp.get("createdAt");
        this.updatedAt = (String) mp.get("updatedAt");
        
        // Handle images list
        Object imagesObj = mp.get("images");
        if (imagesObj != null) {
            this.images = (List<String>) imagesObj;
        } else {
            this.images = new ArrayList<>();
        }
        
        System.out.println("Product created successfully!");
    }
    
    // Validation method - validates BEFORE object creation
    private boolean validateProductData(HashMap<String, Object> data) {
        System.out.println("Validating product data...");
        
        // Check if required fields exist
        if (!data.containsKey("name") || data.get("name") == null) {
            System.out.println("Error: Product name is required!");
            return false;
        }
        
        if (!data.containsKey("price") || data.get("price") == null) {
            System.out.println("Error: Product price is required!");
            return false;
        }
        
        // Validate price value
        Object priceObj = data.get("price");
        if (priceObj instanceof Integer) {
            int price = (Integer) priceObj;
            if (price < 0) {
                System.out.println("Error: Price cannot be negative!");
                return false;
            }
            if (price == 0) {
                System.out.println("Warning: Price is zero - is this intentional?");
            }
        } else {
            System.out.println("Error: Price must be an integer!");
            return false;
        }
        
        // Validate name
        String name = (String) data.get("name");
        if (name.trim().isEmpty()) {
            System.out.println("Error: Product name cannot be empty!");
            return false;
        }
        
        // Validate discount if provided
        if (data.containsKey("discount") && data.get("discount") != null) {
            Object discountObj = data.get("discount");
            if (discountObj instanceof Integer) {
                int discount = (Integer) discountObj;
                if (discount < 0 || discount > 100) {
                    System.out.println("Error: Discount must be between 0 and 100!");
                    return false;
                }
            }
        }
        
        System.out.println("Validation passed!");
        return true;
    }

    // Getter methods
    public String getName() { return this.name; }
    public String getDesc() { return this.desc; }
    public int getPrice() { return this.price; }
    public String getBrand() { return this.brand; }
    public String getCategory() { return this.category; }
    public int getDiscount() { return this.discount; }
    public String getCreatedAt() { return this.createdAt; }
    public String getUpdatedAt() { return this.updatedAt; }
    public List<String> getImages() { return this.images; }

    // Display method for testing
    public void displayProduct() {
        System.out.println("=== Product Details ===");
        System.out.println("Name: " + (name != null ? name : "Not set"));
        System.out.println("Description: " + (desc != null ? desc : "Not set"));
        System.out.println("Price: $" + price);
        System.out.println("Brand: " + (brand != null ? brand : "Not set"));
        System.out.println("Category: " + (category != null ? category : "Not set"));
        System.out.println("Discount: " + discount + "%");
        System.out.println("Created At: " + (createdAt != null ? createdAt : "Not set"));
        System.out.println("Updated At: " + (updatedAt != null ? updatedAt : "Not set"));
        System.out.println("Images: " + (images != null ? images.size() + " image(s)" : "0 images"));
        System.out.println();
    }
}