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
    private TextField tanggalJam;

    @FXML
    private TextField keperluan;

    @FXML
    private TextField tujuan;

    @FXML
    private Button pilihGambar;

    @FXML
    private Button tambah;

    ArrayList<JadwalKegiatan> jadwalKegiatanList = XMLctrl.getJadwalKegiatan();
    JadwalKegiatan jadwalKegiatan = new JadwalKegiatan("null", "null", "null", "null", "null", "null");

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
                jadwalKegiatan.setImgSrc("../Resource/" + fileName);
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
        jadwalKegiatan.setNamaKegiatan(namaKegiatan.getText());
        jadwalKegiatan.setLokasi(lokasi.getText());
        jadwalKegiatan.setKalenderjam(tanggalJam.getText());
        jadwalKegiatan.setKeperluan(keperluan.getText());
        jadwalKegiatan.setTujuan(tujuan.getText());
        jadwalKegiatanList.add(0, jadwalKegiatan);
        if (imgSrc.getImage() != null) {
            XMLctrl.saveJadwalKegiatan(jadwalKegiatanList);
            try {
                OpenScene object = new OpenScene();
                Pane halaman = object.getPane("/View/JadwalKegiatan");
                MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
            } catch (Exception e) {
                ShowAlert.showAlert("Error", "Warning", "Halaman tidak ditemukan");
                e.getMessage();
            }
        } else {
            ShowAlert.showAlert("Gambar tidak ditemukan", "Isi gambar terlebih dahulu", null);
        }

    }

    @FXML
    void kembali(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/JadwalKegiatan");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }
}