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
