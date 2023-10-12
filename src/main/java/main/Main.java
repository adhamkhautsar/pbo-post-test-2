package main;

import computerstore.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== Toko Komputer ===");
            System.out.println("1. Tambah Komputer");
            System.out.println("2. Tampilkan Daftar Komputer");
            System.out.println("3. Hapus Komputer");
            System.out.println("4. Update Komputer");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            switch (pilihan) {
                case 1:
                    System.out.println("=== Tambah Komputer ===");
                    System.out.println("1. Desktop");
                    System.out.println("2. Laptop");
                    System.out.print("Pilihan: ");
                    int pilihanKomputer = scanner.nextInt();
                    scanner.nextLine();

                    if (pilihanKomputer == 1) {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        if (ComputerStore.getKomputerById(id)) {
                            System.out.println("Komputer dengan ID " + id + " sudah ada");
                            break;
                        }

                        System.out.print("Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Harga: ");
                        int harga = scanner.nextInt();
                        scanner.nextLine(); // Consumes the newline character
                        System.out.print("Jenis Casing: ");
                        String jenisCasing = scanner.nextLine();

                        Desktop desktop = new Desktop(id, nama, harga, jenisCasing);
                        ComputerStore.tambahKomputer(desktop);
                    } else if (pilihanKomputer == 2) {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        if (ComputerStore.getKomputerById(id)) {
                            System.out.println("Komputer dengan ID " + id + " sudah ada");
                            break;
                        }

                        System.out.print("Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Harga: ");
                        int harga = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Tipe Baterai: ");
                        String tipeBaterai = scanner.nextLine();

                        Laptop laptop = new Laptop(id, nama, harga, tipeBaterai);
                        ComputerStore.tambahKomputer(laptop);
                    } else {
                        System.out.println("Pilihan tidak tersedia");
                    }
                    break;

                case 2:
                    System.out.println("=== Daftar Komputer ===");
                    ComputerStore.tampilkanDaftarKomputer();
                    break;

                case 3:
                    System.out.println("=== Hapus Komputer ===");
                    System.out.print("ID: ");
                    String idHapus = scanner.nextLine();

                    if (ComputerStore.getKomputerById(idHapus)) {
                        ComputerStore.hapusKomputer(idHapus);
                        System.out.println("Komputer dengan ID " + idHapus + " berhasil dihapus");
                    } else {
                        System.out.println("Komputer tidak ditemukan");
                    }
                    break;

                case 4:
                    System.out.println("=== Update Komputer ===");
                    System.out.print("ID: ");
                    String idUpdate = scanner.nextLine();

                    if (!ComputerStore.getKomputerById(idUpdate)) {
                        System.out.println("Komputer tidak ditemukan");
                        break;
                    }

                    System.out.print("Nama: ");
                    String namaUpdate = scanner.nextLine();
                    System.out.print("Harga: ");
                    int hargaUpdate = scanner.nextInt();
                    ComputerStore.updateKomputer(idUpdate, namaUpdate, hargaUpdate);
                    break;

                case 5:
                    System.out.println("Keluar");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        } while (pilihan != 5);
    }
}
