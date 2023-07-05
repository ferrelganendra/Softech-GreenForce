package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Home.Artikel.ACardCTRL;
import Home.Artikel.ArtikelViewCTRL;
import Home.Berita.BCard;
import Home.Berita.BeritaView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util.XMLctrl;
import Model.Artikel.Artikel;
import Model.Artikel.Berita;
import Main.MainPaneCTRL;

public class UserBerandaCTRL {

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

            // Mengload page untuk melihat artikel
            FXMLLoader artikelLoader = new FXMLLoader();
            artikelLoader.setLocation(getClass().getResource("/Home/Artikel/ArtikelView.fxml"));
            VBox artikel = artikelLoader.load(); //error
            ArtikelViewCTRL artikelView = artikelLoader.getController();
            artikel.setId("" + i);
            artikelView.setData(artikelGreenForce.get(i));

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
            beritaLoader.setLocation(getClass().getResource("/Home/Berita/BeritaView.fxml"));
            VBox berita = beritaLoader.load();
            BeritaView BeritaView = beritaLoader.getController();
            berita.setId("" + i);
            BeritaView.setData(beritaGreenForce.get(i));

            if (HBoxBerita.getChildren().get(i).equals(cardBox2)) {
                cardBox2.setOnMouseClicked(event -> {
                    MainPaneCTRL.getInstance().getMainPane().setCenter(berita);
                });
            }
        }
    }
}
