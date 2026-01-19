# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Implementasi Database Persistence dengan JDBC dan DAO Pattern]

## Identitas
- Nama  : [Hilda Sava Alzena]
- NIM   : [240202865]
- Kelas : [3ikra]

---

## Tujuan:
Koneksi Database: Mahasiswa mampu mengonfigurasi dan menghubungkan aplikasi Java dengan sistem manajemen basis data PostgreSQL menggunakan driver JDBC.

Implementasi DAO Pattern: Mahasiswa dapat menerapkan Data Access Object (DAO) pattern untuk memisahkan logika akses data dari logika bisnis program.

Operasi CRUD: Mahasiswa mampu menyusun instruksi SQL (INSERT, SELECT, UPDATE, DELETE) di dalam kode Java untuk memanipulasi data pada tabel database.

Manajemen Persistence: Mahasiswa memahami cara menyimpan data secara permanen (persistence) sehingga data tetap ada meskipun aplikasi dihentikan.

Version Control: Mahasiswa mampu mendokumentasikan dan mengunggah kode sumber proyek ke dalam repository GitHub sebagai bagian dari manajemen proyek perangkat lunak.

---

## Dasar Teori
1. JDBC (Java Database Connectivity): Merupakan API standar dari Java yang memungkinkan aplikasi untuk terhubung dan berinteraksi dengan berbagai sistem manajemen basis data relasional seperti PostgreSQL.

2. DAO (Data Access Object) Pattern: Sebuah desain pola yang digunakan untuk memisahkan logika akses data (seperti query SQL) dari logika bisnis aplikasi, sehingga kode lebih terorganisir dan mudah dipelihara.

3. Data Persistence: Konsep penyimpanan data ke dalam media penyimpanan permanen (seperti database), sehingga data tetap tersimpan dan tidak hilang meskipun program atau aplikasi dihentikan.

4. CRUD (Create, Read, Update, Delete): Empat fungsi dasar dalam pengelolaan data pada database, yang dalam Java diimplementasikan menggunakan perintah SQL seperti INSERT, SELECT, UPDATE, dan DELETE melalui objek PreparedStatement.

5. JDBC Driver: Library khusus (dalam hal ini driver PostgreSQL) yang berfungsi sebagai jembatan komunikasi antara aplikasi Java dengan server database agar instruksi Java dapat dipahami oleh database.

---

## Langkah Praktikum
1. Persiapan dan Setup

   Mengunduh dan menambahkan library postgresql-42.x.x.jar (JDBC Driver) ke dalam proyek Java di VS Code agar aplikasi dapat berkomunikasi dengan database.

   Membuka pgAdmin 4, membuat database baru bernama agripos, dan menjalankan query SQL untuk membuat tabel products dengan kolom id, name, price, dan stock.

2. Implementasi Kode (Coding)

   Membuat class model Product.java untuk merepresentasikan entitas data produk.

   Membuat interface ProductDAO.java untuk mendefinisikan kontrak operasi CRUD (Create, Read, Update, Delete).

   Mengimplementasikan logika koneksi database dan query SQL pada class ProductDAOImpl.java menggunakan DriverManager dan PreparedStatement.

   Membuat class MainDAOTest.java untuk menguji fungsionalitas penambahan, pembaruan, dan pencarian data produk.

3. Eksekusi dan Pengujian (Run)

   Menjalankan program melalui VS Code dengan menekan tombol Run pada file MainDAOTest.java.

   Memastikan terminal menampilkan pesan "Koneksi berhasil" dan "Produk berhasil ditambahkan" serta menampilkan identitas (credit by Hilda - 240202865).

   Melakukan verifikasi data di pgAdmin melalui fitur View/Edit Data > All Rows untuk memastikan data dari Java telah masuk ke tabel database.

4. Manajemen Versi (Git & GitHub)

   Melakukan inisialisasi Git menggunakan perintah git init dan memantau perubahan file dengan git add ..

   Menyimpan perubahan dengan perintah git commit -m "Tugas Praktikum OOP Database - Hilda".

   Menghubungkan folder lokal ke repository GitHub dengan git remote add origin dan mengunggahnya menggunakan git push -u origin main.

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
1. Penjelasan Alur Kode

   Program dimulai dengan memuat driver JDBC PostgreSQL untuk membuka jalur komunikasi antara Java dan database server.

   Class ProductDAOImpl menggunakan objek Connection untuk menghubungkan aplikasi ke database agripos di localhost:5432.

   Data produk dikirim dari Java ke database menggunakan PreparedStatement, yang secara otomatis menyusun perintah SQL seperti INSERT atau UPDATE dengan parameter yang aman.

   Setelah perintah dieksekusi, database memberikan respon balik yang ditangkap oleh program untuk menampilkan pesan sukses di terminal.

2. Perbedaan Pendekatan dengan Minggu Sebelumnya

   Data Persistence: Pada minggu sebelumnya, data hanya tersimpan di dalam memori (RAM) sehingga hilang saat program dimatikan, sedangkan minggu ini data tersimpan permanen di dalam PostgreSQL.

   Arsitektur DAO: Minggu ini mulai menggunakan Data Access Object (DAO) pattern, yang memisahkan antara class model (data) dengan class logika database (query), membuat kode lebih modular dibanding pendekatan satu class besar di minggu lalu.

   Penggunaan Library Eksternal: Praktikum kali ini melibatkan penggunaan library pihak ketiga (.jar driver) yang harus ditambahkan ke dalam classpath proyek.

3. Kendala yang Dihadapi dan Solusi

   Kendala: Tabel Tidak Ditemukan: Terjadi error karena mencoba menjalankan program Java sebelum tabel products dibuat di pgAdmin. Solusi: Membuat tabel secara manual melalui Query Tool di pgAdmin menggunakan perintah CREATE TABLE.

   Kendala: Konflik Repository GitHub: Terjadi error rejected saat melakukan push karena adanya file README.md di GitHub yang tidak ada di folder lokal. Solusi: Menggunakan perintah git push -f (force push) untuk menyinkronkan folder lokal dengan repository.

   Kendala: Salah Link Repository: Terjadi error Repository not found karena kesalahan penulisan username GitHub. Solusi: Mengoreksi URL remote menggunakan perintah git remote set-url origin dengan username yang benar (hildasava).
---

## Kesimpulan
Struktur Rapi: Penerapan DAO Pattern membuat kode program lebih terorganisir karena memisahkan kodingan Java dengan query database.

Data Aman: Dengan JDBC, data kini tersimpan permanen di PostgreSQL dan tidak hilang saat aplikasi ditutup.

Integrasi Sukses: Keberhasilan koneksi hingga ke GitHub membuktikan aplikasi sudah memenuhi standar praktikum pengembangan perangkat lunak yang baik.

---


