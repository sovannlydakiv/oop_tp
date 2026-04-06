import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ex04 {

    static final String FILE_NAME = "data.txt";
    static ArrayList<String> loadNote() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return lines; 

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return lines;
    }

    static void saveNote(ArrayList<String> lines) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    static void printNote(ArrayList<String> lines) {
        System.out.println("*****************************");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + "| " + lines.get(i));
        }
        System.out.println("*****************************");
    }

    static void viewNote() {
        System.out.println("==== View note ====");
        ArrayList<String> lines = loadNote();
        if (lines.isEmpty()) {
            System.out.println("Note is empty.");
        } else {
            printNote(lines);
        }
    }

    static void editNote(Scanner sc) {
        ArrayList<String> lines = loadNote();
        System.out.println("==== Edit following note ====");
        printNote(lines);

        System.out.println("1. Append new line");
        System.out.println("2. Update at line");
        System.out.println("3. Delete line");
        System.out.print("Choose an opt: ");
        int opt = Integer.parseInt(sc.nextLine());

        if (opt == 1) {
            int newLineNum = lines.size() + 1;
            System.out.print("Input a string for line #" + newLineNum + ": ");
            String newLine = sc.nextLine();
            lines.add(newLine);
            saveNote(lines);
            System.out.println("Line #" + newLineNum + " is appended to the note.");

        } else if (opt == 2) {
            System.out.print("Update line number: ");
            int lineNum = Integer.parseInt(sc.nextLine());
            if (lineNum < 1 || lineNum > lines.size()) {
                System.out.println("Line number out of range.");
                return;
            }
            System.out.print("New text: ");
            String updated = sc.nextLine();
            lines.set(lineNum - 1, updated); 
            saveNote(lines);
            System.out.println("Line #" + lineNum + " is updated.");

        } else if (opt == 3) {
            System.out.print("Delete line number: ");
            int lineNum = Integer.parseInt(sc.nextLine());
            if (lineNum < 1 || lineNum > lines.size()) {
                System.out.println("Line number out of range.");
                return;
            }
            lines.remove(lineNum - 1);
            saveNote(lines);
            System.out.println("Line #" + lineNum + " is deleted.");
        } else {
            System.out.println("Invalid option.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Menu ===");
            System.out.println("1. View my note");
            System.out.println("2. Edit");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 1: 
                    viewNote(); 
                break;
                case 2: 
                    editNote(sc); 
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