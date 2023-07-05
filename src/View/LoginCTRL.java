package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DataBase.AkunStorage;
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
import Model.Account.Akun;
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

    private ArrayList<Komunitas> komunitas = new ArrayList<>(adminKomunitas());
    private ArrayList<Partisipan> partisipan = new ArrayList<>(partisipanUsers());

    public ArrayList<Komunitas> getKomunitas() {
        return komunitas;
    }

    public ArrayList<Partisipan> getPartisipan() {
        return partisipan;
    }

    @FXML
    void createAccount(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/View/SignUp");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    @FXML
    private void loginButtonClicked() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Akun account = AkunStorage.getAccountByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            if (account != null && account.getPassword().equals(password)) {
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/Beranda");
            MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
            ShowAlert.showAlert("Sukses", "Login Berhasil", "Selamat datang, " + username + "!");
        } else {
            ShowAlert.showAlert("Kesalahan", "Login Gagal", "Username atau password salah.");
        }
        }
    }

    @FXML
    private void loginAsAdminClicked() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(komunitas.get(0).getUsername()) && password.equals(komunitas.get(0).getPassword())) {
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/Beranda");
            MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
        } else {
            ShowAlert.showAlert("Kesalahan", "Login Gagal", "Username atau password salah.");
        }
    }

    // Akun admin komunitas
    public ArrayList<Komunitas> adminKomunitas() {
        ArrayList<Komunitas> admin = new ArrayList<>();
        Komunitas admin1 = new Komunitas(null, null, null);
        admin1.setEmail("admin1@gmail.com");
        admin1.setUsername("admin");
        admin1.setPassword("admin123");
        admin.add(admin1);

        return admin;
    }

    // Akun admin partisipan
    public ArrayList<Partisipan> partisipanUsers() {
        ArrayList<Partisipan> partisipan = new ArrayList<>();
        Partisipan partisipan1 = new Partisipan(null, null, null);
        partisipan1.setEmail("admin1@gmail.com");
        partisipan1.setUsername("admin");
        partisipan1.setPassword("admin123");
        partisipan.add(partisipan1);

        return partisipan;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
