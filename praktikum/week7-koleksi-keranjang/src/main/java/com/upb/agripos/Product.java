package com.upb.agripos;

/**
 * Class Product digunakan sebagai cetak biru (blueprint) untuk 
 * objek barang dalam sistem Agri-POS.
 */
public class Product {
    private final String code;
    private final String name;
    private final double price;

    // Konstruktor untuk menginisialisasi kode, nama, dan harga produk
    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // Getter untuk mengambil nilai atribut
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}