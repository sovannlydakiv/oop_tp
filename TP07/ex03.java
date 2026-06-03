import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

abstract class TextRandomizer {
    abstract char randomizeACharacter();
    abstract String randomizeAString(int length);
    abstract String[] randomizeStrings(int length, int amount);
}

class MyTextRandomizer extends TextRandomizer {
    private Random rand = new Random();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    char randomizeACharacter() {
        return ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
    }

    @Override
    String randomizeAString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(randomizeACharacter());
        }
        return sb.toString();
    }

    @Override
    String[] randomizeStrings(int length, int amount) {
        String[] result = new String[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = randomizeAString(length);
        }
        return result;
    }
}

public class ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyTextRandomizer randomizer = new MyTextRandomizer();
        int opt;

        do {
            System.out.println("==== Text Randomizer ===");
            System.out.println("1. A Character");
            System.out.println("2. A String");
            System.out.println("3. Unique Strings");
            System.out.println("4. Quit");
            System.out.print("Choose an opt: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Result: " + randomizer.randomizeACharacter());
                    break;
                case 2:
                    System.out.print("Enter length: ");
                    int len = sc.nextInt();
                    System.out.println("Result: " + randomizer.randomizeAString(len));
                    break;
                case 3:
                    System.out.print("Enter length: ");
                    int sLen = sc.nextInt();
                    System.out.print("Enter amount: ");
                    int amount = sc.nextInt();
                    System.out.println("Result: " + Arrays.toString(randomizer.randomizeStrings(sLen, amount)));
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (opt != 4);

        sc.close();
    }
}