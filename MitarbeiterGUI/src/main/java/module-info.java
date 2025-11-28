module at.htl.mitarbeitergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens at.htl.mitarbeitergui to javafx.fxml;
    exports at.htl.mitarbeitergui;
}