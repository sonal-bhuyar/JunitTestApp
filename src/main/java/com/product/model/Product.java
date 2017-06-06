package com.product.model;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public class Product {
    private String name = null;
    private String type = null;
    private double price = 0;

    public Product() {
    }

    public Product(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
