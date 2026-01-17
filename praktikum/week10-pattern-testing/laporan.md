# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Pattern Testing (Model-View-Controller)]

## Identitas
- Nama  : [Hilda Sava Alzena]
- NIM   : [240202865]
- Kelas : [3IKRA]

---

## Tujuan
   1. Mengimplementasikan pola desain Model-View-Controller (MVC) untuk memisahkan logika data, antarmuka, dan kontrol program.

   2. Melakukan manajemen proyek dan otomatisasi pengujian menggunakan Maven.

   3. Melakukan unit testing menggunakan library JUnit untuk memastikan kebenaran logika kode secara otomatis.

---

## Dasar Teori
1. Pola Desain MVC (Model-View-Controller): Sebuah pola arsitektur perangkat lunak yang memisahkan aplikasi menjadi tiga komponen utama untuk mempermudah pengelolaan kode: Model (data), View (tampilan), dan Controller (logika penghubung).

2. Maven Build Tool: Sebuah perangkat lunak manajemen proyek yang digunakan untuk mengotomatisasi proses pembangunan aplikasi (build), mengelola dependencies (library luar), dan menjalankan pengujian secara konsisten.

3. Unit Testing dengan JUnit: Sebuah framework pengujian untuk bahasa pemrograman Java yang bertujuan untuk menguji kebenaran fungsionalitas unit terkecil dari kode (seperti method atau class) secara terisolasi.

4. Automated Testing: Proses pengujian perangkat lunak menggunakan skrip atau alat otomatis (seperti perintah mvn test) untuk memverifikasi bahwa kode baru tidak merusak fitur yang sudah ada (regression).

5. Dependency Management: Mekanisme dalam Maven (melalui file pom.xml) untuk mengunduh dan mengatur library pihak ketiga yang dibutuhkan proyek agar proyek dapat berjalan di lingkungan yang berbeda tanpa error "missing library".

---

## Langkah Praktikum
1. Setup dan Konfigurasi Proyek
   Membuka folder proyek week10-pattern-testing menggunakan editor VS Code.

   Melakukan konfigurasi pada file pom.xml dengan menambahkan dependency JUnit 4.13.2 agar fitur pengujian otomatis dapat dijalankan oleh Maven.

   Memastikan struktur folder mengikuti standar Maven, yaitu menempatkan kode program di src/main/java dan kode pengujian di src/test/java.

2. Implementasi Kode (Coding)
   Membuat Model: Mengimplementasikan class Product.java di package model dengan atribut name (String) dan price (double).

   Membuat Controller: Mengimplementasikan class ProductController.java untuk menangani logika pemrosesan dan menampilkan data ke konsol.

   Membuat Configuration: Mengimplementasikan class DatabaseConnection.java di package config untuk mensimulasikan proses koneksi database.

   Membuat View (Main): Mengimplementasikan class AppMVC.java sebagai titik masuk aplikasi yang menampilkan identitas mahasiswa (Hilda Sava Alzena - 240202865), menginisialisasi koneksi, dan menampilkan produk.

   Membuat Unit Test: Mengimplementasikan class ProductTest.java untuk menguji apakah fungsi getter pada model Product berjalan dengan benar.

3. Eksekusi dan Pengujian (Run)
   Menjalankan Unit Testing: Mengeksekusi perintah mvn clean test melalui terminal untuk memastikan seluruh kode terkompilasi dengan benar dan lulus uji JUnit.

   Menjalankan Aplikasi: Mengeksekusi class AppMVC.java secara langsung (Running) untuk melihat output program pada terminal, termasuk pesan "Terhubung ke database...".

4. Manajemen Versi (Commit Messages)
   Berikut adalah pesan commit yang digunakan dalam proses pengembangan ini:

   feat: initial project setup with maven and junit dependency

   feat: implement mvc pattern for product management

   fix: resolve compilation error and data type mismatch in product model

   test: add unit test for product getters

   docs: finalize output with student identity and database connection status
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
1. Cara Kerja Kode
   Program dimulai dari AppMVC.java sebagai entry point, di mana identitas mahasiswa dicetak terlebih dahulu ke konsol.

   Program kemudian menginisialisasi DatabaseConnection, yang mensimulasikan koneksi ke basis data sebelum memproses data produk.

   Objek dari class Product (Model) dibuat untuk menyimpan data "Beras" dan harga "10000.0".

   Data tersebut kemudian dikirim ke ProductController (Controller) untuk diproses dan ditampilkan menggunakan perintah display(), sehingga memisahkan data dari logika tampilan.

   Seluruh alur ini divalidasi oleh ProductTest.java melalui Maven, yang memastikan bahwa data yang disimpan di Model bisa diambil kembali dengan benar menggunakan JUnit.

2. Perbedaan Pendekatan dengan Minggu Sebelumnya
   Penerapan Pola MVC: Berbeda dengan minggu sebelumnya yang mungkin menggabungkan semua logika dalam satu class, minggu ini kode dipisah secara modular menjadi Model, View, dan Controller.

   Otomatisasi Build: Penggunaan Maven menggantikan kompilasi manual. Maven secara otomatis mengatur classpath dan library yang dibutuhkan melalui file pom.xml.

   Pengujian Berbasis Test-Driven: Minggu ini memperkenalkan Unit Testing, di mana keberhasilan kode tidak hanya dilihat dari hasil running manual, tetapi juga dari status BUILD SUCCESS pada pengujian otomatis.

