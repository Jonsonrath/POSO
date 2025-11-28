module at.htl.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens at.htl.demo to javafx.fxml;
    exports at.htl.demo;
}