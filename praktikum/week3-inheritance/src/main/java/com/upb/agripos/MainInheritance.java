package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {

        Benih b = new Benih("BNH-001", "Benih Coklat 50", 90000.0, 70, "50");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Kandang 25kg", 70000.0, 50, "Organik");
        AlatPertanian a = new AlatPertanian("ALT-501", "Penyiram Tanaman", 40000.0, 20, "Plastik");

        System.out.println("=== Data Produk Pertanian ===");
        b.deskripsi();
        p.deskripsi();
        a.deskripsi();

        System.out.println("\n=== Menambah Stok Produk ===");
        System.out.println("Menambah stok Benih Coklat 50 sebanyak 25");
        b.tambahStok(20);
        b.deskripsi();

        System.out.println("\n=== Mengurangi Stok Produk ===");
        System.out.println("Mengurangi stok Penyiram Tanaman sebanyak 10");
        a.kurangiStok(10);
        a.deskripsi();

        CreditBy.print();
    }
}
