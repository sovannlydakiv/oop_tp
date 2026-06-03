import java.util.Scanner;

interface GridLayout {
    void insertAtRow(int rowNumber, int[] values);
    void insertAtColumn(int columnNumber, int[] values);
    void clearAtRow(int rowNumber);
    void clearAtColumn(int columnNumber);
    void updateCell(int rowNumber, int columnNumber, int value);
    void displayGrid();
    void clear();
}

public class ex01 implements GridLayout {
    private int[][] grid;
    private static final int SIZE = 7;

    public ex01() {
        grid = new int[SIZE][SIZE];
    }

    @Override
    public void insertAtRow(int rowNumber, int[] values) {
        if (rowNumber < 0 || rowNumber >= SIZE) { 
            System.out.println("Invalid row number."); 
            return; 
        }

        for (int col = 0; col < SIZE; col++) {
            int val = values[col];
            grid[rowNumber][col] = (val >= 0 && val <= 9) ? val : 0;
        }
    }

    @Override
    public void insertAtColumn(int columnNumber, int[] values) {
        if (columnNumber < 0 || columnNumber >= SIZE) { 
            System.out.println("Invalid column number."); 
            return; 
        }

        for (int row = 0; row < SIZE; row++) {
            int val = values[row];
            grid[row][columnNumber] = (val >= 0 && val <= 9) ? val : 0;
        }
    }

    @Override
    public void clearAtRow(int rowNumber) {
        if (rowNumber < 0 || rowNumber >= SIZE) { 
            System.out.println("Invalid row number."); 
            return; 
        }
        for (int col = 0; col < SIZE; col++) grid[rowNumber][col] = 0;
    }

    @Override
    public void clearAtColumn(int columnNumber) {
        if (columnNumber < 0 || columnNumber >= SIZE) { 
            System.out.println("Invalid column number."); 
            return; 
        }
        for (int row = 0; row < SIZE; row++) grid[row][columnNumber] = 0;
    }

    @Override
    public void updateCell(int rowNumber, int columnNumber, int value) {
        if (rowNumber < 0 || rowNumber >= SIZE || columnNumber < 0 || columnNumber >= SIZE) {
            System.out.println("Invalid row or column number."); 
            return;
        }
        if (value < 0 || value > 9) { 
            System.out.println("Value must be between 0 and 9."); 
            return; 
        }
        grid[rowNumber][columnNumber] = value;
    }

    @Override
    public void displayGrid() {
        System.out.println(":::: The GRID ::::");
        System.out.print("   ");

        for (int col = 0; col < SIZE; col++) System.out.print(col + " ");
        System.out.println();
        System.out.print("   ");

        for (int col = 0; col < SIZE; col++) System.out.print("- ");
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " - ");

            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }

            System.out.println();
        }
    }

    @Override
    public void clear() {
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++)
                grid[row][col] = 0;
    }

    private int[] readValues(Scanner sc, String label) {
        int[] values = new int[SIZE];
        System.out.println("Enter " + SIZE + " values (0-9) for " + label + ":");

        for (int i = 0; i < SIZE; i++) {
            System.out.print("  Value[" + i + "]: ");
            
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                values[i] = (v >= 0 && v <= 9) ? v : 0;
            } catch (NumberFormatException e) {
                values[i] = 0;
            }
        }
        return values;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ex01 gm = new ex01();

        while (true) {
            gm.displayGrid();
            System.out.println();
            System.out.println("1. Update a single cell");
            System.out.println("2. Insert at a row");
            System.out.println("3. Insert at a column");
            System.out.println("4. Clear at a row");
            System.out.println("5. Clear at a column");
            System.out.println("6. Clear all");
            System.out.println("7. Quit");
            System.out.print("Choose an opt: ");

            int choice;
            
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option.\n"); 
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter row (0-6): ");
                int row = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Enter column (0-6): ");
                int col = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Enter value (0-9): ");
                int val = Integer.parseInt(sc.nextLine().trim());
                gm.updateCell(row, col, val);
            } 
            else if (choice == 2) {
                System.out.print("Enter row number (0-6): ");
                int row = Integer.parseInt(sc.nextLine().trim());
                gm.insertAtRow(row, gm.readValues(sc, "row " + row));
            } 
            else if (choice == 3) {
                System.out.print("Enter column number (0-6): ");
                int col = Integer.parseInt(sc.nextLine().trim());
                gm.insertAtColumn(col, gm.readValues(sc, "column " + col));
            }
            else if (choice == 4) {
                System.out.print("Enter row number (0-6): ");
                gm.clearAtRow(Integer.parseInt(sc.nextLine().trim()));
            } 
            else if (choice == 5) {
                System.out.print("Enter column number (0-6): ");
                gm.clearAtColumn(Integer.parseInt(sc.nextLine().trim()));
            } 
            else if (choice == 6) {
                gm.clear();
                System.out.println("Grid cleared.\n");
            } 
            else if (choice == 7) {
                System.out.println("Goodbye!"); break;
            } 
            else {
                System.out.println("Invalid option.\n");
            }
        }

        sc.close();
    }
}