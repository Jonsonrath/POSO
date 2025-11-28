module at.htl.adventskalender {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens at.htl.adventskalender to javafx.fxml;
    exports at.htl.adventskalender;
}