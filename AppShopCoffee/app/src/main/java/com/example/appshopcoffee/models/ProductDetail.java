package com.example.appshopcoffee.models;

public class ProductDetail {
    private String title;
    private String price;
    private String description;
    private float rating;
    private int imageRes;
    private int quantity = 1;

    public ProductDetail(String title, String price, String description, float rating, int imageRes) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.rating = rating;
        this.imageRes = imageRes;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
