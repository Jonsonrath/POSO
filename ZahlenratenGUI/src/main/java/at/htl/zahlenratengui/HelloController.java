package at.htl.zahlenratengui;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class HelloController {


    @FXML
    private Label outputLabel;
    @FXML
    private Zahlenraten raten;

    private int returnvalue = 0;

    @FXML
    private TextField inputfield;
    @FXML
    private Button guessbutton;
    @FXML
    private Slider slideLower;
    @FXML
    private Slider slideUpper;
    @FXML
    private void initialize() {
        raten = new Zahlenraten();
        // Add listener to slideLower (Min Slider)
        slideLower.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateLabel(); // Call the method to update the label
        });

        // Add listener to slideUpper (Max Slider)
        slideUpper.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateLabel(); // Call the method to update the label
        });
    }
    @FXML
    protected void updateLabel() {
        int upper = (int) slideUpper.getValue();
        int lower = (int) slideLower.getValue();

        String labelText = String.format("Min Slider: %d\nMax Slider: %d",
                lower, upper, "Additional information if needed");
        outputLabel.setText(labelText); // Update the label with the formatted text
    }
    @FXML
    protected void onGuessButton() {
        //welcomeText.setText("Welcome to JavaFX Application!");
        int guess =  Integer.parseInt(inputfield.getText());

        returnvalue = raten.Guess(guess);

        if(returnvalue == 0){
            guessbutton.setDisable(true);
        }

        outputLabel.setText(raten.GetOutput());
    }
    @FXML
    protected void neuesSpiel(){
        guessbutton.setDisable(false);
        int upper;
        int lower;

        upper = (int) slideUpper.getValue();
        lower = (int) slideLower.getValue();

        IO.println(slideLower.getValue());
        IO.println(slideUpper.getValue());

        raten.NewNumber(upper, lower);
        outputLabel.setText("Neues Spiel");
    }
}
