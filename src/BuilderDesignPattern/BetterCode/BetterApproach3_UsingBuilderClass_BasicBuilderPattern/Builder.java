// Builder.java - Separate Helper Class for Building Product
package BuilderDesignPattern.BetterCode.BetterApproach3_UsingBuilderClass_BasicBuilderPattern;

import java.util.List;
import java.util.ArrayList;

public class Builder {
    // Same properties as Product class
    private String name;
    private String desc;
    private int price;
    private String brand;
    private String category;
    private int discount;
    private String createdAt;
    private String updatedAt;
    private List<String> images;

    // Empty constructor - no validation needed for Builder
    Builder() {
        // Initialize with sensible defaults
        this.images = new ArrayList<>();
        this.discount = 0;
        this.price = 0;
    }

    // Getter methods - to retrieve values when creating Product
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

    // Setter methods - no validation constraints on Builder
    // Builder is just a helper, validation happens in Product constructor
    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(int price) {
        // Simple validation can be done here if needed
        if (price < 0) {
            System.out.println("Warning: Setting negative price in builder");
            return; // Don't set negative price
        }
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            System.out.println("Warning: Invalid discount range in builder");
            return;
        }
        this.discount = discount;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setImages(List<String> images) {
        if (images == null) {
            this.images = new ArrayList<>();
        } else {
            this.images = new ArrayList<>(images); // Create defensive copy
        }
    }

    // Helper method to add individual images
    public void addImage(String imageUrl) {
        if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            if (this.images == null) {
                this.images = new ArrayList<>();
            }
            this.images.add(imageUrl);
        }
    }

    // Method to display current builder state (for debugging)
    public void displayBuilderState() {
        System.out.println("=== Builder Current State ===");
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