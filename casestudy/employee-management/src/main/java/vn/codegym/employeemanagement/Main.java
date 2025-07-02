package vn.codegym.employeemanagement;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private EmployeeManager employeeManager = new EmployeeManager();
    @Override
    public void start(Stage stage) throws IOException {
        employeeManager.loadFromFile();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        MainController mainController = fxmlLoader.getController();
        mainController.setEmployeeManager(employeeManager);
        stage.setTitle("Employee list manager");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        employeeManager.saveToFile("employees.dat");
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}