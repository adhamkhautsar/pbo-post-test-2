# pbo-post-test-2
Project ini adalah project untuk tugas posttest pbo.

Adham Khautsar Leswono

(2209116021)

SI A 2022

# 1. SOURCECODE
  - Package utama

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

  - Package tambahan

  a.

package computerstore;

public abstract class Computer {

    private final String id;
    private String nama;
    private int harga;

    public Computer(String id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public final String getId() {
        return id;
    }

    public final String getNama() {
        return nama;
    }

    public final void setNama(String nama) {
        this.nama = nama;
    }

    public final int getHarga() {
        return harga;
    }

    public final void setHarga(int harga) {
        this.harga = harga;
    }

    public abstract void tampilkanSpesifikasi();
}

  b.
  
package computerstore;

import java.util.ArrayList;

public class ComputerStore {

    private static final ArrayList<Computer> computers = new ArrayList<>();

    public static void tambahKomputer(Computer komputer) {
        computers.add(komputer);
    }

    public static boolean getKomputerById(String id) {
        for (Computer computer : computers) {
            if (computer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void tampilkanDaftarKomputer() {
        for (Computer computer : computers) {
            computer.tampilkanSpesifikasi();
        }
    }

    public static void hapusKomputer(String id) {
        for (Computer computer : computers) {
            if (computer.getId().equals(id)) {
                computers.remove(computer);
                break;
            }
        }
    }

    public static void updateKomputer(String id, String nama, int harga) {
        for (Computer computer : computers) {
            if (computer.getId().equals(id)) {
                computer.setNama(nama);
                computer.setHarga(harga);
                System.out.println("Komputer dengan ID " + id + " berhasil diupdate");
                break;
            }
        }
    }
}

  c.

package computerstore;

// Class final untuk komputer desktop

public final class Desktop extends Computer {

    private final String jenisCasing;

    public Desktop(String id, String nama, int harga, String jenisCasing) {
        super(id, nama, harga);
        this.jenisCasing = jenisCasing;
    }

    public String getJenisCasing() {
        return jenisCasing;
    }

    @Override
    public void tampilkanSpesifikasi() {
        System.out.println("Desktop id " + getId());
        System.out.println("Nama: " + getNama());
        System.out.println("Harga: " + getHarga());
        System.out.println("Jenis Casing: " + getJenisCasing());
    }
}

  d.

package computerstore;

public final class Laptop extends Computer {

    private final String tipeBaterai;

    public Laptop(String id, String nama, int harga, String tipeBaterai) {
        super(id, nama, harga);
        this.tipeBaterai = tipeBaterai;
    }

    public String getTipeBaterai() {
        return tipeBaterai;
    }

    @Override
    public void tampilkanSpesifikasi() {
        System.out.println("Laptop id " + getId());
        System.out.println("Nama: " + getNama());
        System.out.println("Harga: " + getHarga());
        System.out.println("Tipe Baterai: " + getTipeBaterai());
        System.out.println();
    }
}

# 2. OUTPUT
