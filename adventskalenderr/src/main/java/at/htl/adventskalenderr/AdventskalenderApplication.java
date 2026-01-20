package at.htl.adventskalenderr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdventskalenderApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AdventskalenderApplication.class.getResource("Adventskalender-view.fxml"));
        Parent root = fxmlLoader.load();

        // Get controller instance
        AdventskalenderController controller = fxmlLoader.getController();

        Scene scene = new Scene(root, 1280, 640);
        stage.setTitle("Adventskalender!");

        // Set background image
        URL bgUrl = AdventskalenderApplication.class.getResource("/images/xmastux.jpg");
        if (bgUrl != null && root instanceof Region) {
            Image img = new Image(bgUrl.toExternalForm());
            BackgroundImage bgImage = new BackgroundImage(
                    img,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(100, 100, true, true, false, true)
            );
            ((Region) root).setBackground(new Background(bgImage));
        } else if (bgUrl == null) {
            System.out.println("Background image not found at /images/xmastux.jpg");
        } else {
            System.out.println("Root node is not a Region; cannot set background image.");
        }

        // Add CSS
        URL cssUrl = AdventskalenderApplication.class.getResource("style.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.out.println("style.css not found at package path at/htl/adventskalenderr/style.css");
        }

        stage.getIcons().add(new Image(AdventskalenderApplication.class.getResourceAsStream("/images/templeosxmas.jpg")));

        stage.setScene(scene);
        stage.show();

        // Key listener: toggle cheat mode and refresh doors
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.C) {
                controller.toggleCheatMode(); // instance method
                controller.refreshDoors();    // instance method
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
