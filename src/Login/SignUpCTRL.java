package Login;

import java.io.IOException;
import java.util.ArrayList;

import Main.MainPaneCTRL;
import Model.Account.Partisipan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import util.OpenScene;
import util.ShowAlert;
import util.XMLctrl;

public class SignUpCTRL {

    @FXML
    private TextField emailField;

    @FXML
    private Button SignUp;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField nameField;

    ArrayList<Partisipan> userBaru = XMLctrl.getUser();

    @FXML
    private void SignUpAddAccount() throws IOException {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            ShowAlert.showAlert1("Peringatan", "Isian Kosong", "Semua isian harus diisi.");
        } else if (!password.equals(confirmPassword)) {
            ShowAlert.showAlert1("Peringatan", "Password Tidak Cocok", "Password dan konfirmasi password tidak cocok.");
        } else {
            Partisipan newAccount = new Partisipan(name, confirmPassword, email);
            userBaru.add(newAccount);
            XMLctrl.saveUser(userBaru);

            ShowAlert.showAlert1("Sukses", "Akun Berhasil Dibuat",
                    "Akun dengan nama " + name + " dan email " + email + " telah berhasil dibuat.");
            clearFields();
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/Login/Login");
            MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
        }
    }

    private void clearFields() {
        nameField.clear();
        emailField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
    }

    @FXML
    void keLogin(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/Login/Login");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }
}