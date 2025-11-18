package com.example.appshopcoffee.models;

public class PopularItem {
    private String title;
    private String price;
    private int imageRes; // Assuming drawable resource ID

    public PopularItem(String title, String price, int imageRes) {
        this.title = title;
        this.price = price;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
