package com.upb.agripos.model;

public class Product {
    private String code; // Pastikan namanya 'code'
    private String name;
    private double price;
    private int stock;

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() { return code; } // Ini yang dicari DAO
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
}