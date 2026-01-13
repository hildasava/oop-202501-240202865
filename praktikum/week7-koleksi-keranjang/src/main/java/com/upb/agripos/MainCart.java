package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        // GANTI BAGIAN INI
        System.out.println("Hello, I am Budi Santoso - 220101001 (Week7)");
        System.out.println("Sistem Agri-POS Ready...\n");

        // 1. Inisialisasi Produk
        Product p1 = new Product("P01", "Beras Rojolele", 50000);
        Product p2 = new Product("P02", "Pupuk Urea", 30000);
        Product p3 = new Product("P03", "Bibit Jagung", 15000);

        // 2. Uji Coba ArrayList (Sederhana)
        ShoppingCart simpleCart = new ShoppingCart();
        simpleCart.addProduct(p1);
        simpleCart.addProduct(p2);
        simpleCart.printCart();

        // 3. Uji Coba Map (Dengan Quantity)
        ShoppingCartMap advancedCart = new ShoppingCartMap();
        advancedCart.addProduct(p1);
        advancedCart.addProduct(p1); // Tambah Beras lagi (qty jadi 2)
        advancedCart.addProduct(p3);
        advancedCart.printCart();

        // Hapus satu produk
        System.out.println("Menghapus 1 Bibit Jagung...");
        advancedCart.removeProduct(p3);
        advancedCart.printCart();
    }
}