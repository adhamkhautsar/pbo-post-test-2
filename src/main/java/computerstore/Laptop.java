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
