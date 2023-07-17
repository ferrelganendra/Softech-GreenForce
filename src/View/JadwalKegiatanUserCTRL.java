package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import JadwalKegiatan.JadwalCardUserCTRL;
import Main.MainPaneCTRL;
import Model.Kegiatan.JadwalKegiatan;
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

public class JadwalKegiatanUserCTRL {
    
    @FXML
    private VBox vBoxJadwal;

    private VBox CardBox;

    private Map<String, VBox> cardBoxMap = new HashMap<>();

    ArrayList<JadwalKegiatan> jadwalKegiatanGreenForce = XMLctrl.getJadwalKegiatan();

    @FXML
    public void initialize() throws IOException {
        for (int i = 0; i < jadwalKegiatanGreenForce.size(); i++) {
            // Mengload card artikel
            FXMLLoader cardloader = new FXMLLoader();
            cardloader.setLocation(getClass().getResource("/JadwalKegiatan/JadwalCardUser.fxml"));
            CardBox = cardloader.load();
            JadwalCardUserCTRL cardCTRL = cardloader.getController();
            cardCTRL.setData(jadwalKegiatanGreenForce.get(i));
            Button join = cardCTRL.getJoin();
            join.setId("" + i);
            Button detail = cardCTRL.getDetail();
            detail.setId("" + i);
            CardBox.setId("" + i);
            cardBoxMap.put(CardBox.getId(), CardBox);
            vBoxJadwal.getChildren().add(CardBox);
        }
    }
}
