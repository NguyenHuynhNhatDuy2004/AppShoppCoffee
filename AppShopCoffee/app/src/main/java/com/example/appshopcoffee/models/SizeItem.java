package com.example.appshopcoffee.models;

public class SizeItem {
    private int imageRes;
    private String sizeName; // e.g., "Small", "Medium"

    public SizeItem(int imageRes, String sizeName) {
        this.imageRes = imageRes;
        this.sizeName = sizeName;
    }

    // Getters and setters
    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }
    public String getSizeName() { return sizeName; }
    public void setSizeName(String sizeName) { this.sizeName = sizeName; }
}
