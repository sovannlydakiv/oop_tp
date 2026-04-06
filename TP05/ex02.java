import java.util.*;

class student{
    String name;
    String id;
    int age;
   
    public student(String name, String id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
}

public class ex02 {
    static ArrayList<student> students = new ArrayList<>();

    static void printTable() {
        System.out.println("====================================================");
        System.out.printf("| %-6s | %-12s | %-16s | %-5s |\n", "No", "ID", "Name", "Age");
        System.out.println("====================================================");
        for (int i = 0; i < students.size(); i++) {
            student s = students.get(i);
            System.out.printf("| %-6d | %-12s | %-16s | %-5d |\n",
                    (i + 1), s.id, s.name, s.age);
        }
        System.out.println("====================================================");
    }
 
    // Add students one by one
    static void addStudents(Scanner sc) {
        int count = 1;
        while (true) {
            System.out.println("Student #" + count + ":");
            System.out.print("Id: ");
            
            String id = sc.nextLine();
            
            System.out.print("Name: ");
            
            String name = sc.nextLine();
            
            System.out.print("Age: ");
            
            int age = Integer.parseInt(sc.nextLine());
            
            students.add(new student(name, id, age));
            
            System.out.print("Do you want to add more (y/n)?: ");
            
            String ans = sc.nextLine();
            
            if (!ans.equalsIgnoreCase("y")) 
                break;
            count++;
        }
    }
 
    // Delete multiple students by ID
    static void deleteStudents(Scanner sc) {
        if (students.isEmpty()) {
            System.out.println("No students to delete.");
            return;
        }
        printTable();
        System.out.println("==== DELETION =====");
 
        ArrayList<String> idsToDelete = new ArrayList<>();
        int count = 1;
        while (true) {
            System.out.print("Input student #" + count + " ID: ");
            String id = sc.nextLine();
            idsToDelete.add(id);
            System.out.print("Do you want to delete more (y/n)?: ");
            String ans = sc.nextLine();
            if (!ans.equalsIgnoreCase("y")) 
                break;
            count++;
        }

        for (String id : idsToDelete) {
            boolean found = false;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).id.equals(id)) {
                    students.remove(i);
                    System.out.println("Student with ID " + id + " deleted");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with ID " + id + " not found!");
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        while (true) {
            System.out.println("\n==== Menu ===");
            System.out.println("1. Add new students");
            System.out.println("2. Delete multiple students");
            System.out.println("3. Quit");
            System.out.print("Choose an opt: ");
 
            int choice = Integer.parseInt(sc.nextLine());
 
            if (choice == 1) {
                addStudents(sc);
            } else if (choice == 2) {
                deleteStudents(sc);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}


