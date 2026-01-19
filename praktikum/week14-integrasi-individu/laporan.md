# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Integrasi Antarmuka dan Pengujian Unit (Unit Testing)]

## Identitas
- Nama  : [Hilda Sava Alzena]
- NIM   : [240202865]
- Kelas : [3ikra]

---

## Tujuan
   Mahasiswa mampu mengintegrasikan komponen-komponen aplikasi (Model, Service, Controller, dan View) dalam satu sistem Agri-POS yang utuh, serta mampu melakukan validasi logika bisnis menggunakan pengujian unit (unit testing) dengan JUnit untuk memastikan fungsionalitas sistem berjalan sesuai spesifikasi.
---

## Dasar Teori
   1. Integrasi Komponen MVC (Model-View-Controller): Proses menghubungkan logika bisnis (Service), penyimpanan data (DAO), dan antarmuka pengguna (JavaFX) agar dapat bekerja secara sinkron dalam satu sistem aplikasi yang utuh.

   2. Layered Architecture (Arsitektur Berlapis): Pemisahan kode program ke dalam beberapa lapisan (seperti Service Layer untuk logika bisnis dan DAO Layer untuk akses database) bertujuan agar aplikasi lebih mudah dikelola, diuji, dan dikembangkan.

   3. Unit Testing dengan JUnit: Pengujian yang dilakukan pada unit terkecil dari perangkat lunak (seperti method atau class) secara mandiri untuk memastikan bahwa logika kode tersebut sudah sesuai dengan hasil yang diharapkan.

   4. Automated Testing & Maven: Penggunaan alat manajemen proyek seperti Maven memungkinkan eksekusi pengujian secara otomatis setiap kali proses build dilakukan, yang ditandai dengan status BUILD SUCCESS jika seluruh tes terlewati.

   5. Logika Bisnis (Business Logic): Aturan-aturan inti aplikasi (seperti penghitungan total harga di keranjang belanja atau pengecekan stok produk) yang ditempatkan pada bagian Service agar terpisah dari tampilan antarmuka.

---

## Langkah Praktikum
1. Langkah-langkah yang Dilakukan
   Persiapan Proyek: Membuka proyek Agri-POS di VS Code dan memastikan struktur folder sudah sesuai dengan pola MVC (Model-View-Controller).

   Integrasi Service Layer: Melakukan coding dan penyempurnaan pada CartService.java untuk menangani logika manipulasi keranjang belanja.

   Pengembangan Antarmuka (GUI): Mengintegrasikan AppJavaFX.java dengan PosController.java untuk menampilkan data produk dan fungsionalitas keranjang di layar aplikasi.

   Penyusunan Unit Test: Menulis skenario pengujian di CartServiceTest.java menggunakan JUnit untuk memvalidasi 10 fungsi utama sistem.

   Eksekusi Pengujian: Menjalankan perintah mvn clean test melalui terminal untuk memastikan seluruh kode terintegrasi dengan benar.

   Verifikasi Hasil: Memastikan status akhir menunjukkan BUILD SUCCESS dan jumlah tes yang berhasil adalah 10/10.

2. File Utama yang Dibuat/Modifikasi
   CartService.java: Berisi logika bisnis utama untuk fitur keranjang belanja.

   CartServiceTest.java: Berisi 10 skenario uji otomatis untuk memvalidasi layanan keranjang.

   AppJavaFX.java: File utama untuk menjalankan antarmuka aplikasi dengan JavaFX.

   pom.xml: Konfigurasi Maven yang memastikan dependency JUnit dan JavaFX terpasang dengan benar.

3. Commit Message yang Digunakan
   feat: implement cart service logic and unit tests

   fix: integrate javafx view with pos controller

   test: ensure all 10 test cases pass for cart service

---

## Kode Program
1. Logika Bisnis (CartService.java)
   Bagian ini menunjukkan bagaimana kamu mengelola item di dalam keranjang belanja.

