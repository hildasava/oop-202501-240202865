package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    public List<Product> getAllProducts() {
        return productDAO.findAll(); // Tetap sama
    }

    public void addProduct(Product product) {
        productDAO.save(product); // Tetap sama
    }

    // --- TAMBAHAN BARU UNTUK WEEK 13 ---
    public void deleteProduct(String id) {
        productDAO.delete(id); // Memanggil fungsi delete di DAO
    }
}