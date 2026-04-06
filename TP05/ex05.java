import java.io.*;
import java.util.*;

public class ex05 {

    static final String TEACHER_FILE = "teacher.txt";
    static final String STUDENT_FILE = "student.txt";
    static final String GUARD_FILE   = "securityguard.txt";

    static void viewFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) { 
                System.out.println("No data yet."); 
            return; 
        }

            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(count + ". " + line);
                count++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void appendToFile(String filename, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewAll() {
        System.out.println("==== Teachers ====");
        viewFile(TEACHER_FILE);
        System.out.println("==== Students ====");
        viewFile(STUDENT_FILE);
        System.out.println("==== Security Guards ====");
        viewFile(GUARD_FILE);
    }

    static void addNew(Scanner sc) {
        System.out.println("1. Teacher  2. Student  3. Security Guard");
        System.out.print("Choose: ");
        int opt = Integer.parseInt(sc.nextLine());

        System.out.print("First Name: ");  
        String fn  = sc.nextLine();

        System.out.print("Last Name: ");   
        String ln  = sc.nextLine();

        System.out.print("gender: ");         
        String gender = sc.nextLine();

        System.out.print("Email: ");       
        String em  = sc.nextLine();

        if (opt == 1) {
            System.out.print("Subject: "); 
            String sub = sc.nextLine();

            System.out.print("Salary: ");  
            String sal = sc.nextLine();

            appendToFile(TEACHER_FILE, fn + " " + ln + " | " + gender + " | " + em + " | " + sub + " | $" + sal);
            System.out.println("Teacher added!");

        } else if (opt == 2) {
            System.out.print("Year: ");  
            String year  = sc.nextLine();

            System.out.print("Major: "); 
            String major = sc.nextLine();

            appendToFile(STUDENT_FILE, fn + " " + ln + " | " + gender + " | " + em + " | Year " + year + " | " + major);
            System.out.println("Student added!");

        } else if (opt == 3) {
            System.out.print("Role: "); 
            String role = sc.nextLine();

            appendToFile(GUARD_FILE, fn + " " + ln + " | " + gender + " | " + em + " | " + role);
            System.out.println("Security Guard added!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. View all");
            System.out.println("2. Add new");
            System.out.println("3. Quit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: 
                    viewAll(); 
                break;
                case 2: 
                    addNew(sc); 
                break;
                case 3: 
                    System.out.println("Goodbye!"); 
                    sc.close(); 
                return;
                default: 
                System.out.println("Invalid option.");
            }
        }
    }
}