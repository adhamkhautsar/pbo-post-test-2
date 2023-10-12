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
