import java.text.SimpleDateFormat;
import java.util.*;

class MyDate {

    public void getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date now = new Date();
        System.out.println("Current datetime is: " + format.format(now));
    }

    public void calculateDaysBtwDates(String day1, String day2) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = format.parse(day1);
            Date date2 = format.parse(day2);

            long diff = Math.abs(date2.getTime() - date1.getTime());
            long days = diff / (1000 * 60 * 60 * 24);

            System.out.println("Difference between two dates is: " + days + " days");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        }
    }

    public void findDay(String dateStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(dateStr);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday",
                             "Thursday", "Friday", "Saturday"};

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            
            System.out.println("The day is: " + days[dayOfWeek]);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        }
    }
}

public class ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyDate date = new MyDate();

        while (true) {
            System.out.println("\n==== Menu ===");
            System.out.println("1. Current date and time");
            System.out.println("2. Calculate days btw two dates");
            System.out.println("3. Find the day of the week");
            System.out.println("4. Quit");
            System.out.print("Choose an opt: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                date.getCurrentDate();

            } else if (choice == 2) {
                System.out.print("First date (dd/mm/yyyy): ");
                String d1 = sc.nextLine();
                System.out.print("Second date (dd/mm/yyyy): ");
                String d2 = sc.nextLine();
                date.calculateDaysBtwDates(d1, d2);

            } else if (choice == 3) {
                System.out.print("Input a date: ");
                String d = sc.nextLine();
                date.findDay(d);

            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}