// Menambahkan produk ke dalam keranjang
public void addToCart(Product product, int quantity) {
    CartItem item = new CartItem(product, quantity);
    cart.addItem(item);
}

// Menghitung total harga belanjaan
public double getTotalPrice() {
    return cart.getItems().stream()
               .mapToDouble(item -> item.getProduct().getHarga() * item.getQuantity())
               .sum();
}

2. Skenario Pengujian (CartServiceTest.java)
   Ini adalah salah satu dari 10 skenario tes yang memastikan angka 10/10 kamu berhasil tercapai.

   @Test
void testCalculateTotalWithMultipleItems() {
    // Setup produk
    Product p1 = new Product("P01", "Pupuk Organik", 50000.0, 10);
    Product p2 = new Product("P02", "Benih Jagung", 25000.0, 20);
    
    // Aksi
    cartService.addToCart(p1, 2); // 100.000
    cartService.addToCart(p2, 1); // 25.000
    
    // Verifikasi hasil harus 125.000
    assertEquals(125000.0, cartService.getTotalPrice(), "Total harga harus sesuai");
}

---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/week14_main%20program.png)
![Screenshot hasil](screenshots/Week14_test.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan. 

   Aplikasi dimulai dari AppJavaFX.java yang memanggil PosController untuk menampilkan antarmuka pengguna berbasis grafis.

   Saat pengguna berinteraksi dengan menu, PosController meneruskan instruksi ke CartService yang mengelola logika perhitungan belanja secara internal.

   CartService memproses penambahan, penghapusan, dan kalkulasi total harga dengan memanipulasi objek CartItem dan Product.

   Seluruh logika ini divalidasi secara otomatis melalui CartServiceTest menggunakan JUnit, di mana Maven akan membandingkan hasil aktual dari kode dengan nilai yang diharapkan (Expected Result).
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  

   Modularitas Terintegrasi: Jika minggu sebelumnya fokus pada pembuatan class secara terpisah, minggu ini seluruh lapisan (DAO, Service, dan UI) sudah saling terhubung (integrasi).

   Pengujian Otomatis: Pengujian tidak lagi dilakukan secara manual melalui System.out.println di method main, melainkan menggunakan Unit Testing yang dapat dijalankan sekaligus melalui perintah Maven.

   Penerapan Arsitektur: Penggunaan pola MVC menjadi lebih nyata dengan adanya pemisahan yang jelas antara kode tampilan (JavaFX) dan kode logika (Service).

- Kendala yang dihadapi dan cara mengatasinya.  

   Kendala Output Terminal: Saat menjalankan perintah mvn test, rincian jumlah tes terkadang tidak muncul di terminal karena Maven mendeteksi tidak ada perubahan pada file yang sudah dikompilasi sebelumnya.

   Solusi: Menggunakan perintah mvn clean test untuk menghapus folder target terlebih dahulu. Hal ini memaksa Maven untuk melakukan kompilasi ulang dan mencetak laporan pengujian secara lengkap hingga muncul status Tests run: 10.

   Kendala Konfigurasi: Terjadi kesalahan penulisan opsi perintah (command line options) di terminal.

   Solusi: Melakukan pengecekan ulang pada sintaks perintah Maven dan memastikan path menuju file pom.xml sudah benar sesuai lokasi folder praktikum.
)
---

## Kesimpulan
Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa integrasi antara antarmuka grafis (JavaFX) dan logika bisnis (Service) membuat aplikasi Agri-POS menjadi lebih fungsional dan interaktif. Penerapan pengujian unit otomatis menggunakan JUnit sangat efektif untuk memastikan kualitas kode, terbukti dengan keberhasilan menjalankan 10 skenario tes dengan status BUILD SUCCESS. Secara keseluruhan, pendekatan arsitektur berlapis dan pengujian otomatis ini membuat program menjadi lebih terstruktur, minim kesalahan (bug), dan lebih mudah untuk dikembangkan di masa mendatang.

---