3. Kendala dan Solusi
   Kendala 1 (Compilation Failure): Terjadi error cannot find symbol karena class ConsoleView dipanggil namun filenya tidak tersedia, serta ketidakcocokan tipe data (String ke double) pada atribut harga.

   Solusi: Menyederhanakan kode dengan menghapus ketergantungan pada ConsoleView dan memastikan input harga pada constructor Product menggunakan format angka desimal (double) tanpa tanda kutip.

   Kendala 2 (Missing Dependencies): Muncul error package org.junit does not exist saat menjalankan perintah Maven.

   Solusi: Melakukan konfigurasi ulang pada file pom.xml dengan menambahkan blok <dependency> untuk JUnit 4.13.2, sehingga Maven dapat mengunduh library tersebut dari central repository.

   Kendala 3 (Command Error): Kesalahan penulisan perintah mvn exec:java di terminal yang menyebabkan error Unknown lifecycle phase.

   Solusi: Memperbaiki sintaks perintah dengan menambahkan tanda kutip pada parameter -Dexec.mainClass atau menggunakan fitur tombol Run bawaan VS Code untuk eksekusi yang lebih stabil.

## Kesimpulan
Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa:

Penerapan Pola MVC membuat struktur program menjadi jauh lebih rapi, modular, dan mudah dipelihara karena adanya pemisahan yang jelas antara data (Model), tampilan (View), dan logika kontrol (Controller).

Penggunaan Maven sangat efektif dalam mengelola proyek berskala besar, terutama dalam menangani dependencies library pihak ketiga seperti JUnit secara otomatis tanpa perlu mengunduh file .jar secara manual.

Unit Testing dengan JUnit memberikan jaminan kualitas kode yang lebih tinggi; dengan adanya status BUILD SUCCESS, pengembang dapat memastikan bahwa perubahan kode tidak merusak fungsi dasar yang sudah ada.

Integrasi Identitas Mahasiswa dan log koneksi database dalam output program membuktikan bahwa aplikasi tidak hanya lulus uji teknis (testing), tetapi juga mampu beroperasi dengan benar sesuai dengan alur bisnis yang diinginkan.

---

## Quiz
(1. [Mengapa Constructor Singleton harus Private?]  
   **Jawaban:**
   Constructor pada pattern Singleton wajib bersifat private untuk mencegah class lain membuat objek (instansiasi) baru secara bebas menggunakan kata kunci new.

   Kontrol Tunggal: Dengan private constructor, kita memastikan hanya ada satu instansi yang dibuat di dalam class itu sendiri.

   Akses Terpusat: Objek hanya bisa diakses melalui satu pintu utama (biasanya method getInstance()), sehingga seluruh aplikasi menggunakan data yang sama persis.

2. [elaskan manfaat pemisahan Model, View, dan Controller]  
   **Jawaban:**
   Pemisahan ini bertujuan untuk menciptakan kode yang modular dan terorganisir:

   Reusability: Model (data) yang sama bisa digunakan untuk View yang berbeda (misalnya tampilan di konsol dan tampilan di aplikasi mobile) tanpa mengubah logika data.

   Kemudahan Maintenance: Jika kamu ingin mengubah desain tampilan (View), kamu tidak perlu menyentuh kode database (Model), sehingga risiko error lebih kecil.

   Parallel Development: Tim pengembang bisa bekerja secara bersamaan; satu orang fokus pada desain View, sementara yang lain fokus pada logika di Controller.

3. [Apa peran unit testing dalam menjaga kualitas perangkat lunak?]  
   **Jawaban:**
   Unit testing, seperti yang kita lakukan dengan JUnit, sangat penting karena:

   Deteksi Dini: Error bisa ditemukan segera setelah kode ditulis, bukan saat aplikasi sudah di tangan pengguna.

   Keamanan Refactoring: Saat kamu mengubah atau merapikan kode, kamu cukup menjalankan tes kembali (seperti mvn test). Jika hasilnya tetap BUILD SUCCESS, berarti perubahanmu tidak merusak fitur lama.

   Dokumentasi Hidup: Tes memberikan gambaran jelas tentang bagaimana sebuah unit kode (method/class) seharusnya bekerja.

4. [Apa risiko jika Singleton tidak diimplementasikan dengan benar?]  
   **Jawaban:**
   Jika Singleton gagal menjaga "satu objek untuk satu aplikasi", dampaknya bisa serius:

   Inkonsistensi Data: Misalnya pada koneksi database; jika tercipta dua objek koneksi yang berbeda secara tidak sengaja, data yang disimpan bisa jadi tidak sinkron atau konflik.

   Pemborosan Memori (Memory Leak): Objek yang seharusnya hanya satu malah terus bertambah setiap kali dipanggil, yang akhirnya membebani performa perangkat.

   Masalah Multi-threading: Jika dua perintah memanggil Singleton di waktu yang sama persis tanpa pengamanan (thread-safe), aplikasi bisa crash atau menghasilkan data yang rusak.
