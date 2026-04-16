module com.example.ubungsbeispieltest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ubungsbeispieltest to javafx.fxml;
    exports com.example.ubungsbeispieltest;
}