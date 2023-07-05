package Home.Artikel;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import util.OpenScene;
import Model.Artikel.Artikel;
import Main.MainPaneCTRL;

public class ACardCTRL {

    @FXML
    private HBox HBox;

    @FXML
    private ImageView artikelImage;

    @FXML
    private Text judulArtikel;

    @FXML
    private Rectangle kotakText;

    public ImageView getArtikelImage() {
        return artikelImage;
    }

    public Text getJudulArtikel() {
        return judulArtikel;
    }

    public HBox getHBox() {
        return HBox;
    }

    public void setHBox(HBox hBox) {
        HBox = hBox;
    }

    public void setArtikelImage(ImageView artikelImage) {
        this.artikelImage = artikelImage;
    }

    public void setJudulArtikel(Text judulArtikel) {
        this.judulArtikel = judulArtikel;
    }

    public Rectangle getKotakText() {
        return kotakText;
    }

    public void setKotakText(Rectangle kotakText) {
        this.kotakText = kotakText;
    }

    public void setData(Artikel artikel) {
        String imagePath = artikel.getImgSrc();
        String fullImagePath = getClass().getResource("/Resource/" + imagePath).toExternalForm();
        Image image = new Image(fullImagePath);
        artikelImage.setImage(image);
        judulArtikel.setText(artikel.getJudulArtikel());
        HBox.setStyle("-fx-background-radius: 15;" + "fx-effect:dropShadown(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 10);");
        artikelImage.setStyle("-fx-background-radius: 15;");
    }

    @FXML
    void keArtikel(MouseEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/Home/Artikel/ArtikelEdit");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

}
