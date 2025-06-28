module vn.codegym.employeemanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens vn.codegym.employeemanagement to javafx.fxml;
    exports vn.codegym.employeemanagement;
}