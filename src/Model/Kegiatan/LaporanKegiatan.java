package Model.Kegiatan;

public class LaporanKegiatan extends Kegiatan{

    private String rincianKegiatan;
    private String hasilKegiatan;
    private String evaluasiKegiatan;
    private String kesimpulanKegiatan;
    private String imgSrc;

    public LaporanKegiatan(String namaKegiatan, String tujuan, String lokasi, String kalender_jam,
            String rincianKegiatan, String hasilKegiatan, String evaluasiKegiatan, String kesimpulanKegiatan, String imgSrc) {
        super(namaKegiatan, tujuan, lokasi, kalender_jam);
        this.rincianKegiatan = rincianKegiatan;
        this.hasilKegiatan = hasilKegiatan;
        this.evaluasiKegiatan = evaluasiKegiatan;
        this.kesimpulanKegiatan = kesimpulanKegiatan;
        this.imgSrc = imgSrc;
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

}
