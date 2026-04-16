package com.example.ubungsbeispieltest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.Comparator;
import java.util.List;

public class IpAdressController {
    @FXML
    private Label IpAdressLabel;
    @FXML
    private TextField IpAdressInput;
    @FXML
    private Label HerstellerLabel;
    @FXML
    private TextField HerstellerInput;
    @FXML
    private Label AnzahlPortsLabel;
    @FXML
    private TextField AnzahlPortsInput;
    @FXML
    private Label ManagedLabel;
    @FXML
    private CheckBox ManagedCheckBox;
    @FXML
    private Button AddBtn;
    @FXML
    private Button SortIpBtn;
    @FXML
    private Button EmptyFieldsBtn;
    @FXML
    private ListView<Geraet> ListView;

    private ObservableList<Geraet> Geraete;

    private List<TextField> TextFields;

    private void addGeraet(Geraet geraet) {
        Geraete.add(geraet);
    }

    @FXML
    private void initialize() {
        Geraete = FXCollections.observableArrayList();
        // set the observable list as the ListView's items (don't reassign the injected field)
        if (ListView != null) {
            ListView.setItems(Geraete);
        }

        // initialize the TextFields list after FXML injection so fields are not null
        TextFields = List.of(IpAdressInput, HerstellerInput, AnzahlPortsInput);
    }

    @FXML
    protected void AddBtnAction(ActionEvent event) {
        String ipAdress = IpAdressInput.getText();
        String hersteller = HerstellerInput.getText();
        if (AnzahlPortsInput.getText().isEmpty()) {
            // add Switch
            boolean managed = ManagedCheckBox.isSelected();
            Switch sw = new Switch(ipAdress, hersteller, managed);
            addGeraet(sw);
        } else{
            // add Router
            int anzahlPorts = Integer.parseInt(AnzahlPortsInput.getText());
            Router router = new Router(anzahlPorts,  ipAdress, hersteller);
            addGeraet(router);
        }
    }
    private long ipToLong(String ipAdress) {
        String[] octets = ipAdress.split("\\.");
        long result = 0;
        for (int i = 0; i < octets.length; i++) {
            result += Integer.parseInt(octets[i]);
        }
        return result;
    }
    @FXML
    protected void SortIpBtnAction(ActionEvent event) {
        ListView.getItems().sort(
                Comparator.comparing(g -> ipToLong(g.getIpAdress()))
        );
    }
    @FXML
    protected void EmptyFieldsBtnAction(ActionEvent event) {
        if (TextFields == null) return;
        for (TextField tf : TextFields) {
            if (tf != null) tf.clear();
        }
    }



}
