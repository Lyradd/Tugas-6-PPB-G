# Tugas-6-PPB-G

# 💱 Aplikasi Konversi Mata Uang

Aplikasi konversi mata uang sederhana dan mudah digunakan yang dibangun menggunakan **Jetpack Compose**.  
Dengan aplikasi ini, pengguna dapat mengonversi jumlah uang dari satu mata uang ke mata uang lainnya berdasarkan nilai tukar yang telah ditentukan.

---

## ✨ Fitur

- Input jumlah uang yang ingin dikonversi
- Beragam pilihan mata uang asal dan tujuan

## ❌ Kelemahan

- Nilai mata uang masih statis / belum live (hardcoded)

---

## 💡 Penjelasan Fungsi Utama

### `CurrencyConverterApp()`

Fungsi ini merupakan komponen utama dari aplikasi yang menangani seluruh tampilan dan logika konversi.  
Fungsi ini memungkinkan pengguna untuk:

- Mengetik jumlah uang yang akan dikonversi.
- Memilih mata uang asal dan mata uang tujuan dari daftar dropdown.
- Melihat hasil konversi saat tombol **Convert** ditekan.

Fungsi ini menggunakan `remember` untuk menyimpan dan memperbarui nilai input pengguna serta pilihan mata uang secara langsung (reaktif).

---

## 🔁 Nilai Tukar yang Digunakan (Statis)

| Mata Uang | Nilai Tukar terhadap IDR |
|-----------|---------------------------|
| EUR       | 19.142                    |
| USD       | 16.772                    |
| JPY       | 117,79                    |
| KRW       | 11,80                     |
| RUB       | 200,79                    |
| GBP       | 22.084,20                 |
| AUD       | 10.611                    |
| MYR       | 3.802,53                  |
| SGD       | 12.787,90                 |
| CNY       | 2314                      |

> Catatan: Nilai tukar ini diatur secara statis (hardcoded) hanya untuk keperluan tugas ini.

---

## 📸 Preview

![Screenshot 2025-04-14 135004](https://github.com/user-attachments/assets/78c9ad08-3977-4a9e-b654-4667dd6fb5c6)

---

