package com.upb.agripos;

import com.upb.agripos.model.Produk;
import com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {

        Produk p1 = new Produk("HLD-005", "Benih Coklat 50", 90000.0, 70);
        Produk p2 = new Produk("SVA-007", "Pupuk Kandang 30kg", 70000.0, 50);
        Produk p3 = new Produk("ZNA-020", "Penyiram Tanaman 05", 40000.0, 20);

        System.out.println("=== Info Awal Produk ===");
        p1.tampilkanInfo();
        p2.tampilkanInfo();
        p3.tampilkanInfo();

        System.out.println("\n=== Menambah Stok Produk ===");
        System.out.println("Menambah stok Benih Coklat 50 sebanyak 25");
        p1.tambahStok(25);
        p1.tampilkanInfo();

        System.out.println("\n=== Mengurangi Stok Produk ===");
        System.out.println("Mengurangi stok Penyiram Tanaman 05 sebanyak 10");
        p3.kurangiStok(10);
        p3.tampilkanInfo();

        CreditBy.print();
    }
}
