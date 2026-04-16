module com.example.tiersimulation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tiersimulation to javafx.fxml;
    exports com.example.tiersimulation;
}