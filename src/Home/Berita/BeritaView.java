package Home.Berita;

import java.util.ArrayList;

import Main.MainPaneCTRL;
import Model.Artikel.Artikel;
import Model.Artikel.Berita;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util.OpenScene;
import util.XMLctrl;

public class BeritaView {

    @FXML
    private VBox BeritaBox;

    @FXML
    private ImageView imgSrc;

    @FXML
    private Text textIsiArtikel;

    @FXML
    private Text textJudulArtikel;

    ArrayList<Artikel> artikel = XMLctrl.getArtikel();

    public void setData(Berita berita) {
        String imagePath = berita.getImgSrc();
        String fullImagePath = getClass().getResource("/Resource/" + imagePath).toExternalForm();
        Image image = new Image(fullImagePath);
        imgSrc.setImage(image);
        textJudulArtikel.setText(berita.getJudulBerita());
        textIsiArtikel.setText(berita.getText());
    }

    @FXML
    void kembaliKeBeranda(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/UserBeranda");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

}