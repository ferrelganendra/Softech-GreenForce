package JadwalKegiatan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import util.OpenScene;
import Model.Kegiatan.JadwalKegiatan;
import Main.MainPaneCTRL;

public class JadwalCardCTRL{

    @FXML
    private Button Edit;

    @FXML
    private VBox VBoxV;

    @FXML
    private ImageView imageJadwal;

    @FXML
    private Label kalenderJam;

    @FXML
    private Label kegiatan;

    @FXML
    private Text keperluan;

    @FXML
    private Label lokasi;

    @FXML
    private Text tujuan;

    public Button getEdit() {
        return Edit;
    }

    public void setEdit(Button edit) {
        Edit = edit;
    }

    public ImageView getImage() {
        return imageJadwal;
    }

    public Label getKegiatan(){
        return kegiatan;
    }

    public Label getLokasi(){
        return lokasi;
    }

    public Label getkalenderJam(){
        return kalenderJam;
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

    public void setKegiatan(Label kegiatan){
        this.kegiatan = kegiatan;
    }

    public void setLokasi(Label lokasi){
        this.lokasi = lokasi;
    } 

    public void setKalenderJam(Label tanggal_jam){
        this.kalenderJam = tanggal_jam;
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
        kalenderJam.setText(jadwalKegiatan.getKalenderjam());
        keperluan.setText(jadwalKegiatan.getKeperluan());
        tujuan.setText(jadwalKegiatan.getTujuan());
        VBoxV.setStyle("-fx-background-radius: 15;" + "fx-effect:dropShadown(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 10);");
        imageJadwal.setStyle("-fx-background-radius: 15;");
    }

    @FXML
    void keEdit(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/JadwalKegiatan");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }
}