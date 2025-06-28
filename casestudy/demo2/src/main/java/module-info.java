module vn.codegym.demo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens vn.codegym.demo2 to javafx.fxml;
    exports vn.codegym.demo2;
}