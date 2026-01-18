package com.upb.agripos.dao;

import main.java.com.upb.agripos.model.Product; // Tambahkan ini kalau merah

import java.util.List;
import com.upb.agripos.model.Product; // Import ini sangat penting!

public interface ProductDAO {
    void insert(Product product) throws Exception;
    Product findByCode(String code) throws Exception;
    List<Product> findAll() throws Exception;
    void update(Product product) throws Exception;
    void delete(String code) throws Exception;
}