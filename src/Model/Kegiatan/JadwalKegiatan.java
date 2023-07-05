package Model.Kegiatan;

public class JadwalKegiatan extends Kegiatan{
    private String keperluan;

    public JadwalKegiatan(String namaKegiatan, StringBuilder tujuan, String lokasi, String kalender_jam,
            String keperluan) {
        super(namaKegiatan, tujuan, lokasi, kalender_jam);
        this.keperluan = keperluan;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    
}
