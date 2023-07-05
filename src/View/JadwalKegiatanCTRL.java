package View;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.OpenScene;
import util.XMLctrl;

public class JadwalKegiatanCTRL {

    @FXML
    private TextField indexDelete;

    @FXML
    private VBox VBoxJadwal;

    private VBox cardBox;

    private Map<String, VBox> cardBoxMap = new HashMap<>();

    ArrayList<JadwalKegiatan> jadwalKegiatanGreenForce = XMLctrl.getJadwalKegiatan();

    @FXML
    void addArtikel(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/JadwalKegiatan/JadwalKegiatanAdd");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    @FXML
    void hapusArtikel(ActionEvent event) {
        String targetId = indexDelete.getText();
        VBox targetCardBox = cardBoxMap.get(targetId);
        if (targetCardBox != null) {
            VBoxJadwal.getChildren().remove(targetCardBox);
        }
        JadwalKegiatan artikelToRemove = jadwalKegiatanGreenForce.get(Integer.valueOf(indexDelete.getText()));
        jadwalKegiatanGreenForce.remove(artikelToRemove);
        XMLctrl.saveJadwalKegiatan(jadwalKegiatanGreenForce);
        indexDelete.setText("");
    }

     @FXML
    public void initialize() throws IOException {
        for (int i = 0; i < jadwalKegiatanGreenForce.size(); i++) {
            // Mengload card artikel
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/JadwalKegiatan/JadwalCard.fxml"));
            cardBox = fxmlLoader.load();
            JadwalCardCTRL cardCTRL = fxmlLoader.getController();
            cardCTRL.setData(jadwalKegiatanGreenForce.get(i));
            cardBox.setId("" + i);
            cardBoxMap.put(cardBox.getId(), cardBox);
            VBoxJadwal.getChildren().add(cardBox);

            // Megload page untuk mengedit artikel
            FXMLLoader jadwalKegiatanLoader = new FXMLLoader();
            jadwalKegiatanLoader.setLocation(getClass().getResource("/Home/Artikel/ArtikelEdit.fxml"));
            VBox jadwalKegiatan = jadwalKegiatanLoader.load();
            JadwalKegiatanEditCTRL jadwalKegiatanEditCTRL = jadwalKegiatanLoader.getController();
            jadwalKegiatan.setId("" + i);
            jadwalKegiatanEditCTRL.setData(jadwalKegiatanGreenForce.get(i));

            if (VBoxJadwal.getChildren().get(i).equals(cardBox)) {
                cardBox.setOnMouseClicked(event -> {
                    MainPaneCTRL.getInstance().getMainPane().setCenter(jadwalKegiatan);
                });
            }
        }
    }

}