package com.upb.agripos.view;

// --- IMPORT WAJIB AGAR TIDAK ERROR "CANNOT FIND SYMBOL" ---
import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductTableView extends VBox {
    private TableView<Product> table = new TableView<>();
    private ProductService service = new ProductService();

    public ProductTableView() {
        // 1. Membuat Kolom
        TableColumn<Product, String> colId = new TableColumn<>("Kode");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Product, String> colName = new TableColumn<>("Nama Produk");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getColumns().addAll(colId, colName, colPrice, colStock);

        // 2. Tombol Hapus dengan Lambda
        Button btnDelete = new Button("Hapus Terpilih");
        btnDelete.setOnAction(e -> {
            Product selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                service.deleteProduct(selected.getId());
                loadData();
            }
        });

        // 3. Menampilkan ke layar
        this.getChildren().addAll(new Label("Data Produk Agri-POS"), table, btnDelete);
        loadData();
    }

    public void loadData() {
        ObservableList<Product> data = FXCollections.observableArrayList(service.getAllProducts());
        table.setItems(data);
    }
}