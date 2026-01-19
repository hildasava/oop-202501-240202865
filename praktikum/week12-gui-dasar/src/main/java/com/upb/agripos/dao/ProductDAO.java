package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.List; // Import ini wajib ada untuk daftar produk

public interface ProductDAO {
    // Kontrak untuk memasukkan data baru ke database
    void insert(Product p);

    // TAMBAHKAN INI: Kontrak untuk mengambil semua data dari database
    List<Product> findAll(); 
}