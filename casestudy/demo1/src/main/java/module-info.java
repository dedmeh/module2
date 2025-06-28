module vn.codegym.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens vn.codegym.demo1 to javafx.fxml;
    exports vn.codegym.demo1;
}