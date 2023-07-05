package Main;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import util.OpenScene;

public class MainPaneCTRL implements Initializable {

    @FXML
    private HBox akunSaya;

    @FXML
    private BorderPane mainPane;

    public BorderPane getMainPane() {
        return mainPane;
    }

    private static MainPaneCTRL instance;

    public MainPaneCTRL() {
        instance = this;
    }

    public static MainPaneCTRL getInstance() {
        return instance;
    }

    @FXML
    void keAkun(MouseEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/Login/Login");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keJadwalAksi(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/JadwalKegiatan");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keLaporanKegiatan(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/LaporanKegiatan");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keBeranda(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/Beranda");
        mainPane.setCenter(halaman);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/Beranda");
        mainPane.setCenter(halaman);
    }

    

}
