package com.upb.agripos.service;

import com.upb.agripos.model.Product;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    public void saveProduct(Product product) throws Exception {
        // Validasi Exception (Bab 9)
        if (product.getPrice() < 0) throw new Exception("Harga tidak boleh negatif!");
        productDAO.save(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public void deleteProduct(String code) {
        productDAO.delete(code);
    }
}