# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: ["Exception Handling, Custom Exception, dan Penerapan Design Pattern"]

## Identitas
- Nama  : [Hilda Sava Alzena]
- NIM   : [240202865]
- Kelas : [3IKRA]

---

## Tujuan
Memahami perbedaan antara Error dan Exception.

Mengimplementasikan penanganan kesalahan menggunakan blok try–catch–finally.

Membuat Custom Exception untuk validasi logika bisnis pada sistem keranjang belanja.

Menerapkan dasar Design Pattern seperti Singleton dan konsep MVC.

---

## Dasar Teori
1. Error vs Exception: Error adalah gangguan fatal pada sistem yang tidak dapat ditangani oleh kode (contoh: memori penuh), sedangkan Exception adalah kondisi tidak normal yang dapat diantisipasi dan ditangani agar program tidak berhenti tiba-tiba.

2. Try–Catch–Finally: Mekanisme penanganan kesalahan di mana try membungkus kode berisiko, catch menangani jenis kesalahan tertentu, dan finally memastikan blok kode tetap dijalankan baik saat terjadi kesalahan maupun tidak.

3. Custom Exception: Kelas pengecualian buatan sendiri yang mewarisi kelas Exception, bertujuan untuk memberikan pesan kesalahan yang spesifik dan relevan dengan logika bisnis aplikasi (seperti validasi stok).

4. Singleton Pattern: Sebuah design pattern yang menjamin suatu kelas hanya memiliki satu instansi (instance) tunggal di seluruh siklus hidup aplikasi, biasanya digunakan untuk layanan atau konfigurasi terpusat.

5. Model-View-Controller (MVC): Pola arsitektur yang memisahkan data (Model), tampilan (View), dan logika pemrosesan (Controller) untuk membuat struktur kode lebih rapi dan mudah dikelola.
---

## Langkah Praktikum
1. Persiapan & Setup (Setup):

   Membuka folder kerja oop-202501-240202865 di VS Code.

   Memastikan struktur package sudah sesuai di bawah folder com/upb/agripos.

2. Pembuatan Kode (Coding):

   Custom Exceptions: Membuat file InvalidQuantityException.java, ProductNotFoundException.java, dan InsufficientStockException.java untuk menangani error spesifik bisnis.

   Model & Logic: Mengupdate file Product.java dengan atribut stok dan membuat ShoppingCart.java yang menggunakan Map serta throws exception.

   Main Program: Membuat MainExceptionDemo.java untuk menguji skenario error menggunakan blok try–catch.

3. Eksekusi (Run):

   Melakukan kompilasi file Java menggunakan perintah javac com/upb/agripos/*.java di terminal.

   Menjalankan program dengan perintah java com.upb.agripos.MainExceptionDemo dan mendokumentasikan pesan kesalahan yang muncul.

4. Pengiriman ke GitHub (Git Commit & Push):

   Menyimpan seluruh perubahan dengan git add ..

   Melakukan commit dengan pesan khusus: week9-exception: [fitur] [deskripsi singkat].

   Mengirimkan kode ke repositori online menggunakan perintah git push origin main.
---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
(
   
1. Cara Kerja: Program memvalidasi input; jika salah, program melempar (throw)   exception untuk ditangkap tanpa membuat aplikasi berhenti paksa.

2. Perbedaan: Sebelumnya menggunakan if-else sederhana, sekarang menggunakan     Exception Handling yang lebih terstruktur dan profesional.

3. Kendala: Adanya file index.lock pada Git yang sempat menghambat proses push, diatasi dengan menghapus file tersebut secara manual.

## Kesimpulan

Penanganan Kesalahan: Penggunaan Exception Handling (try-catch-finally) terbukti lebih efektif daripada if-else biasa karena dapat memisahkan logika utama program dengan logika penanganan kesalahan.

Validasi Spesifik: Custom Exception memungkinkan pembuatan pesan error yang lebih informatif dan relevan dengan kasus bisnis Agri-POS, seperti pengecekan stok dan validasi jumlah belanja.

Keamanan Program: Dengan menangkap exception, program tetap dapat berjalan meskipun terjadi kesalahan input, sehingga meningkatkan pengalaman pengguna dan mencegah aplikasi berhenti mendadak (crash).

Manajemen Proyek: Penggunaan Git sangat krusial dalam pendokumentasian tugas, di mana kendala teknis seperti file index.lock dapat diatasi dengan pembersihan proses pada sistem operasi.

---

## Quiz
(1). Perbedaan Error dan Exception
      Error: Merupakan kondisi fatal yang biasanya berasal dari luar kendali program atau sistem, sehingga tidak disarankan untuk ditangani (contoh: OutOfMemoryError atau masalah pada JVM).

      Exception: Adalah kondisi tidak normal yang muncul saat program berjalan namun masih dapat diantisipasi dan ditangani agar program tidak berhenti tiba-tiba.
(2) Fungsi finally dalam Blok try-catch-finally
      Blok finally adalah bagian dari struktur penanganan kesalahan yang selalu dijalankan oleh program.

      Perintah di dalamnya tetap akan dieksekusi, baik saat terjadi kesalahan (exception) maupun saat kode berjalan normal tanpa kendala.
(3). Mengapa Custom Exception Diperlukan?
      Pesan Spesifik: Digunakan untuk memberikan pesan kesalahan yang lebih informatif dan relevan dengan kebutuhan spesifik program.

      Validasi Bisnis: Mempermudah proses debugging dan penanganan logika bisnis yang tidak tercakup dalam exception standar Java (contoh: validasi stok atau jumlah belanja).
(4). Contoh Kasus Bisnis dalam POS
      Beberapa kasus dalam sistem Point of Sale (POS) yang memerlukan custom exception meliputi:

      Validasi Jumlah: Muncul kesalahan jika jumlah barang yang dimasukkan kurang dari atau sama dengan nol (InvalidQuantityException).

      Pengecekan Stok: Muncul kesalahan saat stok barang di gudang tidak mencukupi untuk memenuhi permintaan belanja (InsufficientStockException).

      Pencarian Produk: Muncul kesalahan jika kode barang yang dimasukkan tidak ditemukan dalam sistem keranjang belanja (ProductNotFoundException).