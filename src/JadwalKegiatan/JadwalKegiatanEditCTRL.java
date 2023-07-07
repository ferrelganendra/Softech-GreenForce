package JadwalKegiatan;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import Model.Kegiatan.JadwalKegiatan;
import Main.MainPaneCTRL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import util.OpenScene;
import util.XMLctrl;
import Resource.FileManager;

public class JadwalKegiatanEditCTRL {

    @FXML
    private VBox Virbox;

    @FXML
    private ImageView imgSrc;

    @FXML
    private TextField kalender_Jam;

    @FXML
    private TextField keperluan;

    @FXML
    private TextField lokasi;

    @FXML
    private TextField namaKegiatan;

    @FXML
    private TextField tujuan;

    ArrayList<JadwalKegiatan> jadwalKegiatan = XMLctrl.getJadwalKegiatan();

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
            String index = Virbox.getId();
            try {
                URI fileUri = selectedFile.toURI();
                Image image = new Image(fileUri.toURL().toString());
                FileManager.saveImageToResourceFolder(selectedFile);
                String fileName = selectedFile.getName();
                jadwalKegiatan.get(Integer.valueOf(index)).setImgSrc("../Resource/" +
                        fileName);
                imgSrc.setImage(image);
            } catch (MalformedURLException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        } else {
            System.out.println("File is not valid");
        }
    }

    @FXML
    void kembali(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/JadwalKegiatan");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    
    @FXML
    void simpanEditArtikel(ActionEvent event) {
        String nK = namaKegiatan.getText();
        String l = lokasi.getText();
        String kJ = kalender_Jam.getText();
        String k = keperluan.getText();
        String t = tujuan.getText();
        String index = Virbox.getId();

        jadwalKegiatan.get(Integer.valueOf(index)).setNamaKegiatan(nK);
        jadwalKegiatan.get(Integer.valueOf(index)).setLokasi(l);
        jadwalKegiatan.get(Integer.valueOf(index)).setKalenderjam(kJ);
        jadwalKegiatan.get(Integer.valueOf(index)).setKeperluan(k);
        jadwalKegiatan.get(Integer.valueOf(index)).setTujuan(t);
        XMLctrl.saveJadwalKegiatan(jadwalKegiatan);

        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/JadwalKegiatan");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    public void setData(JadwalKegiatan jadwalKegiatan) {
        String imagePath = jadwalKegiatan.getImgSrc();
        String fullImagePath = getClass().getResource("/Resource/" + imagePath).toExternalForm();
        Image image = new Image(fullImagePath);
        imgSrc.setImage(image);
        namaKegiatan.setText(jadwalKegiatan.getNamaKegiatan());
        lokasi.setText(jadwalKegiatan.getLokasi());
        kalender_Jam.setText(jadwalKegiatan.getKalenderjam());
        keperluan.setText(jadwalKegiatan.getKeperluan());
        tujuan.setText(jadwalKegiatan.getTujuan());
    }
}
