package com.upb.agripos.view;

import com.upb.agripos.model.Product;
import com.upb.agripos.controller.ProductController;
import com.upb.agripos.config.DatabaseConnection;

public class AppMVC {
    public static void main(String[] args) {
        // Menampilkan Identitas
        System.out.println("Hello, Hilda Sava Alzena - 240202865 (Week10)");

        // Memanggil Koneksi Database (Agar muncul tulisan terhubung)
        new DatabaseConnection();

        // Menampilkan Produk
        Product product = new Product("Beras", 10000.0);
        ProductController controller = new ProductController();
        controller.display(product);
    }
}