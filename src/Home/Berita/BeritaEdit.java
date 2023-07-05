package Home.Berita;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import Main.MainPaneCTRL;
import Model.Artikel.Berita;
import Resource.FileManager;
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
import util.OpenScene;
import util.XMLctrl;

public class BeritaEdit {

    @FXML
    private VBox BeritaBox;

    @FXML
    private ImageView imgSrc;

    @FXML
    private TextArea textIsiBerita;

    @FXML
    private Text textJudulBerita;

    @FXML
    private TextField tfEditJudul;

    ArrayList<Berita> berita = XMLctrl.getBerita();

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
            String index = BeritaBox.getId();
            try {
                URI fileUri = selectedFile.toURI();
                Image image = new Image(fileUri.toURL().toString());
                FileManager.saveImageToResourceFolder(selectedFile);
                String fileName = selectedFile.getName();
                berita.get(Integer.valueOf(index)).setImgSrc("../Resource/" + fileName);
                imgSrc.setImage(image);
            } catch (MalformedURLException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        } else {
            System.out.println("File is not valid");
        }
    }

    @FXML
    void editJudul(ActionEvent event) {
        String judul = tfEditJudul.getText();
        textJudulBerita.setText(judul);
    }

    @FXML
    void kembaliKeBeranda(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/Beranda");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    @FXML
    void simpanEditBerita(ActionEvent event) {
        String index = BeritaBox.getId();
        String isi = textIsiBerita.getText();
        String judul = textJudulBerita.getText();

        berita.get(Integer.valueOf(index)).setJudulBerita(judul);
        berita.get(Integer.valueOf(index)).setText(isi);
        XMLctrl.saveBerita(berita);

        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/Beranda");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    public void setData(Berita berita) {
        String imagePath = berita.getImgSrc();
        String fullImagePath = getClass().getResource("/Resource/" + imagePath).toExternalForm();
        Image image = new Image(fullImagePath);
        imgSrc.setImage(image);
        textJudulBerita.setText(berita.getJudulBerita());
        textIsiBerita.setText(berita.getText());
    }

}
