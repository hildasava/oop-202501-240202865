# Laporan Praktikum WEEK 7
Topik: [Implementasi Java Collection Framework dan Logika Keranjang Belanja]

## Identitas
- Nama  : [Hilda Sava Alzena]
- NIM   : [240202865]
- Kelas : [3IKRA]

---

## Tujuan
Mahasiswa mampu mengimplementasikan konsep Collection (ArrayList) untuk mengelola data dinamis dalam aplikasi Agri-POS, serta memahami cara menerapkan logika bisnis seperti menambah, menghapus, dan menghitung total harga objek di dalam keranjang belanja.

---

## Dasar Teori
1. Collection (ArrayList): Wadah yang digunakan untuk menyimpan sekumpulan objek dengan ukuran yang dinamis (bisa bertambah atau berkurang secara otomatis).

2. Generic Type: Penggunaan tanda <Product> pada List yang berfungsi untuk memastikan bahwa hanya objek dari class Product saja yang bisa dimasukkan ke dalam keranjang.

3. Iterasi (Looping): Proses menelusuri setiap elemen di dalam koleksi (misalnya menggunakan for-each) untuk menjalankan logika tertentu seperti menghitung total harga.

4. Logika Bisnis (Business Logic): Implementasi aturan aplikasi di dalam class, seperti validasi stok saat menambah produk atau pembersihan data setelah transaksi selesai.
---

## Langkah Praktikum
1. Persiapan Struktur Folder (Setup)
   Membuka folder kerja praktikum di VS Code: praktikum/week7-koleksi-keranjang/.

   Memastikan struktur folder paket (package) sudah benar, yaitu berada di dalam src/main/java/com/upb/agripos/.

2. Pembuatan Kode Program (Coding)
   Membuat Model Data: Menulis kode di Product.java untuk mendefinisikan atribut produk seperti nama dan harga dengan akses private (Enkapsulasi).

   Implementasi Koleksi: Membuat class ShoppingCart.java. Di sini, saya menginisialisasi ArrayList<Product> untuk menampung banyak objek produk sekaligus.

   Logika Bisnis: Menambahkan method addProduct() untuk memasukkan data ke list dan calculateTotal() yang menggunakan perulangan (looping) untuk menjumlahkan harga semua barang.

