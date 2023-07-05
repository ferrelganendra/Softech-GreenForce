package View;

import java.io.IOException;
import DataBase.AkunStorage;
import Main.MainPaneCTRL;
import Model.Account.Akun;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import util.OpenScene;
import util.ShowAlert;

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

    @FXML
    private void SignUpAddAccount() throws IOException {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            ShowAlert.showAlert("Peringatan", "Isian Kosong", "Semua isian harus diisi.");
        } else if (!password.equals(confirmPassword)) {
            ShowAlert.showAlert("Peringatan", "Password Tidak Cocok", "Password dan konfirmasi password tidak cocok.");
        } else {
            Akun newAccount = new Akun(name, email, password);
            AkunStorage.addAccount(newAccount);

            ShowAlert.showAlert("Sukses", "Akun Berhasil Dibuat",
                    "Akun dengan nama " + name + " dan email " + email + " telah berhasil dibuat.");
            clearFields();
            OpenScene object = new OpenScene();
            Pane halaman = object.getPane("/View/Login");
            MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
        }
    }

    private void clearFields() {
        nameField.clear();
        emailField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
    }
}