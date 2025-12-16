package at.htl.adventskalenderr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdventskalenderApplication extends Application {

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(AdventskalenderApplication.class.getResource("Adventskalender-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 1280, 640);
            stage.setTitle("Adventskalender!");


            URL bgUrl = AdventskalenderApplication.class.getResource("/images/xmastux.jpg");
            if (bgUrl == null) { //dann gibts die datei nicht
                System.out.println("Background image not found at /images/xmastux.jpg");
            } else {
                //bild von der URL von oben machen
                Image img = new Image(bgUrl.toExternalForm());
                if (root instanceof Region) { //nur regionen können hintergründe haben, Region ist eine superklasse von TilePane
                    BackgroundImage bgImage = new BackgroundImage( //BackgroundImage setzen
                            img,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundRepeat.NO_REPEAT, //2 mal no repeat weil sonst error
                            BackgroundPosition.CENTER,
                            //100% breite und höhe vom bild
                            new BackgroundSize(100, 100, true, true, false, true)
                            // 100 und zweites 100 sind in prozent weil b und b1 true sind
                            //b2 false weil kein zuschneiden
                            //b3 true damit bild immer skaliert wird
                    );
                    //schwarze stackoverflow magie zum hintergrund setzen
                    ((Region) root).setBackground(new Background(bgImage));
                } else {
                    System.out.println("Root node is not a Region; cannot set background image.");

                }
            }

            URL cssUrl = AdventskalenderApplication.class.getResource("style.css");
            if (cssUrl == null) {
                System.out.println("style.css not found at package path at/htl/adventskalenderr/style.css");
            } else {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            }

            stage.setScene(scene);
            stage.show();

            scene.setOnKeyPressed(e ->{
               if(e.getCode() == KeyCode.C){
                   AdventskalenderController.toggleCheatMode();
               }
            });

        }


}
