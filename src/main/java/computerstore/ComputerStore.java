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
