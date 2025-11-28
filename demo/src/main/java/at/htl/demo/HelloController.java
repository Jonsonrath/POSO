package at.htl.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;

import java.awt.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Java ist scheisse!");
        welcomeText.setTextFill(Paint.valueOf("red"));
    }

}
