package com.upb.agripos.view;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class AppJavaFX extends Application {

    // Memanggil Service untuk akses database
    private ProductService service = new ProductService();
    private ListView<Product> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        // --- UI COMPONENTS ---
        Label lblTitle = new Label("Sistem Manajemen Produk - AgriPOS");
        lblTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        TextField txtCode = new TextField(); txtCode.setPromptText("Kode Produk");
        TextField txtName = new TextField(); txtName.setPromptText("Nama Produk");
        TextField txtPrice = new TextField(); txtPrice.setPromptText("Harga");
        TextField txtStock = new TextField(); txtStock.setPromptText("Stok");
        
        Button btnAdd = new Button("Tambah Produk");

        // --- DATABASE LOGIC ---

        // Fungsi untuk mengambil data terbaru dari database
        Runnable loadFromDatabase = () -> {
            listView.getItems().clear();
            List<Product> products = service.getAllProducts();
            listView.getItems().addAll(products);
        };

        // Ambil data saat aplikasi pertama kali dibuka
        loadFromDatabase.run();

        // Aksi saat tombol Tambah diklik
        btnAdd.setOnAction(e -> {
            try {
                Product p = new Product(
                    txtCode.getText(), 
                    txtName.getText(), 
                    Double.parseDouble(txtPrice.getText()), 
                    Integer.parseInt(txtStock.getText())
                );
                
                service.addProduct(p); // Simpan ke PostgreSQL
                loadFromDatabase.run(); // Refresh daftar di bawah
                
                // Bersihkan input
                txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear();
            } catch (Exception ex) {
                System.out.println("Error: Pastikan harga/stok berupa angka!");
            }
        });

        // --- LAYOUT ---
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
            lblTitle, txtCode, txtName, txtPrice, txtStock, 
            btnAdd, new Label("Daftar:"), listView
        );

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setTitle("Agri-POS Week 12 - Hilda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}