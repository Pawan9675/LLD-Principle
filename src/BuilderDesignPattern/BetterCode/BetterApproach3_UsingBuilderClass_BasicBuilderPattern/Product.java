// Product.java - Modified to use Builder
package BuilderDesignPattern.BetterCode.BetterApproach3_UsingBuilderClass_BasicBuilderPattern;

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

    // Constructor takes Builder object - this enables validation BEFORE object creation
    Product(Builder b) {
        System.out.println("Creating Product using Builder...");
        
        // BENEFIT: All validation happens BEFORE object creation
        if (!validateBuilder(b)) {
            throw new IllegalArgumentException("Invalid product data in builder!");
        }
        
        // Extract values from builder and set them
        this.name = b.getName();
        this.desc = b.getDesc();
        this.price = b.getPrice();
        this.brand = b.getBrand();
        this.category = b.getCategory();
        this.discount = b.getDiscount();
        this.createdAt = b.getCreatedAt();
        this.updatedAt = b.getUpdatedAt();
        this.images = b.getImages();
        
        System.out.println("Product created successfully!");
    }
    
    // Validation method - validates Builder before Product creation
    private boolean validateBuilder(Builder builder) {
        System.out.println("Validating builder data...");
        
        // Check required fields
        if (builder.getName() == null || builder.getName().trim().isEmpty()) {
            System.out.println("Error: Product name is required!");
            return false;
        }
        
        if (builder.getPrice() <= 0) {
            System.out.println("Error: Product price must be greater than 0!");
            return false;
        }
        
        if (builder.getBrand() == null || builder.getBrand().trim().isEmpty()) {
            System.out.println("Error: Product brand is required!");
            return false;
        }
        
        // Business rule validations
        if (builder.getDiscount() > 50 && builder.getPrice() < 100) {
            System.out.println("Error: High discount not allowed on low-priced items!");
            return false;
        }
        
        System.out.println("Builder validation passed!");
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

    // Display method
    public void displayProduct() {
        System.out.println("=== Final Product Details ===");
        System.out.println("Name: " + name);
        System.out.println("Description: " + (desc != null ? desc : "Not provided"));
        System.out.println("Price: $" + price);
        System.out.println("Brand: " + brand);
        System.out.println("Category: " + (category != null ? category : "Not provided"));
        System.out.println("Discount: " + discount + "%");
        System.out.println("Created At: " + (createdAt != null ? createdAt : "Not provided"));
        System.out.println("Updated At: " + (updatedAt != null ? updatedAt : "Not provided"));
        System.out.println("Images: " + (images != null ? images.size() + " image(s)" : "0 images"));
        System.out.println();
    }
}