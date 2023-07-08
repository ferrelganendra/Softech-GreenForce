package View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import Model.Account.Akun;
import Model.Account.Komunitas;
import Model.Account.Partisipan;
import util.XMLctrl;

public class DeskripsiAkun implements Initializable {

    @FXML
    private Label email;

    @FXML
    private Label iduser;

    @FXML
    private Label username;

    Akun user = XMLctrl.getCurrentAccount();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (user instanceof Komunitas) {
            Komunitas adm = (Komunitas) user;
            String id = adm.getID();
            String name = adm.getUsername();
            String email1 = adm.getEmail();
            username.setText(name);
            iduser.setText(id);
            email.setText(email1);
        } else if(user instanceof Partisipan) {
            Partisipan par = (Partisipan) user;
            String id = par.getID();
            String name = par.getUsername();
            String email1 = user.getEmail();
            username.setText(name);
            iduser.setText(id);
            email.setText(email1);
        }
    }
}
