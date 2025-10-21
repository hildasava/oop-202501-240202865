package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {

        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Coklat 50", 90000, 100, "50"),
            new Pupuk("PPK-101", "Pupuk Kandang 25kg", 70000, 50, "Organik"),
            new AlatPertanian("ALT-501", "Penyiram Tanaman", 40000, 75, "Plastik"),
            new ObatHama("HLD-012", "Obat Hama Ulat Daun", 50000, 50, "Hypsipyla robusta")
        };

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }

        CreditBy.print();
    }
}
