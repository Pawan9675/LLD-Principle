// Product.java - Advanced Builder Pattern (Version 4) - The Perfect Solution
package BuilderDesignPattern.BetterCode.Final_Solution_AdvancedBuilderPattern;

import java.util.List;
import java.util.ArrayList;

public class Product {
    // Product properties - same as before
    private String name;
    private String desc;
    private int price;
    private String brand;
    private String category;
    private int discount;
    private String createdAt;
    private String updatedAt;
    private List<String> images;

    // PRIVATE constructor - only Builder can call this!
    // This prevents users from calling new Product(null) or new Product(invalidBuilder)
    private Product(Builder builder) {
        System.out.println("Creating Product using Advanced Builder Pattern...");
        
        // Comprehensive validation BEFORE object creation
        validateBuilder(builder);
        
        // All validations passed - create the object
        this.name = builder.name;
        this.desc = builder.desc;
        this.price = builder.price;
        this.brand = builder.brand;
        this.category = builder.category;
        this.discount = builder.discount;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.images = builder.images != null ? new ArrayList<>(builder.images) : new ArrayList<>();
        
        System.out.println("✅ Product created successfully!");
    }

    // Static method to get a Builder - this is the ONLY way users can start
    // Users call: Product.getBuilder() instead of new Builder()
    public static Builder getBuilder() {
        return new Builder();
    }

    // Validation method - validates Builder before Product creation
    private void validateBuilder(Builder builder) {
        System.out.println("Validating builder data...");
        
        // Check required fields
        if (builder.name == null || builder.name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required and cannot be empty!");
        }
        
        if (builder.price <= 0) {
            throw new IllegalArgumentException("Product price must be greater than 0! Got: " + builder.price);
        }
        
        if (builder.brand == null || builder.brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Product brand is required and cannot be empty!");
        }
        
        // Business rule validations
        if (builder.discount > 50 && builder.price < 100) {
            throw new IllegalArgumentException("High discount (>50%) not allowed on low-priced items (<$100)!");
        }
        
        if (builder.discount < 0 || builder.discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100! Got: " + builder.discount);
        }
        
        System.out.println("✅ Builder validation passed!");
    }

    // Getter methods for Product
    public String getName() { return this.name; }
    public String getDesc() { return this.desc; }
    public int getPrice() { return this.price; }
    public String getBrand() { return this.brand; }
    public String getCategory() { return this.category; }
    public int getDiscount() { return this.discount; }
    public String getCreatedAt() { return this.createdAt; }
    public String getUpdatedAt() { return this.updatedAt; }
    public List<String> getImages() { return new ArrayList<>(this.images); } // Return defensive copy

    // Display method for Product
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
        System.out.println("Images: " + images.size() + " image(s)");
        if (!images.isEmpty()) {
            for (int i = 0; i < images.size(); i++) {
                System.out.println("  Image " + (i+1) + ": " + images.get(i));
            }
        }
        System.out.println("==============================\n");
    }

    // INNER STATIC Builder class - this is the magic!
    // Static = doesn't need access to outer Product instance
    // Inner = can access private Product constructor
    public static class Builder {
        // Same properties as Product - Builder collects these values
        private String name;
        private String desc;
        private int price;
        private String brand;
        private String category;
        private int discount;
        private String createdAt;
        private String updatedAt;
        private List<String> images;

        // PRIVATE constructor - only Product.getBuilder() can create this
        // This prevents users from calling new Builder() directly
        private Builder() {
            // Initialize with sensible defaults
            this.images = new ArrayList<>();
            this.discount = 0;
            this.price = 0;
        }

        // THE MAGIC METHOD - creates final Product object
        // This is where all the validation happens
        public Product build() {
            return new Product(this); // 'this' refers to current Builder instance
        }

        // FLUENT SETTERS - each returns 'this' for method chaining
        // The return 'this' is what enables: builder.setName().setPrice().setBrand()
        public Builder setName(String name) {
            if (name != null) {
                this.name = name.trim(); // Clean up whitespace
            }
            return this; // Return current Builder instance for chaining
        }

        public Builder setDesc(String desc) {
            if (desc != null) {
                this.desc = desc.trim();
            }
            return this; // Return current Builder instance for chaining
        }

        public Builder setPrice(int price) {
            if (price < 0) {
                System.out.println("Warning: Negative price provided, will be validated during build()");
            }
            this.price = price;
            return this; // Return current Builder instance for chaining
        }

        public Builder setBrand(String brand) {
            if (brand != null) {
                this.brand = brand.trim();
            }
            return this; // Return current Builder instance for chaining
        }

        public Builder setCategory(String category) {
            if (category != null) {
                this.category = category.trim();
            }
            return this; // Return current Builder instance for chaining
        }

        public Builder setDiscount(int discount) {
            this.discount = discount;
            return this; // Return current Builder instance for chaining
        }

        public Builder setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this; // Return current Builder instance for chaining
        }

        public Builder setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this; // Return current Builder instance for chaining
        }

        public Builder setImages(List<String> images) {
            if (images == null) {
                this.images = new ArrayList<>();
            } else {
                this.images = new ArrayList<>(images); // Create defensive copy
            }
            return this; // Return current Builder instance for chaining
        }

        // Helper method to add individual images - demonstrates Builder flexibility
        public Builder addImage(String imageUrl) {
            if (imageUrl != null && !imageUrl.trim().isEmpty()) {
                if (this.images == null) {
                    this.images = new ArrayList<>();
                }
                this.images.add(imageUrl.trim());
            }
            return this; // Return current Builder instance for chaining
        }

        // Helper method to clear all images
        public Builder clearImages() {
            if (this.images != null) {
                this.images.clear();
            }
            return this; // Return current Builder instance for chaining
        }

        // Method to display current builder state (for debugging)
        public Builder showCurrentState() {
            System.out.println("=== Builder Current State ===");
            System.out.println("Name: " + (name != null ? "'" + name + "'" : "Not set"));
            System.out.println("Description: " + (desc != null ? "'" + desc + "'" : "Not set"));
            System.out.println("Price: $" + price);
            System.out.println("Brand: " + (brand != null ? "'" + brand + "'" : "Not set"));
            System.out.println("Category: " + (category != null ? "'" + category + "'" : "Not set"));
            System.out.println("Discount: " + discount + "%");
            System.out.println("Created At: " + (createdAt != null ? createdAt : "Not set"));
            System.out.println("Updated At: " + (updatedAt != null ? updatedAt : "Not set"));
            System.out.println("Images: " + (images != null ? images.size() + " image(s)" : "0 images"));
            System.out.println("=============================\n");
            return this; // Return current Builder instance for chaining
        }
    }
}
