package com.example.appshopcoffee.models;

public class OfferItem {
    private String title;
    private String extra;
    private String price;
    private float rating;
    private int imageRes;

    public OfferItem(String title, String extra, String price, float rating, int imageRes) {
        this.title = title;
        this.extra = extra;
        this.price = price;
        this.rating = rating;
        this.imageRes = imageRes;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getExtra() { return extra; }
    public void setExtra(String extra) { this.extra = extra; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }
}