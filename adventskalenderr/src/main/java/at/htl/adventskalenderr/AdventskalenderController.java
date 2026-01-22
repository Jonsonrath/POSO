package at.htl.adventskalenderr;

import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AdventskalenderController {

    @FXML
    private TilePane container;

    @FXML
    private Button gobackbutton;



    private ObservableList<Button> tueren = FXCollections.observableArrayList();
    private AdventskalenderChecker datechecker = new AdventskalenderChecker();
    private Stage bildStage;
    private static boolean cheatMode = false;

    @FXML
    public void initialize() {
        gobackbutton.setDisable(true);
        gobackbutton.setVisible(false);

        container.setTileAlignment(Pos.CENTER);
        container.setPrefColumns(6);
        container.setPadding(new Insets(12));

        // einmal initialisieren
        refreshDoors();

        // Key listener für C --> Cheatmode
        container.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(event -> {

                    if ("c".equals(event.getText())) {
                        refreshDoors();
                    }
                });
            }
        });

    }




    public void refreshDoors() {
        System.out.println("refreshing doors...");

        container.getChildren().clear();
        tueren.clear();


        //Stack Overflow Mathematik für automatisches resizen der Buttons je nachdem wie groß das Fenster ist
        // (Stauchen und Strecken von den Buttons bei Fenstergrößenänderung)
        DoubleBinding tileWidth = container.widthProperty()
                .subtract((container.getHgap() * (container.getPrefColumns() - 1))).subtract(60)
                .divide(container.getPrefColumns());
        int rows = (int) Math.ceil(24.0 / container.getPrefColumns());
        DoubleBinding tileHeight = container.heightProperty()
                .subtract((container.getVgap() * (rows - 1))).subtract(60)
                .divide(rows);

        LocalDate heute = LocalDate.now();
        int tag = heute.getDayOfMonth();
        if(cheatMode){
            tag = 24;
        }
        if(tag > 24){
            tag = 24;
        }

        for (int i = 1; i <= 24; i++) {
            Button btn = new Button(String.valueOf(i));
            btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            btn.prefWidthProperty().bind(tileWidth);
            btn.prefHeightProperty().bind(tileHeight);
            btn.getStyleClass().add("calendar-button");

            // Türchen die über dem tag sind deaktivieren
            if (i > tag) btn.setDisable(true);

            btn.setOnAction(e -> buttonClicked(btn));

            tueren.add(btn);
            container.getChildren().add(btn);
        }
    }

    private void buttonClicked(Button btn) {
        int tuernummer = Integer.parseInt(btn.getText());

        // Localdate zu normalen Date umwandeln weil Checker mit Date arbeitet
        LocalDate tuerDatum = LocalDate.of(2025, 12, tuernummer);
        Date date = Date.from(tuerDatum.atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (datechecker.gueltigesDatum(date, cheatMode)) {
            // Alle türen verstecken
            tueren.forEach(b -> {
                b.setVisible(false);
                b.setDisable(true);
            });

            gobackbutton.setDisable(false);
            gobackbutton.setVisible(true);
            gobackbutton.toFront();

            showPicture(tuernummer);
        } else {
            System.out.println("Ungueltiges Datum, Tuere darf nicht geoeffnet werden!");
        }
    }

    @FXML
    public void goBackButtonClicked() {
        tueren.forEach(b -> b.setVisible(true));
        tueren.forEach(b -> b.setDisable(false));

        gobackbutton.setDisable(true);
        gobackbutton.setVisible(false);
        gobackbutton.toBack();

        if (bildStage != null) bildStage.close();
    }

    public void showPicture(int tuernummer) {
        try {
            Bilder bilder = Bilder.valueOf("t" + tuernummer);
            String bildpfad = bilder.getPath();

            URL bildurl = AdventskalenderApplication.class.getResource(bildpfad);
            if (bildurl == null) {
                System.out.println("Bild URL ist NULL für Pfad: " + bildpfad);
                return;
            }

            FXMLLoader loader = new FXMLLoader(AdventskalenderApplication.class.getResource("bild.fxml"));
            Parent root = loader.load();

            BildController controller = loader.getController();
            controller.openPicture(new Image(bildurl.toExternalForm()));

            bildStage = new Stage();
            bildStage.getIcons().add(new Image(AdventskalenderApplication.class.getResourceAsStream("/images/templeosxmas.jpg")));
            bildStage.setTitle("Bild");
            bildStage.setScene(new Scene(root));
            bildStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void toggleCheatMode() {
        cheatMode = !cheatMode;
        System.out.println("Cheat Mode toggled! Cheat Mode is now: " + cheatMode);
    }
}
