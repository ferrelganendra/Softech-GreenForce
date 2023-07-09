package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Home.Artikel.ACardCTRL;
import Home.Artikel.ArtikelEditCTRL;
import Home.Berita.BCard;
import Home.Berita.BeritaEdit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.FileManager;
import util.OpenScene;
import util.ShowAlert;
import util.XMLctrl;
import Model.Artikel.Artikel;
import Model.Artikel.Berita;
import Main.MainPaneCTRL;

public class BerandaCTRL {

    @FXML
    private TextField indexDelete;

    @FXML
    private TextField indexDelete1;

    @FXML
    private HBox HBoxBerita;

    @FXML
    private HBox HBoxArtikel;

    private HBox cardBox;
    private HBox cardBox2;

    private Map<String, HBox> cardBoxMap = new HashMap<>();

    private Map<String, HBox> cardBoxMap2 = new HashMap<>();

    ArrayList<Artikel> artikelGreenForce = XMLctrl.getArtikel();

    ArrayList<Berita> beritaGreenForce = XMLctrl.getBerita();

    @FXML
    void addArtikel(MouseEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/Home/Artikel/AddArtikel");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    @FXML
    void addBerita(MouseEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("/Home/Berita/AddBerita");
        MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
    }

    @FXML
    void hapusArtikel(MouseEvent event) throws IOException {
        String targetId = indexDelete.getText();
        if (targetId != "") {
            HBox targetCardBox = cardBoxMap.get(targetId);
            Artikel artikelToRemove = artikelGreenForce.get(Integer.valueOf(indexDelete.getText()));
            String imagePath = artikelToRemove.getImgSrc();
            if (targetCardBox != null) {
                boolean konfirmasi = ShowAlert.showConfirmation("Konfirmasi",
                        "Apakah Anda yakin akan menghapus Artikel ini?");
                if (konfirmasi) {
                    HBoxArtikel.getChildren().remove(targetCardBox);
                    OpenScene object = new OpenScene();
                    Pane halaman = object.getPane("/View/Beranda");
                    MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
                    artikelGreenForce.remove(artikelToRemove);
                    XMLctrl.saveArtikel(artikelGreenForce);
                    FileManager.deleteImageFromResource(imagePath);
                }
            } else {
                ShowAlert.showAlert("Error", "Berita dengan index " + targetId + " tidak ada", "Index dimulai dari 0");
            }
            indexDelete.setText("");
        }
    }

    @FXML
    void hapusBerita(MouseEvent event) throws IOException {
        String targetId = indexDelete1.getText();
        if (targetId != "") {
            HBox targetCardBox = cardBoxMap2.get(targetId);
            Berita beritaToRemove = beritaGreenForce.get(Integer.valueOf(indexDelete1.getText()));
            String imagePath = beritaToRemove.getImgSrc();
            if (targetCardBox != null) {
                boolean konfirmasi = ShowAlert.showConfirmation("Konfirmasi",
                        "Apakah Anda yakin akan menghapus Artikel ini?");
                if (konfirmasi) {
                    HBoxBerita.getChildren().remove(targetCardBox);
                    OpenScene object = new OpenScene();
                    Pane halaman = object.getPane("/View/Beranda");
                    MainPaneCTRL.getInstance().getMainPane().setCenter(halaman);
                    beritaGreenForce.remove(beritaToRemove);
                    XMLctrl.saveBerita(beritaGreenForce);
                    FileManager.deleteImageFromResource(imagePath);
                }
            } else {
                ShowAlert.showAlert("Error", "Berita dengan index " + targetId + " tidak ada", "Index dimulai dari 0");
            }
            indexDelete1.setText("");
        }

    }

    @FXML
    public void initialize() throws IOException {
        /*
         * LOAD ARTIKEL
         */
        for (int i = 0; i < artikelGreenForce.size(); i++) {
            // Mengload card artikel
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Home/Artikel/ACard.fxml"));
            cardBox = fxmlLoader.load();
            ACardCTRL cardCTRL = fxmlLoader.getController();
            cardCTRL.setData(artikelGreenForce.get(i));
            cardBox.setId("" + i);
            cardBoxMap.put(cardBox.getId(), cardBox);
            HBoxArtikel.getChildren().add(cardBox);

            cardBox.setOnMouseExited(event -> {
                cardCTRL.getJudulArtikel().setVisible(false);
                cardCTRL.getKotakText().setVisible(false);
            });

            cardBox.setOnMouseEntered(event -> {
                cardCTRL.getJudulArtikel().setVisible(true);
                cardCTRL.getKotakText().setVisible(true);
            });

            // Mengload page untuk mengedit artikel
            FXMLLoader artikelLoader = new FXMLLoader();
            artikelLoader.setLocation(getClass().getResource("/Home/Artikel/ArtikelEdit.fxml"));
            VBox artikel = artikelLoader.load();
            ArtikelEditCTRL artikelEditCTRL = artikelLoader.getController();
            artikel.setId("" + i);
            artikelEditCTRL.setData(artikelGreenForce.get(i));

            if (HBoxArtikel.getChildren().get(i).equals(cardBox)) {
                cardBox.setOnMouseClicked(event -> {
                    MainPaneCTRL.getInstance().getMainPane().setCenter(artikel);
                });
            }
        }

        /*
         * LOAD BERITA
         */
        for (int i = 0; i < beritaGreenForce.size(); i++) {
            // Mengload card berita
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Home/Berita/BCard.fxml"));
            cardBox2 = fxmlLoader.load();
            BCard cardCTRL = fxmlLoader.getController();
            cardCTRL.setDataBerita(beritaGreenForce.get(i));
            cardBox2.setId("" + i);
            cardBoxMap2.put(cardBox2.getId(), cardBox2);
            HBoxBerita.getChildren().add(cardBox2);

            cardBox2.setOnMouseExited(event -> {
                cardCTRL.getJudulBerita().setVisible(false);
                cardCTRL.getKotakText().setVisible(false);
            });

            cardBox2.setOnMouseEntered(event -> {
                cardCTRL.getJudulBerita().setVisible(true);
                cardCTRL.getKotakText().setVisible(true);
            });

            // Mengload page untuk mengedit berita
            FXMLLoader beritaLoader = new FXMLLoader();
            beritaLoader.setLocation(getClass().getResource("/Home/Berita/BeritaEdit.fxml"));
            VBox berita = beritaLoader.load();
            BeritaEdit BeritaEdit = beritaLoader.getController();
            berita.setId("" + i);
            BeritaEdit.setData(beritaGreenForce.get(i));

            if (HBoxBerita.getChildren().get(i).equals(cardBox2)) {
                cardBox2.setOnMouseClicked(event -> {
                    MainPaneCTRL.getInstance().getMainPane().setCenter(berita);
                });
            }
        }
    }
}
