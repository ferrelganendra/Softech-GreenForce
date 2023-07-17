package JadwalKegiatan;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import Model.Kegiatan.JadwalKegiatan;

public class JadwalCardUserCTRL {
    @FXML
    private Button Join;

    @FXML
    private Button Detail;

    @FXML
    private Button Edit;

    @FXML
    private VBox VBoxV;

    @FXML
    private ImageView imageJadwal;

    @FXML
    private Text kalender_Jam;

    @FXML
    private Text kegiatan;

    @FXML
    private Text keperluan;

    @FXML
    private Text lokasi;

    @FXML
    private Text tujuan;


    public Button getJoin() {
        return Join;
    }

    public void setJoin(Button join) {
        Join = join;
    }

    public Button getDetail() {
        return Detail;
    }

    public void setDetail(Button detail) {
        Detail = detail;
    }

    public ImageView getImage() {
        return imageJadwal;
    }

    public Text getKegiatan(){
        return kegiatan;
    }

    public Text getLokasi(){
        return lokasi;
    }

    public Text getkalenderJam(){
        return kalender_Jam;
    }

    public Text getKeperluan(){
        return keperluan;
    }

    public Text getTujuan() {
        return tujuan;
    }

    public VBox getVBox() {
        return VBoxV;
    }

    public void setVBox(VBox vBox) {
        VBoxV = vBox;
    }

    public void setImage(ImageView imageaBU) {
        this.imageJadwal = imageaBU;
    }

    public void setKegiatan(Text kegiatan){
        this.kegiatan = kegiatan;
    }

    public void setLokasi(Text lokasi){
        this.lokasi = lokasi;
    } 

    public void setKalenderJam(Text tanggal_jam){
        this.kalender_Jam = tanggal_jam;
    }
    
    public void setKeperluan(Text keperluan){
        this.keperluan = keperluan;
    } 

    public void setTujuan(Text Tujuan) {
        this.tujuan = Tujuan;
    }

    public void setData(JadwalKegiatan jadwalKegiatan) {
        // Image image = new Image(getClass().getResourceAsStream(artikel.getImgSrc()));
        // artikelImage.setImage(image);
        String imagePath = jadwalKegiatan.getImgSrc();
        String fullImagePath = getClass().getResource("/Resource/" + imagePath).toExternalForm();
        Image imageSER = new Image(fullImagePath);
        imageJadwal.setImage(imageSER);
        kegiatan.setText(jadwalKegiatan.getNamaKegiatan());
        lokasi.setText(jadwalKegiatan.getLokasi());
        kalender_Jam.setText(jadwalKegiatan.getKalenderjam());
        keperluan.setText(jadwalKegiatan.getKeperluan());
        tujuan.setText(jadwalKegiatan.getTujuan());
        VBoxV.setStyle("-fx-background-radius: 15;" + "fx-effect:dropShadown(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 10);");
        imageJadwal.setStyle("-fx-background-radius: 15;");
    }
}
