package Login;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Main.MainPaneCTRL;
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
        Partisipan user1 = null;
        for (int i = 0; i < user.size(); i++) {
            user1 = user.get(i);
            if (user1 != null && user1.getEmail().equals(password) && user1.getUsername().equals(username)) {
                OpenScene object = new OpenScene();
                Pane halaman = object.getPane("/View/Beranda");
                MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
                ShowAlert.showAlert("Sukses", "Login Berhasil", "Selamat datang, " + username + "!");
            }
        }
        if (!(user1 != null && user1.getEmail().equals(password) && user1.getUsername().equals(username))) {
            ShowAlert.showAlert1("Kesalahan", "Login Gagal", "Username atau password salah.");
        }
    }

    @FXML
    private void loginAsAdminClicked() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Komunitas adm = null;

        for (int i = 0; i < admin.size(); i++) {
            adm = admin.get(i);
            if (adm != null && adm.getEmail().equals(password) && adm.getUsername().equals(username)) {
                OpenScene object = new OpenScene();
                Pane halaman = object.getPane("/View/Beranda");
                MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
                ShowAlert.showAlert("Sukses", "Login Berhasil", "Selamat datang, " + username + "!");
            }
        }
        if (!(adm != null && adm.getEmail().equals(password) && adm.getUsername().equals(username))) {
            ShowAlert.showAlert1("Kesalahan", "Login Gagal", "Username atau password salah.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
