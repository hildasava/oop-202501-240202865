package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;

public class ProductController {
    @FXML private TextField txtCode;
    @FXML private TextField txtName;
    @FXML private TextField txtPrice;
    @FXML private TextField txtStock;
    @FXML private ListView<Product> listView;

    private ProductService service = new ProductService();

    @FXML
    public void initialize() {
        loadData();
    }

    private void loadData() {
        listView.getItems().clear();
        List<Product> products = service.getAllProducts();
        listView.getItems().addAll(products);
    }

    @FXML
    private void handleAddProduct() {
        // Mengambil input dari user
        String code = txtCode.getText();
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int stock = Integer.parseInt(txtStock.getText());

        // Membuat objek product baru
        Product p = new Product(code, name, price, stock);
        
        // Simpan ke database melalui service
        service.addProduct(p);
        
        // Refresh daftar di layar
        loadData();
        
        // Kosongkan form setelah input
        txtCode.clear();
        txtName.clear();
        txtPrice.clear();
        txtStock.clear();
    }
}