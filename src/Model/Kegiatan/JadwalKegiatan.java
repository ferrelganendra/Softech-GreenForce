package Model.Kegiatan;

public class JadwalKegiatan extends Kegiatan{
    private String keperluan;
    private String imgSrc;

    public JadwalKegiatan(String namaKegiatan, String tujuan, String lokasi, String kalender_jam,
        String keperluan, String imgSrc) {
        super(namaKegiatan, tujuan, lokasi, kalender_jam);
        this.keperluan = keperluan;
        this.imgSrc = imgSrc;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    public String getImgSrc(){
        return imgSrc;
    }

    public void setImgSrc(String imgSrc){
        this.imgSrc = imgSrc;
    }

    
}
