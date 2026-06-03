import java.util.*;

abstract class NumberRandomizer {
    abstract int randomizeInBetween(int min, int max);
    abstract int[] randomizeUniqueInBetween(int min, int max, int amount);
}

class MyNumberRandomizer extends NumberRandomizer {
    private Random rand = new Random();

    @Override
    int randomizeInBetween(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    int[] randomizeUniqueInBetween(int min, int max, int amount) {
        ArrayList<Integer> pool = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);
        int[] result = new int[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = pool.get(i);
        }
        return result;
    }
}

public class ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyNumberRandomizer randomizer = new MyNumberRandomizer();
        int opt;

        do {
            System.out.println("==== Number Randomizer ===");
            System.out.println("1. In between");
            System.out.println("2. Unique in between");
            System.out.println("3. Quit");
            System.out.print("Choose an opt: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Enter min: ");
                    int min = sc.nextInt();
                    System.out.print("Enter max: ");
                    int max = sc.nextInt();
                    System.out.println("Result: " + randomizer.randomizeInBetween(min, max));
                    break;
                case 2:
                    System.out.print("Enter min: ");
                    int uMin = sc.nextInt();
                    System.out.print("Enter max: ");
                    int uMax = sc.nextInt();
                    System.out.print("Enter amount: ");
                    int amount = sc.nextInt();
                    System.out.println("Result: " + Arrays.toString(randomizer.randomizeUniqueInBetween(uMin, uMax, amount)));
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (opt != 3);

        sc.close();
    }
}