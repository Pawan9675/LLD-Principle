// Product.java
package BuilderDesignPattern.BetterCode.BetterApproach1_UsingGettersAndSetters;

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

    // Default empty constructor
    Product() {
        // Initialize with default values if needed
        this.images = new ArrayList<>();
        this.discount = 0;
    }

    // Getter methods - to retrieve values
    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getPrice() {
        return this.price;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCategory() {
        return this.category;
    }

    public int getDiscount() {
        return this.discount;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public List<String> getImages() {
        return this.images;
    }

    // Setter methods - to set values with validation
    public void setName(String name) {
        // Basic validation - can be done here
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Warning: Product name cannot be empty!");
            return;
        }
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(int price) {
        // Validation happens AFTER object creation
        if (price < 0) {
            System.out.println("Warning: Price cannot be negative! Price not set.");
            return; // Don't set negative price
        }
        if (price > 1000000) {
            System.out.println("Warning: Price seems too high! Please verify.");
        }
        this.price = price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            System.out.println("Warning: Brand name should not be empty!");
            return;
        }
        this.brand = brand;
    }

    public void setCategory(String category) {
        // Could add validation for valid categories
        if (category != null) {
            this.category = category.toLowerCase(); // Normalize to lowercase
        }
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            System.out.println("Warning: Discount should be between 0 and 100!");
            return;
        }
        this.discount = discount;
    }

    public void setCreatedAt(String createdAt) {
        // Could add date format validation here
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        // Could add date format validation here
        this.updatedAt = updatedAt;
    }

    public void setImages(List<String> images) {
        if (images == null) {
            this.images = new ArrayList<>();
        } else {
            this.images = images;
        }
    }

    // Helper method to add a single image
    public void addImage(String imageUrl) {
        if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            if (this.images == null) {
                this.images = new ArrayList<>();
            }
            this.images.add(imageUrl);
        }
    }

    // Method to display product information
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
        System.out.println("Images: " + (images != null && !images.isEmpty() ? 
                          images.size() + " image(s)" : "No images"));
        System.out.println();
    }
}
