package vn.codegym.employeemanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    private static final String FILE_PATH = "employees.dat";

    public void saveToFile(String FILE_PATH) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee e: employeesList) {
                String line = String.format("%s,%d,%s,%s,%s",
                        e.getName(),
                        e.getAge(),
                        e.getAddress(),
                        e.getEmail(),
                        e.getPhoneNumber());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }
        employeesList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line= reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    String email = parts[3];
                    String phoneNumber = parts[4];
                    Employee e = new Employee(name, age, address, email, phoneNumber);
                    employeesList.add(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
