module vn.codegym.casestudy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens vn.codegym.casestudy to javafx.fxml;
    exports vn.codegym.casestudy;
}