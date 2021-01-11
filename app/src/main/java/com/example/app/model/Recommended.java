package com.example.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recommended {
    @Expose
    private String name;
    @Expose
    private String imageUrl;
    @Expose
    private String rating;
    @Expose
    private String deliveryTime;
    @Expose
    private String deliveryCharges;
    @Expose
    private String price;
    @Expose
    private String note;
    @Expose
    private int id;

    public Recommended(String name, String imageUrl, String rating, String deliveryTime, String deliveryCharges, String price, String note) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.deliveryCharges = deliveryCharges;
        this.price = price;
        this.note = note;
    }

    public Recommended(int id,String name, String imageUrl, String rating, String deliveryTime, String deliveryCharges, String price, String note) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.deliveryCharges = deliveryCharges;
        this.price = price;
        this.note = note;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
