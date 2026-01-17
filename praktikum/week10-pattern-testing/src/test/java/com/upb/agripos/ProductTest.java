package com.upb.agripos;

import org.junit.Test;
import static org.junit.Assert.*;
import com.upb.agripos.model.Product;

public class ProductTest {

    @Test
    public void testProductGetters() {
        // Menggunakan angka 10000.0 (tanpa tanda kutip) agar sesuai tipe double
        Product product = new Product("Beras", 10000.0);
        
        assertEquals("Beras", product.getName());
        assertEquals(10000.0, product.getPrice(), 0.001);
    }
}