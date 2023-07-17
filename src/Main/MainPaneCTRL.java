package Main;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;

import Model.Account.Akun;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import util.OpenScene;
import util.ShowAlert;
import util.VerifyLogin;
import util.XMLctrl;

public class MainPaneCTRL implements Initializable {

    @FXML
    private HBox akunSaya;

    @FXML
    private HBox HBoxCenter;

    @FXML
    private BorderPane mainPane;

    @FXML
    private HBox topMainPane;

    @FXML
    private HBox logout;

    Akun current = XMLctrl.getCurrentAccount();

    public void setLogOut(boolean visible) {
        logout.setVisible(visible);
    }

    public HBox getTopMainPane() {
        return topMainPane;
    }

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
    void AjukanAksi(ActionEvent event) {
        ShowAlert.showAlert(null, "Mohon Maaf, Fitur belum tersedia", null);
    }

    @FXML
    void Logout(MouseEvent event) {
        VerifyLogin ver = XMLctrl.getVerify();
        logout.setVisible(false);
        Platform.runLater(() -> {
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/Login/Login");
            mainPane.setCenter(halaman);
            ver.setAdminVerified(false);
            ver.setUserVerified(false);
            XMLctrl.saveVerify(ver);
        });
    }

    @FXML
    void keAkun(MouseEvent event) {
        VerifyLogin ver = XMLctrl.getVerify();
        if (ver.isVerifiedAdmin()) {
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/DeskripsiAkun");
            mainPane.setCenter(halaman);
        } else if (ver.isVerifiedUser()) {
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/DeskripsiAkun");
            mainPane.setCenter(halaman);
        } else { // Kondisi ketika logout atau (login as guest)
            ShowAlert.showAlert("", "Silahkan login terlebih dahulu", null);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/Login/Login");
            mainPane.setCenter(halaman);
        }
    }

    @FXML
    void keDonasi(MouseEvent event) {
        ShowAlert.showAlert(null, "Mohon Maaf, Fitur belum tersedia", null);
    }

    @FXML
    void keJadwalAksi(MouseEvent event) {
        VerifyLogin ver = XMLctrl.getVerify();
        if (ver.isVerifiedAdmin()) {
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/JadwalKegiatan");
            mainPane.setCenter(halaman);
        } else if (ver.isVerifiedUser()) {
            logout.setVisible(true);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/JadwalKegiatanUser");
            mainPane.setCenter(halaman);
        } else {
            logout.setVisible(false);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/JadwalKegiatanUser");
            mainPane.setCenter(halaman);
        }
    }

    @FXML
    void keLaporanKegiatan(MouseEvent event) {
        ShowAlert.showAlert(null, "Mohon Maaf, Fitur belum tersedia", null);
        // OpenScene object = new OpenScene();
        // Pane halaman = object.getPane("/View/LaporanKegiatan");
        // mainPane.setCenter(halaman);
    }

    @FXML
    void keBeranda(MouseEvent event) {
        VerifyLogin ver = XMLctrl.getVerify();
        if (ver.isVerifiedAdmin()) {
            logout.setVisible(true);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/Beranda");
            mainPane.setCenter(halaman);
        } else if (ver.isVerifiedUser()) {
            logout.setVisible(true);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/UserBeranda");
            mainPane.setCenter(halaman);
        } else {
            logout.setVisible(false);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/UserBeranda");
            mainPane.setCenter(halaman);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VerifyLogin ver = XMLctrl.getVerify();
        if (ver.isVerifiedAdmin()) {
            logout.setVisible(true);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/Beranda");
            mainPane.setCenter(halaman);
        } else if (ver.isVerifiedUser()) {
            logout.setVisible(true);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/UserBeranda");
            mainPane.setCenter(halaman);
        } else {
            logout.setVisible(false);
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/UserBeranda");
            mainPane.setCenter(halaman);
        }
    }

}
