package at.htl.mitarbeitergui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MitarbeiterApplication extends Application {
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(MitarbeiterApplication.class.getResource("MitarbeiterHinzufuegen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 640);
        stage.setTitle("Mitarbeiter");
        stage.setScene(scene);
        stage.show();*/

        primaryStage = stage;
        loadFXML("MitarbeiterHinzufuegen");
        primaryStage.setTitle("Mitarbeiter");
        primaryStage.show();

    }
    public static void loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MitarbeiterApplication.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root, 640, 680));
    }
}
