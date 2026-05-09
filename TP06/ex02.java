import java.util.*;

class MathOperation {
    int sum(int a, int b) {
        return a + b;
    }
    int sum(int a, int b, int c) {
        return a + b + c;
    }
    int sum(int[] values) {
        int total = 0;

        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total;
    }
    int multiply(int a, int b) {
        return a * b;
    }
    int multiply(int a, int b, int c) {
        return a * b * c;
    }
    int multiply(int[] values) {
        int total = 1;

        for (int i = 0; i < values.length; i++) {
            total *= values[i];
        }
        return total;
    }
    int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
    int max(int a, int b, int c) {
        int largest = a;

        if (b > largest) {
            largest = b;
        }
        if (c > largest) {
            largest = c;
        }
        return largest;
    }
    int max(int[] values) {
        int largest = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > largest) {
                largest = values[i];
            }
        }
        return largest;
    }
    int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
    int min(int a, int b, int c) {
        int smallest = a;

        if (b < smallest) {
            smallest = b;
        }
        if (c < smallest) {
            smallest = c;
        }
        return smallest;
    }
    int min(int[] values) {
        int smallest = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < smallest) {
                smallest = values[i];
            }
        }
        return smallest;
    }
    double average(int a, int b) {
        return (a + b) / 2.0;
    }
    double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }
    double average(int[] values) {
        int total = 0;

        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total / (double) values.length;
    }
}
public class ex02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MathOperation math = new MathOperation();

        while (true) {

            System.out.println("==== Menu ===");
            System.out.println("1. Sum of two values");
            System.out.println("2. Sum of three values");
            System.out.println("3. Sum of many values");
            System.out.println("4. Multiply of two values");
            System.out.println("5. Multiply of three values");
            System.out.println("6. Multiply of many values");
            System.out.println("7. Max of two values");
            System.out.println("8. Max of three values");
            System.out.println("9. Max of many values");
            System.out.println("10. Min of two values");
            System.out.println("11. Min of three values");
            System.out.println("12. Min of many values");
            System.out.println("13. Average of two values");
            System.out.println("14. Average of three values");
            System.out.println("15. Average of many values");
            System.out.println("16. Quit");

            System.out.print("Choose option: ");
            int choice = input.nextInt();

            if (choice == 1) {

                int a = input.nextInt();
                int b = input.nextInt();

                System.out.println("Result: " + math.sum(a, b));
            }
            else if (choice == 2) {

                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();

                System.out.println("Result: " + math.sum(a, b, c));
            }
            else if (choice == 3) {
                System.out.print("How many values: ");
                int size = input.nextInt();
                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = input.nextInt();
                }
                System.out.println("Result: " + math.sum(arr));
            }
            else if (choice == 4) {
                int a = input.nextInt();
                int b = input.nextInt();

                System.out.println("Result: " + math.multiply(a, b));
            }
            else if (choice == 5) {
                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();

                System.out.println("Result: " + math.multiply(a, b, c));
            }
            else if (choice == 6) {

                System.out.print("How many values: ");
                int size = input.nextInt();

                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = input.nextInt();
                }

                System.out.println("Result: " + math.multiply(arr));
            }
            else if (choice == 7) {

                int a = input.nextInt();
                int b = input.nextInt();

                System.out.println("Result: " + math.max(a, b));
            }
            else if (choice == 8) {

                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();

                System.out.println("Result: " + math.max(a, b, c));
            }
            else if (choice == 9) {

                System.out.print("How many values: ");
                int size = input.nextInt();

                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = input.nextInt();
                }

                System.out.println("Result: " + math.max(arr));
            }
            else if (choice == 10) {

                int a = input.nextInt();
                int b = input.nextInt();

                System.out.println("Result: " + math.min(a, b));
            }
            else if (choice == 11) {

                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();

                System.out.println("Result: " + math.min(a, b, c));
            }
            else if (choice == 12) {

                System.out.print("How many values: ");
                int size = input.nextInt();

                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = input.nextInt();
                }

                System.out.println("Result: " + math.min(arr));
            }
            else if (choice == 13) {

                int a = input.nextInt();
                int b = input.nextInt();

                System.out.println("Result: " + math.average(a, b));
            }
            else if (choice == 14) {

                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();

                System.out.println("Result: " + math.average(a, b, c));
            }
            else if (choice == 15) {

                System.out.print("How many values: ");
                int size = input.nextInt();

                int[] arr = new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i] = input.nextInt();
                }

                System.out.println("Result: " + math.average(arr));
            }
            else if (choice == 16) {
                break;
            }
            else {
                System.out.println("Invalid option");
            }
            System.out.println();
        }
        input.close();
    }
}