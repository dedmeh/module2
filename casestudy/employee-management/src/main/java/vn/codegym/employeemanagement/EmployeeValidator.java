package vn.codegym.employeemanagement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidator {
    public static boolean validateEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePhone(String phone) {
        String phoneRegex = "^0\\d{9,10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean validateAge(int age) {
        if (age < 0|| age > 100) {
            return false;
        }
        return true;
    }
}
