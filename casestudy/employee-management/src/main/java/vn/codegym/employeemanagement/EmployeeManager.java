package vn.codegym.employeemanagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    private final List<Employee> employeesList = new ArrayList<>();

    public void addEmployee(Employee e) {
        employeesList.add(e);
    }

    public void deleteEmployee(Employee e) {
        employeesList.remove(e);
    }

    public void editEmployee(Employee e, String newName, int newAge, String newAddress, String newEmail, String newPhoneNumber) {
        e.setName(newName);
        e.setAge(newAge);
        e.setAddress(newAddress);
        e.setEmail(newEmail);
        e.setPhoneNumber(newPhoneNumber);
    }

    public void sortName() {
        employeesList.sort(Comparator.comparing(Employee::getName));
    }

    public void sortAge() {
        employeesList.sort(Comparator.comparing(Employee::getAge));
    }

    public List<Employee> getEmployeesByName(String keyword) {
        List<Employee> result = new ArrayList<>();
        for(Employee e: employeesList) {
            if (e.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }
}
