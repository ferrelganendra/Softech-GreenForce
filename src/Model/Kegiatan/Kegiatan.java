package Model.Kegiatan;

public abstract class Kegiatan {
    private String namaKegiatan;
    private String tujuan;
    private String lokasi;
    private String kalender_jam;

    public Kegiatan(String namaKegiatan, String tujuan, String lokasi, String kalender_jam) {
        this.namaKegiatan = namaKegiatan;
        this.tujuan = tujuan;
        this.lokasi = lokasi;
        this.kalender_jam = kalender_jam;
    }
    
    public String getNamaKegiatan() {
        return namaKegiatan;
    }
    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }
    public String getTujuan() {
        return tujuan;
    }
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
    public String getKalenderjam(){
        return kalender_jam;
    }
    public void setKalenderjam(String kalender_jam){
        this.kalender_jam = kalender_jam;
    }
    public String getLokasi() {
        return lokasi;
    }
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public String getKalender_jam() {
        return kalender_jam;
    }
    public void setKalender_jam(String kalender_jam) {
        this.kalender_jam = kalender_jam;
    }

    

}