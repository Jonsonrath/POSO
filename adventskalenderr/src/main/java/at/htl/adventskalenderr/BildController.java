package at.htl.adventskalenderr;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class BildController {

    @FXML
    ImageView bildView;

    @FXML
    public void openPicture(Image image) {
        System.out.println("Bild geöffnet!");
        bildView.setImage(image);
    }

}
