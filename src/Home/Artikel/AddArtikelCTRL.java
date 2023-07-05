package Home.Artikel;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import Main.MainPaneCTRL;
import Model.Artikel.Artikel;
import Resource.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import util.OpenScene;
import util.ShowAlert;
import util.XMLctrl;

public class AddArtikelCTRL {

    @FXML
    private ImageView imgSrc;

    @FXML
    private TextArea isiArtikel;

    @FXML
    private TextField judulArtikel;

    ArrayList<Artikel> artikelList = XMLctrl.getArtikel();
    Artikel artikel = new Artikel();

    @FXML
    void pilihGambar(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Pilih gambar");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All images", "*.png", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG image", "*.png"),
                new FileChooser.ExtensionFilter("JPEG image", "*.jpg"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                URI fileUri = selectedFile.toURI();
                Image image = new Image(fileUri.toURL().toString());
                FileManager.saveImageToResourceFolder(selectedFile);
                String fileName = selectedFile.getName();
                artikel.setImgSrc("../Resource/" + fileName);
                imgSrc.setImage(image);
            } catch (MalformedURLException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        } else {
            System.out.println("File is not valid");
        }
    }

    @FXML
    void tambah(ActionEvent event) {
        artikel.setJudulArtikel(judulArtikel.getText());
        artikel.setText(isiArtikel.getText());
        artikelList.add(0, artikel);
        if (imgSrc.getImage() != null) {
            XMLctrl.saveArtikel(artikelList);
            try {
                OpenScene object = new OpenScene();
                Pane halaman = object.getPane("/View/Beranda");
                MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
            } catch (Exception e) {
                ShowAlert.showAlert("Error", "Warning", "Halaman tidak ditemukan");
                e.getMessage();
            }
        } else {
            ShowAlert.showAlert("Gambar tidak ditemukan", "Isi gambar terlebih dahulu", null);
        }

    }

}