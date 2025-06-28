    package vn.codegym.demo2;

    import javafx.fxml.FXML;
    import javafx.scene.control.Label;
    import javafx.stage.Stage;

    public class HelloController {
        @FXML
        private Label welcomeText;
        private Stage stage;

        @FXML
        protected void onHelloButtonClick() {
            welcomeText.setText("Welcome to JavaFX Application!");
        }

        @FXML
        protected void onUndoButtonClick() {}
    }