3. Kompilasi dan Pengujian (Run)
   Membuka terminal PowerShell di VS Code.

   Kompilasi: Menjalankan perintah javac com/upb/agripos/*.java untuk memastikan tidak ada syntax error.

   Eksekusi: Menjalankan program utama dengan perintah java com.upb.agripos.Main.

   Verifikasi: Memastikan output di terminal menampilkan daftar produk yang dibeli dan total harga yang tepat.

4. Sinkronisasi ke GitHub (Version Control)
   Status Check: Menjalankan git status untuk melihat perubahan file.

   Staging: Menjalankan git add . untuk menandai semua perubahan di folder Week 7.

   Commit: Menyimpan perubahan ke database lokal dengan perintah: git commit -m "week7-koleksi-keranjang: implementasi collection dan logic keranjang"

   Pull & Rebase: Menjalankan git pull origin main --rebase untuk menyamakan versi laptop dengan versi GitHub agar tidak terjadi konflik.

   Push: Mengunggah hasil kerja ke GitHub dengan perintah git push origin main.

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
   
1. Cara Kode Berjalan
   Program bekerja dengan alur sebagai berikut:

   Pertama, program membuat beberapa objek dari class Product (misalnya: Pupuk, Benih) yang masing-masing memiliki data harga dan stok.

   Objek-objek tersebut dimasukkan ke dalam objek ShoppingCart melalui method addProduct(). Di dalam class ini, produk disimpan dalam sebuah ArrayList.

   Saat method calculateTotal() dipanggil, program melakukan iterasi (looping) menggunakan for-each. Program "mengintip" satu per satu harga produk di dalam list, lalu menjumlahkannya ke dalam variabel total hingga semua item selesai dihitung.

   Terakhir, total harga ditampilkan ke layar terminal.

2. Perbedaan Pendekatan dengan Minggu Sebelumnya
   Dinamis vs Statis: Pada minggu-minggu awal, kita menggunakan variabel biasa atau Array statis yang ukurannya terbatas. Minggu ini, kita menggunakan ArrayList yang jauh lebih fleksibel karena ukurannya bisa bertambah secara otomatis mengikuti jumlah belanjaan user.

   Manajemen Objek: Minggu ini lebih fokus pada koleksi objek. Kita belajar bahwa satu objek (ShoppingCart) bisa menampung banyak objek lain (Product), yang merupakan penerapan dari konsep relasi antar class dalam OOP.

3. Kendala yang Dihadapi dan Solusi
   Kendala 1 (Syntax): Terjadi error saat kompilasi karena kurangnya kurung kurawal tutup } dan kesalahan penulisan nama file yang tidak sesuai dengan nama class (Case Sensitive).

   Solusi: Melakukan pengecekan ulang kode program dan memastikan nama file diawali huruf besar sesuai standar Java.

   Kendala 2 (Git Conflict): Terjadi error [rejected] saat melakukan git push karena data di laptop tertinggal dari data di server GitHub.

   Solusi: Menggunakan perintah git pull origin main --rebase untuk menyelaraskan data terlebih dahulu, baru kemudian melakukan push kembali.
---

## Kesimpulan
Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa penggunaan ArrayList dalam pengembangan aplikasi Agri-POS memberikan fleksibilitas yang jauh lebih tinggi dibandingkan array konvensional karena kemampuannya dalam mengelola data secara dinamis. Dengan memanfaatkan konsep koleksi objek, struktur kode program menjadi lebih rapi dan terorganisir, di mana logika perhitungan total belanja dapat dipisahkan secara modular di dalam class ShoppingCart. Selain itu, penggunaan generic type pada list memastikan keamanan tipe data sehingga program lebih stabil dari potensi error. Secara keseluruhan, pemahaman mengenai manajemen koleksi dan penggunaan Git untuk sinkronisasi kode sangat krusial dalam membangun aplikasi yang skalabel dan terkelola dengan baik di GitHub.

---

## Quiz
(1. [Jelaskan perbedaan mendasar antara List, Map, dan Set.]  
   Secara sederhana, perbedaannya terletak pada cara mereka menyimpan data:

   List: Seperti antrean. Data disimpan berurutan berdasarkan urutan masuk (index). List memperbolehkan data yang sama (duplikat). Contoh: [Apel, Jeruk, Apel].

   Set: Seperti kantung kelereng. Data di dalamnya tidak boleh ada yang sama (unik) dan tidak menjamin urutan. Contoh: [Apel, Jeruk]. Jika kamu masukkan "Apel" lagi, dia akan menolak.

   Map: Seperti kamus atau loker. Data disimpan berpasangan antara Key (Kunci) dan Value (Isi). Untuk mengambil isi, kamu harus tahu kuncinya. Contoh: {"A1": "Apel", "B2": "Jeruk"}. 

2. [Mengapa ArrayList cocok digunakan untuk keranjang belanja    sederhana?]  
   ArrayList adalah pilihan terbaik untuk keranjang belanja sederhana karena:

   Fleksibel: Kita tidak tahu pembeli mau beli berapa barang. ArrayList bisa membesar sendiri saat kita tambah barang pakai .add().

   Urutan Jelas: Barang yang pertama kali dimasukkan akan muncul di urutan pertama, memudahkan user melihat daftar belanjaannya.

   Bisa Duplikat: Di keranjang belanja, user boleh beli barang yang sama lebih dari satu kali (misal: beli 2 bungkus pupuk yang sama).  

3. [TBagaimana struktur Set mencegah duplikasi data?] 

   Set (terutama HashSet) menggunakan mekanisme yang disebut Hashing:

   Setiap objek yang masuk akan dicek "sidik jarinya" (menggunakan method hashCode()).

   Jika ada objek baru dengan "sidik jari" yang sama, Set akan mengecek isinya (menggunakan method equals()).

   Jika isinya benar-benar sama, objek tersebut tidak akan dimasukkan. Jadi, Set memastikan setiap elemen di dalamnya adalah unik.

4. [Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.?] 

   Gunakan Map saat kamu butuh mencari data dengan cepat tanpa harus mengecek list satu per satu dari atas ke bawah.

   List: Cocok untuk menampilkan semua data (seperti daftar belanjaan).

   Contoh: Menampilkan semua barang yang sudah dibeli.

   Map: Cocok untuk pencarian cepat (Lookup).

   Contoh: Sistem Kasir. Saat kasir scan Barcode (Key), sistem langsung memunculkan Nama Barang (Value). Kamu tidak perlu mencari manual di ribuan data produk, cukup panggil map.get("899123...").
