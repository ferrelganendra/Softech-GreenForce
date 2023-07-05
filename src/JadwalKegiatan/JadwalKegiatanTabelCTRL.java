package JadwalKegiatan;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class JadwalKegiatanTabelCTRL implements Initializable {
    // ObservableList JadwalKegiatan = observableArrayList(
        
    // );

    // @FXML
    // private TableColumn Username;

    // @FXML
    // private TableColumn UserID;

    // @FXML
    // private TableView TableView;

    @FXML
    private TextField text;

    @FXML
    private Button Tambah;

    @FXML
    private Button Hapus;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }

    @FXML
    private void deleteButtonAction() {
        // int valueToDelete = Integer.parseInt(text.getText());
        // int x = valueToDelete -1;
        // JadwalKegiatan.remove(x);
        text.setText("");          
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
}