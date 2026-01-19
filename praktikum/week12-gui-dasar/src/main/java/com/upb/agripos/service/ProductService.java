package com.upb.agripos.service;

import com.upb.agripos.model.Product;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import java.util.List; // Tambahkan import ini

public class ProductService {
    private ProductDAO dao = new ProductDAOImpl();

    // Fungsi untuk simpan produk (Sudah ada di punyamu)
    public void addProduct(Product p) {
        dao.insert(p);
    }

    // TAMBAHKAN INI: Fungsi untuk mengambil semua data dari DAO
    public List<Product> getAllProducts() {
        return dao.findAll(); // Memanggil fungsi findAll di DAO
    }
}