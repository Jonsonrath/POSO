package at.htl.adventskalenderr;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class AdventskalenderController {
    @FXML
    private TilePane container;

    private ObservableList<Button> tueren = FXCollections.observableArrayList();
    private Date heutigesdatum = new Date();
    private AdventskalenderChecker datechecker = new AdventskalenderChecker();

    private void setButtonBackgroundImage(Button btn, URL imageurl) {
        if (imageurl != null) {
            String style =

                            "-fx-background-size: cover;" +
                            "-fx-background-position: center;" +
                            "-fx-background-repeat: no-repeat;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 80;" +
                            "-fx-opacity: 0.45;" +
                            "-fx-border-color: #1c1818;" +
                            "-fx-border-width: 4px;" +
                            "-fx-border-radius: 0px;";
            btn.setStyle(style);
        } else {
            System.out.println("URL für Button Hintergrund Bild ist NULL");
        }
    }


    private void updateTime(){
        heutigesdatum = new Date();
    }
    private void tageBisWeihnachten() {
        updateTime();
        long diffInMillies = new Date(2025, 12, 24).getTime() - heutigesdatum.getTime(); //Differenz in Millisekunden weil .getTime() gibts in Millisekunden
        long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
        System.out.println("Tage bis Weihnachten: " + diffInDays);
    }


    @FXML
    Button gobackbutton;

    @FXML
    public void initialize() {

        gobackbutton.setDisable(true);
        gobackbutton.setVisible(false);

        URL linus = AdventskalenderApplication.class.getResource("/images/linustorvalds.jpg");
        URL terry = AdventskalenderApplication.class.getResource("/images/terrydaviscover.jpg");
        URL tuxxmassanta = AdventskalenderApplication.class.getResource("/images/tuxxmassanta.jpg");
        URL gabesanta = AdventskalenderApplication.class.getResource("/images/gabesantaselfmade.jpg");
        URL gabexmas = AdventskalenderApplication.class.getResource("/images/gabenewellxmas.jpg");
        URL gabexmassanta = AdventskalenderApplication.class.getResource("/images/gabenewellsanta.jpg");


        // Tile Pane properties verändern damit Buttons geordnet werden und in der mitte sind
        container.setTileAlignment(Pos.CENTER);
        container.setPrefColumns(6);
        // give the container some padding so buttons don't touch the window edges
        container.setPadding(new Insets(12));
        // komisches StackOverflow Mathe damit Buttons Immer richtig groß sind
        //DoubleBinding wird hergenommen um das zu berechnen
        DoubleBinding tileWidth = container.widthProperty().subtract((container.getHgap() * (container.getPrefColumns() - 1))).subtract(60)
                .divide(container.getPrefColumns());

        // 4 Reihen 6 Spalten -> 24 Buttons
        int rows = (int) Math.ceil(24.0 / container.getPrefColumns());
        DoubleBinding tileHeight = container.heightProperty().subtract((container.getVgap() * (rows - 1))).subtract(60)
                .divide(rows);




        for (int i = 1; i <= 24; i++) {
            Button btn = new Button("Tür " + i);
            btn.setText("" + i);

            // apply calendar CSS class for text, border, etc. We'll override background by setting it inline and animate that.
            if (!btn.getStyleClass().contains("calendar-button")) {
                btn.getStyleClass().add("calendar-button");
            }
            // don't set a per-button BackgroundImage here (it previously referenced an out-of-scope variable).
            // Buttons will get their translucent white background via updateButtonBackground(), and the container has the background image.

            if(i % 6 == 1) {
                setButtonBackgroundImage(btn, linus);
            } else if (i % 6 == 2) {
                setButtonBackgroundImage(btn, terry);
            } else if (i % 6 == 3) {
                setButtonBackgroundImage(btn, tuxxmassanta);
            }else if(i % 6 == 4){
                setButtonBackgroundImage(btn, gabexmassanta);
            }else if(i % 6 == 5){
                setButtonBackgroundImage(btn, gabexmas);

            }else if(i % 6 == 0){
                setButtonBackgroundImage(btn, gabesanta);
            }else{
                setButtonBackgroundImage(btn, null); // sonst geht kapputt weil null dann übergeben wird
            }




            // Buttons auf max werte setzen und an die berechneten tile sizes binden
            btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            btn.prefWidthProperty().bind(tileWidth);
            btn.prefHeightProperty().bind(tileHeight);

            btn.setOnAction(e -> buttonClicked((Button)e.getSource()));






            // zu liste adden und in container machen
            tueren.add(btn);
            container.getChildren().add(btn);
        }
    }



    private void buttonClicked(Button btn) {

        System.out.println("Button " + btn.getText() + " clicked!");
        System.out.println("Button Class = " + btn.getStyleClass());
        int tuernummer = Integer.parseInt(btn.getText());
        if(datechecker.gueltigesDatum(new Date(2025, 12, tuernummer), false)) {

            for (Button b : tueren) {
                b.setVisible(false);
                b.setDisable(true);

            }
            gobackbutton.setDisable(false);
            gobackbutton.setVisible(true);

            gobackbutton.setMouseTransparent(false);
            gobackbutton.toFront();

        }

    }
    @FXML
    public void goBackButtonClicked(){
        for(Button b: tueren) {
            b.setVisible(true);
            b.setDisable(false);
        }
        gobackbutton.setDisable(true);
        gobackbutton.setVisible(false);

        gobackbutton.setMouseTransparent(true);
        gobackbutton.toBack();
    }
}
