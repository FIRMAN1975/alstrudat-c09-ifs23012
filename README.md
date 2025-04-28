# alstrudat-c01-ifs18005

## Description

Buatlah program untuk system Ecommers sederhana menggunakan CLI,dengan implementasi menggunakan login dan register user, dengan role berbeda , pembeli, penjual dan admin dengan masing masing fitur yang ada 

## Source Codes

| No | File       | Deskripsi                                                            |
|----|------------|----------------------------------------------------------------------|
| 1  | App.java   | runing code                                                          |
| 2  | entity     | Folder semua   konstruktor dan atribut seperti dalam class diagram   |
| 3  | model      | Folder semua proses   ide kode yang ada seperti dalam class ddiagram |
| 4  | repository | Folder semua penyimpanan sementara   seperti pada class diagram                   |
| 5  | view       | Folder tempat semua CLI yang   ada untuk user                               |

## Test Cases

| no | input      | output                                                                                                                          |
|----|------------|---------------------------------------------------------------------------------------------------------------------------------|
| 1  | 0          |                                                                                                                                 |
|    | m          | === Sistem E-Commerce   ===                                                                                                     |
|    | 1          | 1. Login                                                                                                                        |
|    | firman     | 2. Registrasi                                                                                                                   |
|    | 123        | 3. Keluar                                                                                                                       |
|    | 2          | Pilih opsi: Opsi   tidak valid. Coba lagi.                                                                                      |
|    | makan      |                                                                                                                                 |
|    | ayam       | === Sistem E-Commerce   ===                                                                                                     |
|    | 3          | 1. Login                                                                                                                        |
|    | 1          | 2. Registrasi                                                                                                                   |
|    | makan      | 3. Keluar                                                                                                                       |
|    | ayam       | Pilih opsi: Opsi   tidak valid. Coba lagi.                                                                                      |
|    | 1          |                                                                                                                                 |
|    | 2          | === Sistem E-Commerce   ===                                                                                                     |
|    | makan      | 1. Login                                                                                                                        |
|    | 3          | 2. Registrasi                                                                                                                   |
|    | makan      | 3. Keluar                                                                                                                       |
|    | 123        | Pilih opsi: Username:   Password: Error: Username atau password salah.                                                          |
|    | 6          |                                                                                                                                 |
|    | 2          | === Sistem E-Commerce   ===                                                                                                     |
|    | firman     | 1. Login                                                                                                                        |
|    | bintang    | 2. Registrasi                                                                                                                   |
|    | 2          | 3. Keluar                                                                                                                       |
|    | c          | Pilih opsi: Username:   Password: Pilih peran: 1. Pembeli 2. Penjual 3. Admin                                                   |
|    | 1          | Registrasi berhasil!   Silakan login.                                                                                           |
|    | firman     |                                                                                                                                 |
|    | bintang    | === Sistem E-Commerce   ===                                                                                                     |
|    | 1          | 1. Login                                                                                                                        |
|    | makan      | 2. Registrasi                                                                                                                   |
|    | 123        | 3. Keluar                                                                                                                       |
|    | ayamgoreng | Pilih opsi: Username:   Password: Login berhasil! Selamat datang, makan (ADMIN).                                                |
|    | 13000      |                                                                                                                                 |
|    | 40         | === Menu Admin ===                                                                                                              |
|    | 4          | 1. Lihat Semua   Pengguna                                                                                                       |
|    | 5          | 2. Hapus Pengguna                                                                                                               |
|    | 7          | 3. Tambah Kategori                                                                                                              |
|    | 3          | 4. Perbarui Kategori                                                                                                            |
|    |            | 5. Hapus Kategori                                                                                                               |
|    |            | 6. Keluar                                                                                                                       |
|    |            | Pilih opsi:                                                                                                                     |
|    |            | === Daftar Pengguna   ===                                                                                                       |
|    |            | Username        Peran                                                                                                           |
|    |            | makan           ADMIN                                                                                                           |
|    |            |                                                                                                                                 |
|    |            | === Menu Admin ===                                                                                                              |
|    |            | 1. Lihat Semua   Pengguna                                                                                                       |
|    |            | 2. Hapus Pengguna                                                                                                               |
|    |            | 3. Tambah Kategori                                                                                                              |
|    |            | 4. Perbarui Kategori                                                                                                            |
|    |            | 5. Hapus Kategori                                                                                                               |
|    |            | 6. Keluar                                                                                                                       |
|    |            | Pilih opsi:                                                                                                                     |
|    |            | === Daftar Pengguna   ===                                                                                                       |
|    |            | Username        Peran                                                                                                           |
|    |            | makan           ADMIN                                                                                                           |
|    |            | Masukkan username   untuk dihapus: Error: Anda tidak dapat menghapus akun Anda sendiri.                                         |
|    |            |                                                                                                                                 |
|    |            | === Menu Admin ===                                                                                                              |
|    |            | 1. Lihat Semua   Pengguna                                                                                                       |
|    |            | 2. Hapus Pengguna                                                                                                               |
|    |            | 3. Tambah Kategori                                                                                                              |
|    |            | 4. Perbarui Kategori                                                                                                            |
|    |            | 5. Hapus Kategori                                                                                                               |
|    |            | 6. Keluar                                                                                                                       |
|    |            | Pilih opsi: Masukkan   ID kategori: Masukkan nama kategori: Kategori berhasil ditambahkan.                                      |
|    |            |                                                                                                                                 |
|    |            | === Menu Admin ===                                                                                                              |
|    |            | 1. Lihat Semua   Pengguna                                                                                                       |
|    |            | 2. Hapus Pengguna                                                                                                               |
|    |            | 3. Tambah Kategori                                                                                                              |
|    |            | 4. Perbarui Kategori                                                                                                            |
|    |            | 5. Hapus Kategori                                                                                                               |
|    |            | 6. Keluar                                                                                                                       |
|    |            | Pilih opsi:                                                                                                                     |
|    |            | === Sistem E-Commerce   ===                                                                                                     |
|    |            | 1. Login                                                                                                                        |
|    |            | 2. Registrasi                                                                                                                   |
|    |            | 3. Keluar                                                                                                                       |
|    |            | Pilih opsi: Username:   Password: Pilih peran: 1. Pembeli 2. Penjual 3. Admin                                                   |
|    |            | Registrasi berhasil!   Silakan login.                                                                                           |
|    |            |                                                                                                                                 |
|    |            | === Sistem E-Commerce   ===                                                                                                     |
|    |            | 1. Login                                                                                                                        |
|    |            | 2. Registrasi                                                                                                                   |
|    |            | 3. Keluar                                                                                                                       |
|    |            | Pilih opsi: Opsi   tidak valid. Coba lagi.                                                                                      |
|    |            |                                                                                                                                 |
|    |            | === Sistem E-Commerce   ===                                                                                                     |
|    |            | 1. Login                                                                                                                        |
|    |            | 2. Registrasi                                                                                                                   |
|    |            | 3. Keluar                                                                                                                       |
|    |            | Pilih opsi: Username:   Password: Login berhasil! Selamat datang, firman (SELLER).                                              |
|    |            |                                                                                                                                 |
|    |            | === Menu Penjual ===                                                                                                            |
|    |            | 1. Tambah Produk                                                                                                                |
|    |            | 2. Perbarui Produk                                                                                                              |
|    |            | 3. Hapus Produk                                                                                                                 |
|    |            | 4. Lihat Produk Saya                                                                                                            |
|    |            | 5. Lihat Pesanan   Pembeli                                                                                                      |
|    |            | 6. Kelola Dompet                                                                                                                |
|    |            | 7. Keluar                                                                                                                       |
|    |            | Pilih opsi:                                                                                                                     |
|    |            | === Daftar Kategori   ===                                                                                                       |
|    |            | 1. 123 (ID: makan)                                                                                                              |
|    |            | Masukkan ID kategori:   Masukkan ID produk: Masukkan nama produk: Masukkan harga: Masukkan stok:   Produk berhasil ditambahkan. |
|    |            |                                                                                                                                 |
|    |            | === Menu Penjual ===                                                                                                            |
|    |            | 1. Tambah Produk                                                                                                                |
|    |            | 2. Perbarui Produk                                                                                                              |
|    |            | 3. Hapus Produk                                                                                                                 |
|    |            | 4. Lihat Produk Saya                                                                                                            |
|    |            | 5. Lihat Pesanan   Pembeli                                                                                                      |
|    |            | 6. Kelola Dompet                                                                                                                |
|    |            | 7. Keluar                                                                                                                       |
|    |            | Pilih opsi:                                                                                                                     |
|    |            | === Produk Saya ===                                                                                                             |
|    |            | ID         Nama                 Harga      Stok    Kategori                                                                     |
|    |            | 123        ayamgoreng           13000.00   40      123                                                                          |
|    |            |                                                                                                                                 |
|    |            | === Menu Penjual ===                                                                                                            |
|    |            | 1. Tambah Produk                                                                                                                |
|    |            | 2. Perbarui Produk                                                                                                              |
|    |            | 3. Hapus Produk                                                                                                                 |
|    |            | 4. Lihat Produk Saya                                                                                                            |
|    |            | 5. Lihat Pesanan   Pembeli                                                                                                      |
|    |            | 6. Kelola Dompet                                                                                                                |
|    |            | 7. Keluar                                                                                                                       |
|    |            | Pilih opsi: Error:   Buyer username tidak valid: tidak boleh null atau kosong.                                                  |
|    |            |                                                                                                                                 |
|    |            | === Menu Penjual ===                                                                                                            |
|    |            | 1. Tambah Produk                                                                                                                |
|    |            | 2. Perbarui Produk                                                                                                              |
|    |            | 3. Hapus Produk                                                                                                                 |
|    |            | 4. Lihat Produk Saya                                                                                                            |
|    |            | 5. Lihat Pesanan   Pembeli                                                                                                      |
|    |            | 6. Kelola Dompet                                                                                                                |
|    |            | 7. Keluar                                                                                                                       |
|    |            | Pilih opsi:                                                                                                                     |
|    |            | === Sistem E-Commerce   ===                                                                                                     |
|    |            | 1. Login                                                                                                                        |
|    |            | 2. Registrasi                                                                                                                   |
|    |            | 3. Keluar                                                                                                                       |
|    |            | Pilih opsi: Terima   kasih telah menggunakan sistem!                                                                            |


## Compile

`mvn clean package`

## Run

`java -cp target/app.jar del.alstrudat.App`
