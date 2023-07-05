package Model.Kegiatan;

public class LaporanKegiatan extends Kegiatan{

    private String rincianKegiatan;
    private String hasilKegiatan;
    private String evaluasiKegiatan;
    private String kesimpulanKegiatan;

    public LaporanKegiatan(String namaKegiatan, StringBuilder tujuan, String lokasi, String kalender_jam,
            String rincianKegiatan, String hasilKegiatan, String evaluasiKegiatan, String kesimpulanKegiatan) {
        super(namaKegiatan, tujuan, lokasi, kalender_jam);
        this.rincianKegiatan = rincianKegiatan;
        this.hasilKegiatan = hasilKegiatan;
        this.evaluasiKegiatan = evaluasiKegiatan;
        this.kesimpulanKegiatan = kesimpulanKegiatan;
    }

    public String getRincianKegiatan() {
        return rincianKegiatan;
    }

    public void setRincianKegiatan(String rincianKegiatan) {
        this.rincianKegiatan = rincianKegiatan;
    }

    public String getHasilKegiatan() {
        return hasilKegiatan;
    }

    public void setHasilKegiatan(String hasilKegiatan) {
        this.hasilKegiatan = hasilKegiatan;
    }

    public String getEvaluasiKegiatan() {
        return evaluasiKegiatan;
    }

    public void setEvaluasiKegiatan(String evaluasiKegiatan) {
        this.evaluasiKegiatan = evaluasiKegiatan;
    }

    public String getKesimpulanKegiatan() {
        return kesimpulanKegiatan;
    }

    public void setKesimpulanKegiatan(String kesimpulanKegiatan) {
        this.kesimpulanKegiatan = kesimpulanKegiatan;
    }

}
