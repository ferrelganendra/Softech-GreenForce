package Login;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Main.MainPaneCTRL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import util.OpenScene;
import util.ShowAlert;
import util.VerifyLogin;
import util.XMLctrl;
import Model.Account.Komunitas;
import Model.Account.Partisipan;

public class LoginCTRL implements Initializable {

    @FXML
    private AnchorPane LoginPane;

    @FXML
    private Hyperlink LoginAsAdmin;

    @FXML
    private Hyperlink create;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    ArrayList<Partisipan> user = XMLctrl.getUser();
    ArrayList<Komunitas> admin = XMLctrl.getAdmin();

    @FXML
    void createAccount(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/Login/SignUp");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    @FXML
    private void loginButtonClicked() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Partisipan userMatch = null;
        for (int i = 0; i < user.size(); i++) {
            Partisipan user1 = user.get(i);
            if (user1 != null && user1.getPassword().equals(password) && user1.getUsername().equals(username)) {
                userMatch = user1;
                break;
            }
        }
        if (userMatch != null) {
            VerifyLogin ver = new VerifyLogin();
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/UserBeranda");
            MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
            MainPaneCTRL.getInstance().setLogOut(true);
            ShowAlert.showAlert("Sukses", "Login Berhasil", "Selamat datang, " + username + "!");
            ver.setAdminVerified(false);
            ver.setUserVerified(true);
            XMLctrl.saveVerify(ver);
            XMLctrl.saveCurrentAccount(userMatch);
            MainPaneCTRL.getInstance().getMainPane().setTop(MainPaneCTRL.getInstance().getTopMainPane());
        } else {
            ShowAlert.showAlert1("Kesalahan", "Login Gagal", "Username atau password salah.");
        }
    }

    @FXML
    private void loginAsAdminClicked() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Komunitas adminMatch = null;
        for (int i = 0; i < admin.size(); i++) {
            Komunitas adm = admin.get(i);
            if (adm != null && adm.getPassword().equals(password) && adm.getUsername().equals(username)) {
                adminMatch = adm;
                break;
            }
        }
        if (adminMatch != null) {
            Komunitas finalAdminMatch = adminMatch;
            VerifyLogin ver = new VerifyLogin();
            ver.setAdminVerified(true);
            ver.setUserVerified(false);
            XMLctrl.saveVerify(ver);
            XMLctrl.saveCurrentAccount(finalAdminMatch);
            Platform.runLater(() -> {
                // Logika aksi setelah logout
                OpenScene object = new OpenScene();
                Pane halaman = object.getPane("/View/Beranda");
                MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
                MainPaneCTRL.getInstance().setLogOut(true);
                ShowAlert.showAlert("Sukses", "Login Berhasil", "Selamat datang, " + username + "!");
            });
        } else {
            ShowAlert.showAlert1("Kesalahan", "Login Gagal", "Username atau password salah.");
        }
    }

    @FXML
    private void kembaliKeberanda() {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/UserBeranda");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
