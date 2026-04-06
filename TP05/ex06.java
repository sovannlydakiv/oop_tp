import java.io.*;
import java.util.*;

public class ex06 {

    static final String FILE_NAME = "user.txt";
    static void saveUser(String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void register(Scanner sc) {
        System.out.println("==== Register a new user ====");
        System.out.print("First Name: "); 
        String fn = sc.nextLine();

        System.out.print("Last Name: ");  
        String ln = sc.nextLine();

        System.out.print("Username: ");   
        String user = sc.nextLine();

        System.out.print("Email: ");      
        String em = sc.nextLine();

        System.out.print("Password: ");   
        String pass = sc.nextLine();

        try {
            File f = new File(FILE_NAME);
            if (f.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts[2].equals(user)) { 
                        System.out.println("Username already taken!"); 
                        reader.close(); 
                    return; 
                    }
                    if (parts[3].equals(em)) { 
                        System.out.println("Email already registered!"); 
                        reader.close(); 
                    return; 
                    }
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        saveUser(fn + "," + ln + "," + user + "," + em + "," + pass);
        System.out.println("You are successfully registered~");
    }

    static void login(Scanner sc) {
        System.out.println("==== Login ====");

        while (true) {
            System.out.print("email or username: "); 
            String input = sc.nextLine();

            System.out.print("Password: ");          
            String pass  = sc.nextLine();

            boolean found = false;
            try {
                File f = new File(FILE_NAME);
                if (!f.exists()) { System.out.println("User not found, please try again"); 
                return; 
            }
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] p = line.split(",");
                    
                    if ((p[2].equals(input) || p[3].equals(input)) && p[4].equals(pass)) {
                        System.out.println("=========== User info ===========");
                        System.out.println("Hi " + p[0] + " " + p[1] + ",");
                        System.out.println("Your username is: " + p[2]);
                        System.out.println("Your email is: "    + p[3]);
                        found = true;
                        break;
                    }
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (found) break;
            System.out.println("Wrong username/email or password. Try again? (y/n): ");
            if (!sc.nextLine().equalsIgnoreCase("y")) 
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 1: 
                    login(sc); 
                break;
                case 2: 
                    register(sc); 
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