package vn.codegym.employeemanagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employeesList = new ArrayList<>();

    public void addEmployee(Employee e) {
        employeesList.add(e);
    }

    public void removeEmployee(Employee e) {
        employeesList.remove(e);
    }

    public void editEmployee(Employee e) {
        e.toString();
        while(true) {
            System.out.println("What do you want to edit?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Adress");
            System.out.println("4. Email");
            System.out.println("5. Phone number");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("New name:");
                    String newName = sc.next();
                    e.setName(newName);
                case 2:
                    System.out.println("New age:");
                    int newAge = sc.nextInt();
                    e.setAge(newAge);
                case 3:
                    System.out.println("New address:");
                    String newAddress = sc.next();
                    e.setAddress(newAddress);
                case 4:
                    System.out.println("New email:");
                    String newEmail = sc.next();
                    e.setEmail(newEmail);
                case 5:
                    System.out.println("New phone number:");
                    String newPhoneNumber = sc.next();
                    e.setPhoneNumber(newPhoneNumber);
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
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
