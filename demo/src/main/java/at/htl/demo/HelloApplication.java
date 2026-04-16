package at.htl.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("TITEL");
        stage.setScene(scene);

        Image icon = new Image(HelloApplication.class.getResourceAsStream("/at/htl/demo/icon.png"));

        stage.getIcons().add(
          new javafx.scene.image.Image(HelloApplication.class.getResourceAsStream("/at/htl/demo/nixos-icon.jpg"))
        );

        stage.show();
    }
}
