package JadwalKegiatan;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import Main.MainPaneCTRL;
import Model.Kegiatan.JadwalKegiatan;
import Resource.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import util.OpenScene;
import util.ShowAlert;
import util.XMLctrl;

public class JadwalKegiatanAddCTRL{
     @FXML
    private ImageView imgSrc;

    @FXML
    private TextField namaKegiatan;

    @FXML
    private TextField lokasi;

    @FXML
    private TextField kalender_Jam;

    @FXML
    private TextField keperluan;

    @FXML
    private TextField tujuan;

    @FXML
    private Button pilihGambar;

    @FXML
    private Button tambah;

    ArrayList<JadwalKegiatan> JadwalKegiatanList = XMLctrl.getJadwalKegiatan();
    JadwalKegiatan JadwalKegiatan = new JadwalKegiatan("", "", "", "", "");

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
                JadwalKegiatan.setImgSrc("../Resource/" + fileName);
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
        JadwalKegiatan.setNamaKegiatan(namaKegiatan.getText());
        JadwalKegiatan.setLokasi(lokasi.getText());
        JadwalKegiatan.setKalender_jam(kalender_Jam.getText());
        JadwalKegiatan.setKeperluan(keperluan.getText());
        JadwalKegiatan.setTujuan(tujuan.getText());
        JadwalKegiatanList.add(0, JadwalKegiatan);
        XMLctrl.saveJadwalKegiatan(JadwalKegiatanList);
        try {
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/JadwalKegiatan");
            MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
        } catch (Exception e) {
            ShowAlert.showAlert("Error", "Warning", null);
            e.getMessage();
        }

    }

    @FXML
    void kembali(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/JadwalKegiatan");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }
}