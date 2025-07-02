package vn.codegym.employeemanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
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

    private final EmployeeManager employeeManager = new EmployeeManager();
    private final ObservableList<Employee> employeesList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        employeeManager.addEmployee(new Employee("Nguyen Van A", 30, "Hanoi", "a.nguyen@example.com", "0901234567"));
        employeeManager.addEmployee(new Employee("Tran Thi B", 25, "Da Nang", "b.tran@example.com", "0912345678"));

        refreshTable();
    }

    @FXML
    public void onAdd() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String address = addressField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneField.getText();

            Employee newEmployee = new Employee(name, age, address, email, phoneNumber);
            employeeManager.addEmployee(newEmployee);

            refreshTable();
            clearInput();
        } catch (NumberFormatException e) {
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

    @FXML
    public void onSearch() {

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

}
