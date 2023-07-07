package View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import JadwalKegiatan.JadwalCardCTRL;
import JadwalKegiatan.JadwalKegiatanEditCTRL;
import Main.MainPaneCTRL;
import Model.Kegiatan.JadwalKegiatan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.OpenScene;
import util.ShowAlert;
import util.XMLctrl;

public class JadwalKegiatanCTRL {

    @FXML
    private TextField indexDelete;

    @FXML
    private VBox vBoxJadwal;

    private VBox CardBox;

    private Map<String, VBox> cardBoxMap = new HashMap<>();

    ArrayList<JadwalKegiatan> jadwalKegiatanGreenForce = XMLctrl.getJadwalKegiatan();

    @FXML
    void addArtikel(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/JadwalKegiatan/JadwalKegiatanAdd");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    };

    @FXML
    void hapusJadwal(ActionEvent event) {
        String targetId = indexDelete.getText();
        VBox targetCardBox = cardBoxMap.get(targetId);
        if (targetCardBox != null) {
            boolean konfirmasi = ShowAlert.showConfirmation("Konfirmasi",
                    "Apakah Anda yakin akan menghapus Artikel ini?");
            if (konfirmasi) {
                vBoxJadwal.getChildren().remove(targetCardBox);
                JadwalKegiatan artikelToRemove = jadwalKegiatanGreenForce.get(Integer.valueOf(indexDelete.getText()));
                File file = new File(artikelToRemove.getImgSrc());
                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("File " + file.getName() + " berhasil dihapus.");
                    } else {
                        System.out.println("Gagal menghapus file.");
                    }
                } else {
                    System.out.println("File tidak ditemukan.");
                }
                jadwalKegiatanGreenForce.remove(artikelToRemove);
                XMLctrl.saveJadwalKegiatan(jadwalKegiatanGreenForce);
            }
        } else {
            ShowAlert.showAlert("Error", "Berita dengan index " + targetId + " tidak ada", "Index dimulai dari 0");
        }
        indexDelete.setText("");
    }

    @FXML
    public void initialize() throws IOException {
        for (int i = 0; i < jadwalKegiatanGreenForce.size(); i++) {
            // Mengload card artikel
            FXMLLoader cardloader = new FXMLLoader();
            cardloader.setLocation(getClass().getResource("/JadwalKegiatan/JadwalCard.fxml"));
            CardBox = cardloader.load();
            JadwalCardCTRL cardCTRL = cardloader.getController();
            cardCTRL.setData(jadwalKegiatanGreenForce.get(i));
            Button edit = cardCTRL.getEdit();
            edit.setId("" + i);
            CardBox.setId("" + i);
            cardBoxMap.put(CardBox.getId(), CardBox);
            vBoxJadwal.getChildren().add(CardBox);

            // Megload page untuk mengedit artikel
            FXMLLoader jadwalKegiatanLoader = new FXMLLoader();
            jadwalKegiatanLoader.setLocation(getClass().getResource("/JadwalKegiatan/JadwalKegiatanEdit.fxml"));
            VBox jadwalKegiatan = jadwalKegiatanLoader.load();
            JadwalKegiatanEditCTRL jadwalKegiatanEditCTRL = jadwalKegiatanLoader.getController();
            jadwalKegiatan.setId("" + i);
            jadwalKegiatanEditCTRL.setData(jadwalKegiatanGreenForce.get(i));

            if (vBoxJadwal.getChildren().get(i).equals(CardBox)) {
                edit.setOnAction(event -> {
                    MainPaneCTRL.getInstance().getMainPane().setCenter(jadwalKegiatan);
                });
                // CardBox.setOnMouseClicked(event -> {
                // MainPaneCTRL.getInstance().getMainPane().setCenter(jadwalKegiatan);
                // });
            }
        }
    }

}