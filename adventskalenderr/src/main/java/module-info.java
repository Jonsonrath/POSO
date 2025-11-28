module at.htl.adventskalenderr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens at.htl.adventskalenderr to javafx.fxml;
    exports at.htl.adventskalenderr;
}