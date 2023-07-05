package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author softech
 */
public class GreenForce extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Main/MainPane.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("GreenForce");
        stage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("../Resource/LogoIcon.png"));
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
