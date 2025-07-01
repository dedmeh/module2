module vn.codegym.employeemanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens vn.codegym.employeemanagement to javafx.fxml;
    exports vn.codegym.employeemanagement;
}