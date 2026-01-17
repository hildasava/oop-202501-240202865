package com.upb.agripos.controller;

import com.upb.agripos.model.Product;

public class ProductController {
    public void display(Product p) {
        System.out.println("Menampilkan Produk: " + p.getName());
        System.out.println("Harga: Rp" + p.getPrice());
    }
}