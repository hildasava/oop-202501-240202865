package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.service.CartService;

public class PosController {
    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();

    public void addProduct(String id, String name, String price, String stock) throws Exception {
        if(id.isEmpty() || name.isEmpty()) throw new Exception("Data tidak boleh kosong!");
        Product p = new Product(id, name, Double.parseDouble(price), Integer.parseInt(stock));
        productService.saveProduct(p);
    }

    public void deleteProduct(String id) {
        productService.deleteProduct(id);
    }
}