module at.htl.zahlenratengui {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htl.zahlenratengui to javafx.fxml;
    exports at.htl.zahlenratengui;
}