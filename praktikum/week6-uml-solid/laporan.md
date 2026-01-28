# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Desain Arsitektur Sistem dengan UML dan Prinsip SOLID]

## Identitas
- Nama  : [Hilda sava Alzena]
- NIM   : [240202865]
- Kelas : [3ikra]

---

## Tujuan
1. Mahasiswa mampu mengidentifikasi kebutuhan sistem ke dalam diagram UML.

2. Mahasiswa mampu menggambar UML Class Diagram dengan relasi antar class yang tepat.

3. Mahasiswa mampu menjelaskan prinsip desain OOP (SOLID).

4. Mahasiswa mampu menerapkan minimal dua prinsip SOLID dalam kode/desain program.
---

## Dasar Teori
   1. UML (Unified Modeling Language): Standar bahasa pemodelan untuk memvisualisasikan struktur dan perilaku sistem, mencakup Use Case, Activity, Sequence, dan Class Diagram.

   2. SOLID Principle: Lima prinsip desain kelas dalam OOP agar sistem lebih mudah dipelihara dan dikembangkan.

   3. Single Responsibility Principle (SRP): Sebuah kelas harus memiliki satu, dan hanya satu, alasan untuk berubah.

   4. Open/Closed Principle (OCP): Entitas perangkat lunak harus terbuka untuk ekstensi, tetapi tertutup untuk modifikasi.

   5. Dependency Inversion Principle (DIP): Bergantung pada abstraksi (interface), bukan pada implementasi konkret.
---

## Langkah Praktikum
1. Analisis Kebutuhan: Memetakan aktor (Admin dan Kasir) serta fungsionalitas utama seperti manajemen produk dan transaksi penjualan.

2. Perancangan Use Case: Menggambarkan hubungan aktor dengan fungsionalitas sistem.

3. Detail Alur Kerja: Menyusun Activity Diagram untuk proses Checkout dan Sequence Diagram untuk interaksi pembayaran (Tunai vs E-Wallet).

4. Desain Struktur Kelas: Membuat Class Diagram dengan menerapkan Strategy Pattern untuk memenuhi prinsip SOLID.

5. Dokumentasi: Menyusun laporan praktikum dan tabel traceability.
---


## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/uml%20activity.png)
 [Screenshot hasil](screenshots/uml%20class%20diagram.jpeg)
 [Screenshot hasil](screenshots/uml%20sequence%20diagram.png)
 [Screenshot hasil](screenshots/uml%20usecase%20diagram.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan. 
  Jawab:
  Kode berjalan dengan memisahkan logika transaksi (POS) dari logika pembayaran (PaymentService). Kasir memilih metode pembayaran yang kemudian dieksekusi melalui antarmuka PaymentStrategy.

- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya. 
  jawab:
  Berbeda dengan minggu sebelumnya yang fokus pada objek dasar, minggu ini menggunakan interface dan abstraksi untuk memastikan kode bersifat extensible (mudah ditambah metode bayar baru tanpa mengubah kode lama).

- Kendala yang dihadapi dan cara mengatasinya. 
  Jawab:
  Mengatur logika saldo tidak cukup pada Sequence Diagram. Solusinya adalah menggunakan blok fragmen alt untuk membedakan skenario sukses dan gagal. 
)
---

## Kesimpulan
Penerapan UML dan prinsip SOLID pada sistem Agri-POS menghasilkan arsitektur yang modular dan terorganisir. Hal ini memastikan sistem mudah diuji (testability) dan dikembangkan di masa depan (maintainability).
---

## Quiz
(1. [Jelaskan perbedaan aggregation dan composition serta berikan contoh penerapannya pada desain Anda.]  
   **Jawaban:** …  
   1. Aggregation (Agregasi): Relasi "memiliki" yang lemah. Objek bagian tetap bisa ada meskipun induknya dihapus.

      -Contoh di Agri-POS: Relasi antara Kategori dan Produk. Jika kategori "Pupuk" dihapus, data "Pupuk Urea" tetap ada di sistem.

   2. Composition (Komposisi): Relasi "memiliki" yang kuat. Objek bagian otomatis terhapus jika induknya dihapus.

      -Contoh di Agri-POS: Relasi antara Cart (Keranjang) dan Item. Jika keranjang dihapus, maka daftar item di dalamnya ikut hilang karena tidak bisa berdiri sendiri.

2. [Bagaimana prinsip Open/Closed dapat memastikan sistem mudah dikembangkan?]  
   **Jawaban:** …    

   1. Terbuka untuk Ekstensi (Open for Extension): Kita bisa menambah fungsionalitas baru hanya dengan membuat kelas baru yang mengimplementasikan antarmuka (interface).

      -Contoh: Jika ingin menambah metode pembayaran "QRIS", kita cukup membuat kelas QRISPayment tanpa mengubah kode di kelas transaksi yang sudah ada.

   2. Tertutup untuk Modifikasi (Closed for Modification): Kode inti yang sudah diuji dan berjalan tidak perlu diubah-ubah lagi saat ada fitur baru.

      -Manfaat: Hal ini mencegah munculnya kutu (bug) baru pada fitur lama yang sebelumnya sudah stabil.

3. [Mengapa Dependency Inversion Principle (DIP) meningkatkan testability? Berikan contoh penerapannya.]  
   **Jawaban:** 
   Mengapa Meningkatkan Testability?
    1. Penggunaan Mock/Stub: Karena kelas bergantung pada antarmuka (interface), kita bisa mengganti objek asli dengan objek "palsu" atau mock saat pengujian.

    2. Isolasi Pengujian: Kita bisa mengetes logika bisnis tanpa harus terhubung ke database asli atau koneksi internet, sehingga proses tes menjadi jauh lebih cepat dan stabil.

    3. Fleksibilitas: Kita dapat mensimulasikan berbagai skenario (seperti kegagalan jaringan atau saldo habis) dengan mudah melalui objek abstraksi tersebut.

   Contoh Penerapan di Agri-POS
   1. Pada desain Anda, PaymentService tidak bergantung langsung pada kelas EWalletPayment, melainkan pada interface PaymentStrategy.

   2. Saat Produksi: PaymentService akan menggunakan EWalletPayment asli yang memotong saldo pengguna secara nyata.

   3. Saat Testing: Kita bisa membuat kelas MockPayment yang selalu mengembalikan nilai true (sukses) atau false (gagal) tanpa perlu melakukan transaksi uang sungguhan.
   
   
   )
