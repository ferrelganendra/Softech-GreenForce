package Home.Artikel;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import Main.MainPaneCTRL;
import Model.Artikel.Artikel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import util.FileManager;
import util.OpenScene;
import util.XMLctrl;

public class ArtikelEditCTRL {

    @FXML
    private VBox ArtikelBox;

    @FXML
    private TextField tfEditJudul;

    @FXML
    private ImageView imgSrc;

    @FXML
    private TextArea textIsiArtikel;

    @FXML
    private Text textJudulArtikel;

    ArrayList<Artikel> artikel = XMLctrl.getArtikel();

    @FXML
    void editJudul(ActionEvent event) {
        String judul = tfEditJudul.getText();
        textJudulArtikel.setText(judul);
    }

    @FXML
    void simpanEditArtikel(ActionEvent event) {
        String index = ArtikelBox.getId();
        String isi = textIsiArtikel.getText();
        String judul = textJudulArtikel.getText();

        artikel.get(Integer.valueOf(index)).setJudulArtikel(judul);
        artikel.get(Integer.valueOf(index)).setText(isi);
        XMLctrl.saveArtikel(artikel);

        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/Beranda");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    public void setData(Artikel artikel) {
        String imagePath = artikel.getImgSrc();
        String fullImagePath = getClass().getResource("/Resource/" + imagePath).toExternalForm();
        Image image = new Image(fullImagePath);
        imgSrc.setImage(image);
        textJudulArtikel.setText(artikel.getJudulArtikel());
        textIsiArtikel.setText(artikel.getText());
    }

    @FXML
    void editImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Pilih gambar");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All images", "*.png", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG image", "*.png"),
                new FileChooser.ExtensionFilter("JPEG image", "*.jpg"));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            String index = ArtikelBox.getId();
            try {
                URI fileUri = selectedFile.toURI();
                Image image = new Image(fileUri.toURL().toString());
                FileManager.saveImageToResourceFolder(selectedFile);
                String fileName = selectedFile.getName();
                artikel.get(Integer.valueOf(index)).setImgSrc("../Resource/" + fileName);
                imgSrc.setImage(image);
            } catch (MalformedURLException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        } else {
            System.out.println("File is not valid");
        }
    }

    @FXML
    void kembaliKeBeranda(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/Beranda");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

}