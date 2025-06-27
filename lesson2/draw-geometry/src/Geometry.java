import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1. Create a triangle");
        System.out.println("2. Create a square");
        System.out.println("3. Create a rectangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice");
        choice = input.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Drawing a triangle");
                System.out.println("******");
                System.out.println("*****");
                System.out.println("****");
                System.out.println("***");
                System.out.println("**");
                System.out.println("*");
                break;
            case 2:
                System.out.println("Drawing a square");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                break;
            case 3:
                System.out.println("Drawing a rectangle");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                break;
            case 0:
                System.out.println("Good Bye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
    }
}
