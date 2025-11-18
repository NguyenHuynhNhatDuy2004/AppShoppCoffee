package com.example.appshopcoffee.models;

public class CartItem {
    private String title;
    private String pricePerItem;
    private String totalPrice;
    private int quantity;
    private int imageRes;

    public CartItem(String title, String pricePerItem, String totalPrice, int quantity, int imageRes) {
        this.title = title;
        this.pricePerItem = pricePerItem;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.imageRes = imageRes;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPricePerItem() { return pricePerItem; }
    public void setPricePerItem(String pricePerItem) { this.pricePerItem = pricePerItem; }
    public String getTotalPrice() { return totalPrice; }
    public void setTotalPrice(String totalPrice) { this.totalPrice = totalPrice; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }
}
