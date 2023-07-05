package util;

import java.net.URL;

import Main.GreenForce;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


/**
 * @author andhika
 */
public class OpenScene {
    private Pane halaman;

    public Pane getPane(String fileName) {
        try {
            URL fileHalaman = GreenForce.class.getResource(fileName + ".fxml");

            if (fileHalaman == null) {
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }

            new FXMLLoader();
            halaman = FXMLLoader.load(fileHalaman);

        } catch (Exception e) {
            System.out.println("Tidak ditemukan halaman tersebut");
            e.printStackTrace();
        }

        return halaman;
    }
}
