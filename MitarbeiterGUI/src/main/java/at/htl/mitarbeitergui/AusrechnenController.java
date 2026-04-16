package at.htl.mitarbeitergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AusrechnenController {

    @FXML
    private TableView<Mitarbeiter> mitarbeiterTable;

    private final AngestelltenListe angestelltenListe = AngestelltenListe.getInstance();

    // ❗ Types must match getters in Mitarbeiter
    @FXML
    private TableColumn<Mitarbeiter, String> colName;
    @FXML
    private TableColumn<Mitarbeiter, String> colTyp;
    @FXML
    private TableColumn<Mitarbeiter, Integer> colBetrag;

    @FXML
    private void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));     // getName()
        colTyp.setCellValueFactory(new PropertyValueFactory<>("typ"));       // getTyp()
        colBetrag.setCellValueFactory(new PropertyValueFactory<>("betrag")); // getBetrag()

        if (angestelltenListe.getObservableList().isEmpty()) {
            angestelltenListe.addBeispielDaten();
        }
        mitarbeiterTable.setItems(angestelltenListe.getObservableList());
    }

    @FXML
    private void switchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MitarbeiterApplication.class.getResource("MitarbeiterHinzufuegen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 640, 680));
    }
}
