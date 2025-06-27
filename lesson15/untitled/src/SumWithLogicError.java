public class SumWithLogicError {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int sum = 0;

        System.out.println("Calculating sum of numbers:");
        for (int i = 0; i < numbers.length; i++) {
            sum = 0;

            sum += numbers[i];
            System.out.println("Current number: " + numbers[i] + ", Current sum: " + sum);
        }

        // Kết quả mong đợi: 1 + 2 + 3 + 4 + 5 = 15
        System.out.println("Final sum: " + sum);
    }
}