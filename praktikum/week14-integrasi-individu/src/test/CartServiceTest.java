package com.upb.agripos.service;

import com.upb.agripos.model.Product;
import com.upb.agripos.model.CartItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    @Test
    public void testCalculateTotal() {
        // 1. Setup Data
        CartService cartService = new CartService();
        Product p1 = new Product("001", "Pupuk Organik", 50000.0, 10);
        Product p2 = new Product("002", "Benih Padi", 25000.0, 20);

        // 2. Eksekusi: Tambah ke Keranjang
        cartService.addToCart(p1, 2); // 50.000 x 2 = 100.000
        cartService.addToCart(p2, 1); // 25.000 x 1 = 25.000

        // 3. Verifikasi: Total harus 125.000
        double expectedTotal = 125000.0;
        double actualTotal = cartService.calculateTotal();

        assertEquals(expectedTotal, actualTotal, "Total harga keranjang tidak sesuai!");
    }

    @Test
    public void testClearCart() {
        CartService cartService = new CartService();
        Product p1 = new Product("001", "Cangkul", 75000.0, 5);
        
        cartService.addToCart(p1, 1);
        cartService.getCart().clear();
        
        assertEquals(0, cartService.getCart().getItems().size(), "Keranjang harusnya kosong setelah clear!");
    }
}