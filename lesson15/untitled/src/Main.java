import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        try {
            Scanner scanner = new Scanner(System.in);

            int age = scanner.nextInt();
            System.out.println("Your age: " + age);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
        System.out.println("End program");

    }
}