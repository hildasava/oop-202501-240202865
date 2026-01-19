package com.upb.agripos.view;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    private ProductService service = new ProductService();
    private TableView<Product> table = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        // --- UI COMPONENTS ---
        Label lblTitle = new Label("Sistem Manajemen Produk - AgriPOS (Week 13)");
        lblTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        TextField txtCode = new TextField(); txtCode.setPromptText("Kode");
        TextField txtName = new TextField(); txtName.setPromptText("Nama");
        TextField txtPrice = new TextField(); txtPrice.setPromptText("Harga");
        TextField txtStock = new TextField(); txtStock.setPromptText("Stok");
        
        Button btnAdd = new Button("Tambah Produk");
        Button btnDelete = new Button("Hapus Produk"); 
        btnDelete.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white;");

        // --- KONFIGURASI TABLEVIEW (WEEK 13) ---
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Product, String> colName = new TableColumn<>("Nama Produk");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getColumns().addAll(colCode, colName, colPrice, colStock);
        table.setPlaceholder(new Label("Belum ada data produk"));

        // --- DATABASE LOGIC ---
        Runnable loadData = () -> {
            ObservableList<Product> data = FXCollections.observableArrayList(service.getAllProducts());
            table.setItems(data);
        };

        loadData.run();

        // Lambda Tambah
        btnAdd.setOnAction(e -> {
            try {
                Product p = new Product(
                    txtCode.getText(), 
                    txtName.getText(), 
                    Double.parseDouble(txtPrice.getText()), 
                    Integer.parseInt(txtStock.getText())
                );
                service.addProduct(p);
                loadData.run();
                txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear();
            } catch (Exception ex) {
                showAlert("Error", "Input tidak valid!");
            }
        });

        // Lambda Hapus
        btnDelete.setOnAction(e -> {
            Product selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                service.deleteProduct(selected.getId());
                loadData.run();
            } else {
                showAlert("Peringatan", "Pilih produk di tabel yang ingin dihapus!");
            }
        });

        // --- LAYOUT & STAGE (Bagian yang tadi terpotong) ---
        HBox inputBox = new HBox(10, txtCode, txtName, txtPrice, txtStock, btnAdd);
        inputBox.setPadding(new Insets(10, 0, 10, 0));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(lblTitle, inputBox, table, btnDelete);

        Scene scene = new Scene(layout, 800, 500);
        primaryStage.setTitle("Agri-POS Week 13 - Hilda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method Helper untuk Alert
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}