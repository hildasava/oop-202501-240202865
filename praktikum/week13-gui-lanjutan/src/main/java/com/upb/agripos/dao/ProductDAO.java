package com.upb.agripos.dao;
import com.upb.agripos.model.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    void save(Product product);
    void delete(String id); // <-- Tambahkan baris ini
}