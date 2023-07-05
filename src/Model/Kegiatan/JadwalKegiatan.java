package Model.Kegiatan;

public class JadwalKegiatan extends Kegiatan{
    private String keperluan;
    private String ImgSrc;

    public JadwalKegiatan(String namaKegiatan, String tujuan, String lokasi, String kalender_jam,
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

    public String getImgSrc(){
        return ImgSrc;
    }

    public void setImgSrc(String imgSrc){
        this.ImgSrc = imgSrc;
    }

    
}
