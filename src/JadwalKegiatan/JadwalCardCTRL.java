package JadwalKegiatan;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import util.OpenScene;
import Model.Kegiatan.JadwalKegiatan;
import Main.MainPaneCTRL;

public class JadwalCardCTRL{
    @FXML
    private VBox VBox;

    @FXML
    private ImageView Image;

    @FXML
    private Label namaKegiatan;

    @FXML
    private Label lokasi;

    @FXML
    private Label kalender_Jam;

    @FXML
    private Label keperluan;

    @FXML
    private Text tujuan;

    @FXML
    private Button Edit;

    public ImageView getImage() {
        return Image;
    }

    public Label getKegiatan(){
        return namaKegiatan;
    }

    public Label getLokasi(){
        return lokasi;
    }

    public Label getkalenderJam(){
        return kalender_Jam;
    }

    public Label getKeperluan(){
        return keperluan;
    }

    public Text getTujuan() {
        return tujuan;
    }

    public VBox getVBox() {
        return VBox;
    }

    public void setVBox(VBox vBox) {
        VBox = vBox;
    }

    public void setImage(ImageView Image) {
        this.Image = Image;
    }

    public void setKegiatan(Label kegiatan){
        this.namaKegiatan = kegiatan;
    }

    public void setLokasi(Label lokasi){
        this.lokasi = lokasi;
    } 

    public void setKalenderJam(Label tanggal_jam){
        this.kalender_Jam = tanggal_jam;
    }
    
    public void setKeperluan(Label keperluan){
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
        Image image = new Image(fullImagePath);
        Image.setImage(image);
        namaKegiatan.setText(jadwalKegiatan.getNamaKegiatan());
        lokasi.setText(jadwalKegiatan.getLokasi());
        kalender_Jam.setText(jadwalKegiatan.getKalenderjam());
        keperluan.setText(jadwalKegiatan.getKeperluan());
        tujuan.setText(jadwalKegiatan.getTujuan());
        VBox.setStyle("-fx-background-radius: 15;" + "fx-effect:dropShadown(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 10);");
        Image.setStyle("-fx-background-radius: 15;");
    }

    @FXML
    void keArtikel(MouseEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/JadwalKegiatan");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }
}