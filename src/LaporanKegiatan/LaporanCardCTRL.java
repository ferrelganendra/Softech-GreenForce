package LaporanKegiatan;

import Main.MainPaneCTRL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import util.OpenScene;

public class LaporanCardCTRL {

    @FXML
    private Button button;

    @FXML
    void keLaporanKegiatan(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/LaporanKegiatan/LaporanKegiatanEdit");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

}
