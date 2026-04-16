package at.htl.mitarbeitergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static at.htl.mitarbeitergui.MitarbeiterApplication.loadFXML;

public class MitarbeiterController {
    @FXML
    private Label welcomeText;

    @FXML
    private MenuButton AbbrechnungstypDropdown;
    @FXML
    private TextField NameInput;
    @FXML
    private TextField GehaltInput;
    @FXML
    private TextField Abbrechnungstyp;
    @FXML
    private TextField StundenlohnInput;
    @FXML
    private TextField GearbeiteteStundenInput;
    @FXML
    private TextField AbrechnungsperiodeInput;

    AngestelltenListe angestelltenListe = AngestelltenListe.getInstance();

    @FXML
    private void onMenuButtonSelectLohn(){
        AbrechnungsperiodeInput.disableProperty().setValue(true);
        GehaltInput.disableProperty().setValue(true);
        NameInput.disableProperty().setValue(false);
        StundenlohnInput.disableProperty().setValue(false);
        GearbeiteteStundenInput.disableProperty().setValue(false);


    }
    @FXML
    private void onMenuButtonSelectGehalt(){
        AbrechnungsperiodeInput.disableProperty().setValue(false);
        GehaltInput.disableProperty().setValue(false);
        NameInput.disableProperty().setValue(false);
        StundenlohnInput.disableProperty().setValue(true);
        GearbeiteteStundenInput.disableProperty().setValue(true);
    }
    @FXML
    private void switchScene(ActionEvent event) throws IOException {
        loadFXML("MitarbeiterAusrechnen");
    }



    @FXML
    private void addMitarbeiter(ActionEvent event) throws IOException {

        if(NameInput.getText().isEmpty()){
            ShowAlert("Name darf nicht leer sein!");
            return;
        }
        if(GehaltInput.getText().isEmpty()){
            ShowAlert("Gehalt darf nicht leer sein!");
            return;
        }
        if(StundenlohnInput.getText().isEmpty() && AbbrechnungstypDropdown.getText().equals("Lohn")){
            ShowAlert("Stundenlohn darf nicht leer sein!");
            return;
        }
        if(GearbeiteteStundenInput.getText().isEmpty() && GearbeiteteStundenInput.isDisable()==false){
            ShowAlert("Gearbeitete Stunden darf nicht leer sein!");
            return;
        }
        if(AbrechnungsperiodeInput.getText().isEmpty() && AbrechnungsperiodeInput.isDisable()==false){
            ShowAlert("Abrechnungsperiode darf nicht leer sein!");
            return;
        }

        String inputname = NameInput.getText();
        String inputgehalt = GehaltInput.getText();
        String inputstundenlohn = StundenlohnInput.getText();
        String inputgearbeiteteStunden = GearbeiteteStundenInput.getText();
        String inputabbrechnungstyp = AbbrechnungstypDropdown.getText();



        int stunden =  Integer.parseInt(inputstundenlohn);
        int gehalteuro = Integer.parseInt(inputgehalt);

        //int lohn, Gehaltstyp typ, int arbeitsstunden
        if(inputabbrechnungstyp.equals("Lohn")){
            int gearbeiteteStunden = Integer.parseInt(inputgearbeiteteStunden);
            Arbeiter lohnMitarbeiter = new Arbeiter(inputname, new Gehalt(stunden, Gehaltstyp.L, gearbeiteteStunden));
            angestelltenListe.add(lohnMitarbeiter);
        }
        else if(inputabbrechnungstyp.equals("Gehalt")){
            Angestellter gehaltMitarbeiter = new Angestellter(inputname, new Gehalt(gehalteuro, Gehaltstyp.G, AbrechnungsperiodeInput.getText()));
            angestelltenListe.add(gehaltMitarbeiter);
        }

    }

    private void ShowAlert(String message){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Eingabefehler");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }



}
