package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import JadwalKegiatan.JadwalCardCTRL;
import JadwalKegiatan.JadwalKegiatanEditCTRL;
import LaporanKegiatan.LaporanCardCTRL;
import LaporanKegiatan.LaporanKegiatanEditCTRL;
import Main.MainPaneCTRL;
import Model.Kegiatan.JadwalKegiatan;
import Model.Kegiatan.LaporanKegiatan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.FileManager;
import util.OpenScene;
import util.ShowAlert;
import util.XMLctrl;

public class LaporanKegiatanCTRL {

    @FXML
    private TextField indexDelete;

    @FXML
    private VBox vBoxLaporan;

    private VBox CardBox;

    private Map<String, VBox> cardBoxMap = new HashMap<>();

    ArrayList<LaporanKegiatan> artikelGreenForce = new ArrayList<>();

    @FXML
    void addArtikel(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/LaporanKegiatan/LaporanKegiatanAdd");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    };


    @FXML
    public void initialize() throws IOException {
        for (int i = 0; i < artikelGreenForce.size(); i++) {
            // Mengload card artikel
            FXMLLoader cardloader = new FXMLLoader();
            cardloader.setLocation(getClass().getResource("/JadwalKegiatan/JadwalCard.fxml"));
            CardBox = cardloader.load();
            LaporanCardCTRL cardCTRL = cardloader.getController();
            cardCTRL.setData(artikelGreenForce.get(i));
            Button edit = cardCTRL.getEdit();
            edit.setId("" + i);
            CardBox.setId("" + i);
            cardBoxMap.put(CardBox.getId(), CardBox);
            vBoxLaporan.getChildren().add(CardBox);

            // Megload page untuk mengedit artikel
            FXMLLoader jadwalKegiatanLoader = new FXMLLoader();
            jadwalKegiatanLoader.setLocation(getClass().getResource("/JadwalKegiatan/JadwalKegiatanEdit.fxml"));
            VBox jadwalKegiatan = jadwalKegiatanLoader.load();
            JadwalKegiatanEditCTRL jadwalKegiatanEditCTRL = jadwalKegiatanLoader.getController();
            jadwalKegiatan.setId("" + i);
            LaporanKegiatanEditCTRL.setData(artikelGreenForce.get(i));

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