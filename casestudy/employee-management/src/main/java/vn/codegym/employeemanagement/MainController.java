package vn.codegym.employeemanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class MainController {

    private EmployeeManager employeeManager;
    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
        refreshTable();
    }
    @FXML
    private TableView<Employee> employeesTable;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Integer> ageColumn;
    @FXML
    private TableColumn<Employee, String> addressColumn;
    @FXML
    private TableColumn<Employee, String> emailColumn;
    @FXML
    private TableColumn<Employee, String> phoneColumn;

    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField searchField;

    private final ObservableList<Employee> employeesList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

    }

    @FXML
    public void onAdd() {
        try {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneField.getText();

            int age = 0;
            try {
                age = Integer.parseInt(ageText);
                if (!EmployeeValidator.validateAge(age)) {
                    showAlert("Validation error", "Please enter a valid age");
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (!EmployeeValidator.validateEmail(email)) {
                showAlert("Validation error", "Please enter a valid email");
                return;
            }
            if (!EmployeeValidator.validatePhone(phoneNumber)) {
                showAlert("Validation error", "Please enter a valid phone number");
                return;
            }

            Employee newEmployee = new Employee(name, age, address, email, phoneNumber);
            employeeManager.addEmployee(newEmployee);


            refreshTable();
            clearInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEdit() {
        Employee selectedEmployee = employeesTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            try {
                nameField.setText(selectedEmployee.getName());
                ageField.setText(String.valueOf(selectedEmployee.getAge()));
                addressField.setText(selectedEmployee.getAddress());
                emailField.setText(selectedEmployee.getEmail());
                phoneField.setText(selectedEmployee.getPhoneNumber());

                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String address = addressField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneField.getText();

                employeeManager.editEmployee(selectedEmployee, name, age, address, email, phoneNumber);

                refreshTable();
                clearInput();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onDelete() {
        Employee selectedEmployee = employeesTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {

            employeeManager.deleteEmployee(selectedEmployee);
            refreshTable();
        }
    }

    private void refreshTable() {
        employeesList.setAll(employeeManager.getEmployeesList());
        employeesTable.setItems(employeesList);
    }

    private void clearInput() {
        nameField.clear();
        ageField.clear();
        addressField.clear();
        emailField.clear();
        phoneField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean confirmSave() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK && result.isPresent() ) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    public void onSave() {
        boolean shouldSave = confirmSave();
        if (shouldSave) {
            employeeManager.saveToFile("employees.dat");
            showAlert("Save successful", "Employee data saved successfully");
        }
    }
}
