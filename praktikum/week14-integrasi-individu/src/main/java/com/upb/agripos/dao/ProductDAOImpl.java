package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    // Simulasi database sementara agar program bisa jalan dulu
    private static List<Product> db = new ArrayList<>();

    @Override
    public void save(Product product) {
        db.add(product);
        System.out.println("Produk disimpan ke DB: " + product.getName());
    }

    @Override
    public List<Product> findAll() {
        return db;
    }

    @Override
    public void delete(String code) {
        db.removeIf(p -> p.getCode().equals(code));
    }
}