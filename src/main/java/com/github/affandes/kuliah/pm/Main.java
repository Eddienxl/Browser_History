package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> history = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPilih operasi:");
            System.out.println("1. View");
            System.out.println("2. Browse");
            System.out.println("3. Back");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    view();
                    break;
                case 2:
                    browse();
                    break;
                case 3:
                    back();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("History browser (dari yang terbaru):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println((history.size() - i) + ". " + history.get(i));
            }
        }
    }

    private static void browse() {
        System.out.print("Masukkan URL website: ");
        String url = scanner.nextLine();
        history.add(url);
        System.out.println("Anda sekarang browsing: " + url);
    }

    private static void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
        } else {
            String lastUrl = history.remove(history.size() - 1);
            System.out.println("Kembali dari: " + lastUrl);
            if (!history.isEmpty()) {
                System.out.println("Sekarang di: " + history.get(history.size() - 1));
            } else {
                System.out.println("Anda kembali ke halaman awal.");
            }
        }
    }
}
