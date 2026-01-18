package com.upb.agripos;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;

public class MainDAOTest {
    public static void main(String[] args) {
        // Nama database disesuaikan dengan pgAdmin kamu yaitu 'agripos'
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        String pass = ""; // Kosongkan jika pgAdmin kamu tidak pakai password

        System.out.println("Menghubungkan ke database...");

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Koneksi berhasil...");
            ProductDAO dao = new ProductDAOImpl(conn);

            // 1. INSERT PRODUCT
            System.out.println("-------------------------");
            System.out.println("INSERT PRODUCT");
            // Menggunakan ID "1" karena di database kamu tipenya angka (INT/SERIAL)
            Product baru = new Product("1", "Pupuk Organik Premium", 30000.0, 10);
            dao.insert(baru);
            System.out.println("Produk berhasil ditambahkan!");

            // 2. UPDATE PRODUCT
            System.out.println("-------------------------");
            System.out.println("UPDATING PRODUCT...");
            baru.setName("Pupuk Organik Super");
            baru.setStock(15);
            dao.update(baru);
            System.out.println("Produk berhasil diperbarui.");

            // 3. FIND PRODUCT BY CODE
            System.out.println("-------------------------");
            System.out.println("FIND PRODUCT BY CODE");
            Product p = dao.findByCode("1"); 
            if (p != null) {
                System.out.println("Data produk ditemukan:");
                System.out.println("ID    : " + p.getCode());
                System.out.println("Nama  : " + p.getName());
                System.out.println("Harga : " + p.getPrice());
                System.out.println("Stok  : " + p.getStock());
            } else {
                System.out.println("Data produk tidak ditemukan.");
            }

            // 4. DELETE PRODUCT (Opsional)
            System.out.println("-------------------------");
            System.out.println("DELETE PRODUCT");
            // dao.delete("1"); // Hapus tanda // di awal baris ini jika ingin mencoba hapus
            System.out.println("Status: Selesai");

            System.out.println("-------------------------");
            System.out.println("Koneksi database ditutup.");
            System.out.println("credit by Hilda - 240202865");

        } catch (Exception e) {
            System.err.println("Gagal: " + e.getMessage());
            // Jika muncul error 'duplicate key', ganti angka "1" di atas jadi "2"
        }
    }
}