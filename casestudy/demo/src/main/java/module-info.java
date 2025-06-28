module vn.codegym.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens vn.codegym.demo to javafx.fxml;
    exports vn.codegym.demo;
}