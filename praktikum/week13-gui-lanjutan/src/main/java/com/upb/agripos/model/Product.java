package com.upb.agripos.model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // WAJIB ADA INI
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return id + " - " + name + " (Stok: " + stock + ")";
    }
}