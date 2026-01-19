package com.upb.agripos.view;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.model.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    private TableView<Product> table = new TableView<>();
    private ObservableList<Product> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        PosController controller = new PosController();
        
        // --- Layout Utama Pink ---
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #FFE4E1;"); 

        // --- Header Pink Tua ---
        VBox header = new VBox();
        header.setPadding(new Insets(15));
        header.setStyle("-fx-background-color: #DB7093; -fx-background-radius: 15;");
        Label title = new Label("AGRI-POS SYSTEM");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
        Label subTitle = new Label("Hilda - 240202865"); // Ganti NIM kamu di sini
        subTitle.setStyle("-fx-text-fill: #FFF0F5;");
        header.getChildren().addAll(title, subTitle);

        // --- Konten Utama ---
        HBox content = new HBox(20);
        
        // --- Panel Kiri: Form & Tabel ---
        VBox leftPane = new VBox(10);
        leftPane.setPadding(new Insets(15));
        leftPane.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-color: #FFB6C1;");
        leftPane.setPrefWidth(550);

        Label lblLeft = new Label("Manajemen Produk");
        lblLeft.setStyle("-fx-text-fill: #C71585; -fx-font-weight: bold;");

        // Input Fields
        TextField txtCode = createPinkField("Kode Produk");
        TextField txtName = createPinkField("Nama Produk");
        TextField txtPrice = createPinkField("Harga");
        TextField txtStock = createPinkField("Stok");

        Button btnAdd = new Button("Tambah Produk");
        btnAdd.setStyle("-fx-background-color: #FF69B4; -fx-text-fill: white; -fx-font-weight: bold;");
        
        // --- SETTING TABEL ---
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        
        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(colCode, colName, colPrice);
        table.setItems(data);
        table.setPrefHeight(200);

        // Logika Tombol Tambah
        btnAdd.setOnAction(e -> {
            try {
                Product p = new Product(txtCode.getText(), txtName.getText(), 
                            Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtStock.getText()));
                data.add(p); // Tambah ke tampilan tabel
                txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear();
            } catch (Exception ex) {
                System.out.println("Error: Input harus angka!");
            }
        });

        leftPane.getChildren().addAll(lblLeft, txtCode, txtName, txtPrice, txtStock, btnAdd, table);

        // --- Panel Kanan: Keranjang ---
        VBox rightPane = new VBox(10);
        rightPane.setPadding(new Insets(15));
        rightPane.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-color: #FFB6C1;");
        rightPane.setPrefWidth(300);
        Label lblRight = new Label("Keranjang Belanja");
        lblRight.setStyle("-fx-text-fill: #C71585; -fx-font-weight: bold;");
        
        Button btnCheckout = new Button("CHECKOUT");
        btnCheckout.setPrefWidth(200);
        btnCheckout.setStyle("-fx-background-color: #C71585; -fx-text-fill: white; -fx-font-weight: bold;");
        
        rightPane.getChildren().addAll(lblRight, btnCheckout);

        content.getChildren().addAll(leftPane, rightPane);
        root.getChildren().addAll(header, content);

        Scene scene = new Scene(root, 950, 700);
        stage.setTitle("Agri-POS Week 14 - Hilda");
        stage.setScene(scene);
        stage.show();
    }

    private TextField createPinkField(String prompt) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        tf.setStyle("-fx-border-color: #FFB6C1; -fx-background-radius: 5; -fx-border-radius: 5;");
        return tf;
    }

    public static void main(String[] args) {
        launch(args);
    }
}