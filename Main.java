/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pboposttest1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {
    static class ItemPanen {
        String kategori;
        String nama;
        double beratKg;
        String kualitas;

        ItemPanen(String kategori, String nama, double beratKg, String kualitas) {
            this.kategori = kategori;
            this.nama = nama;
            this.beratKg = beratKg;
            this.kualitas = kualitas;
        }
    }

    static ArrayList<ItemPanen> daftarPanen = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("===== Menu Hasil Panen =====");
            System.out.println("1. Tambah Item");
            System.out.println("2. Lihat Item");
            System.out.println("3. Edit Item");
            System.out.println("4. Hapus Item");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: tambahItem(); break;
                case 2: tampilkanItem(); break;
                case 3: editItem(); break;
                case 4: hapusItem(); break;
                case 5: System.out.println("Terima kasih yaaa"); break;
                default: System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 5);
    }

    static void tambahItem() {
        System.out.print("Masukkan kategori(Sayur/Buah): ");
        String kategori = scanner.nextLine();
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan berat(Kg): ");
        double berat = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan kualitas: ");
        String kualitas = scanner.nextLine();

        daftarPanen.add(new ItemPanen(kategori, nama, berat, kualitas));
        System.out.println("Data panen berhasil ditambahkan yaa, terima kasih.");
    }

    // read
    static void tampilkanItem() {
        if (daftarPanen.isEmpty()) {
            System.out.println("Belum ada data panen");
        } else {
            System.out.println("Daftar Hasil Panen:");
            for (int i = 0; i < daftarPanen.size(); i++) {
                ItemPanen p = daftarPanen.get(i);
                System.out.println((i + 1) + ". " + p.kategori + " | " + p.nama + " | " + p.beratKg + " kg | " + p.kualitas);
            }
        }
    }

    // update
    static void editItem() {
        tampilkanItem();
        if (!daftarPanen.isEmpty()) return;
        
            System.out.print("Pilih nomor item yang mau diedit: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarPanen.size()) {
                System.out.print("Kategori baru: ");
                String kategori = scanner.nextLine();
                System.out.print("Nama baru: ");
                String nama = scanner.nextLine();
                System.out.print("Berat baru (Kg): ");
                double berat = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Kualitas baru: ");
                String kualitas = scanner.nextLine();

                daftarPanen.set(index, new ItemPanen(kategori, nama, berat, kualitas));
                System.out.println("Item berhasil diedit");
            } else {
                System.out.println("Nomor tidak valid, harap coba lagi");
            }
    }

    // delete
    static void hapusItem() {
        tampilkanItem();
        if (!daftarPanen.isEmpty()) return;
        
            System.out.print("Pilih nomor item yang mau dihapus: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarPanen.size()) {
                daftarPanen.remove(index);
                System.out.println("Item berhasil dihapus");
            } else {
                System.out.println("Nomor tidak valid");
            }
    }
}