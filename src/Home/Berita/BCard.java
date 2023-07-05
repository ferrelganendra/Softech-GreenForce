package Home.Berita;

import Main.MainPaneCTRL;
import Model.Artikel.Berita;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import util.OpenScene;

public class BCard {

    @FXML
    private HBox HBox;

    @FXML
    private ImageView beritaImage;

    @FXML
    private Text judulBerita;

    @FXML
    private Rectangle kotakText;

    public void setBeritaImage(ImageView beritaImage) {
        this.beritaImage = beritaImage;
    }

    public void setJudulBerita(Text judulBerita) {
        this.judulBerita = judulBerita;
    }

    public Rectangle getKotakText() {
        return kotakText;
    }

    public void setKotakText(Rectangle kotakText) {
        this.kotakText = kotakText;
    }

    public HBox getHBox() {
        return HBox;
    }

    public ImageView getBeritaImage() {
        return beritaImage;
    }

    public Text getJudulBerita() {
        return judulBerita;
    }
    
    public void setHBox(HBox hBox) {
        HBox = hBox;
    }

    @FXML
    void keBerita(MouseEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/Home/Berita/BeritaEdit");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    public void setDataBerita(Berita berita) {
        String imagePath = berita.getImgSrc();
        String fullImagePath = getClass().getResource("/Resource/" + imagePath).toExternalForm();
        Image image = new Image(fullImagePath);
        beritaImage.setImage(image);
        judulBerita.setText(berita.getJudulBerita());
        HBox.setStyle(
                "-fx-background-radius: 15;" + "fx-effect:dropShadown(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 10);");
        beritaImage.setStyle("-fx-background-radius: 15;");
    }

}
