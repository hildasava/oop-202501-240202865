package com.upb.agripos.dao;

import com.upb.agripos.config.DatabaseConfig;
import com.upb.agripos.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO products (id, name, price, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getStock());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- BAGIAN PENTING UNTUK WEEK 13 ---
    @Override
    public void delete(String id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, id); // Mengunci ID produk yang mau dihapus
            int rowsDeleted = pstmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Berhasil menghapus produk dengan ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Gagal hapus data: " + e.getMessage());
        }
    }
}