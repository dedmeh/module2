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
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEdit() {
//        employeeManager.editEmployee();
    }

    @FXML
    public void onDelete() {
//        employeeManager.deleteEmployee();
    }

    @FXML
    public void onSearch() {

    }

    private void refreshTable() {
        employeesList.setAll(employeeManager.getEmployeesList());
        employeesTable.setItems(employeesList);
    }

}
