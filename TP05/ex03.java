import java.util.*;

class shapes{
    void draw(){
    }
    String getInfo(){
        return "Shape";
    }
}

class line extends shapes{
    int length;

    public line(int length){
        this.length = length;
    }

    @Override
    void draw(){
        for (int i = 0; i < length; i++) {
            System.out.print("_");
        }
        System.out.println();
    }

    @Override
    String getInfo(){
        return "Length: " + length;
    }
}

class rectangle extends shapes{
    int width, height;

    public rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    void draw(){
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 || row == height - 1 || col == 0 || col == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    String getInfo(){
        return "Width: " + width + ", Height: " + height;
    }
}

class triangle extends shapes{
    int height;

    public triangle(int height) {
        this.height = height;
    }

    @Override
    void draw() {
        for (int row = 1; row <= height; row++) {
            for (int space = 0; space < height - row; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < (2 * row - 1); col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    String getInfo() {
        return "Height: " + height + ", Base width: " + (2 * height - 1);
    }
}
public class ex03 {
    static ArrayList<line> lines = new ArrayList<>();
    static ArrayList<rectangle> rectangles = new ArrayList<>();
    static ArrayList<triangle> triangles = new ArrayList<>();

    static void viewAllLines() {
        System.out.println("==== List all lines ====");
        if (lines.isEmpty()) { 
            System.out.println("No lines yet."); 
            return; 
        }
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ". " + lines.get(i).getInfo());
            lines.get(i).draw();
        }
    }

    static void viewAllRectangles() {
        System.out.println("==== List all rectangles ====");
        if (rectangles.isEmpty()) { 
            System.out.println("No rectangles yet."); 
            return; 
        }
        for (int i = 0; i < rectangles.size(); i++) {
            System.out.println((i + 1) + ". " + rectangles.get(i).getInfo());
            rectangles.get(i).draw();
        }
    }

    static void viewAllTriangles() {
        System.out.println("==== List all triangles ====");
        if (triangles.isEmpty()) { 
            System.out.println("No triangles yet."); 
            return; 
        }
        for (int i = 0; i < triangles.size(); i++) {
            System.out.println((i + 1) + ". " + triangles.get(i).getInfo());
            triangles.get(i).draw();
        }
    }

    static void addShape(Scanner sc) {
        System.out.println("==== Add new shape ====");
        System.out.println("1. Line");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Choose an opt: ");
        int shapeChoice = Integer.parseInt(sc.nextLine());

        if (shapeChoice == 1) {
            System.out.print("Input length: ");
            int len = Integer.parseInt(sc.nextLine());
            lines.add(new line(len));
            System.out.println("Line added!");
        } 
        else if (shapeChoice == 2) {
            System.out.print("Input width: ");
            int w = Integer.parseInt(sc.nextLine());
            System.out.print("Input height: ");
            int h = Integer.parseInt(sc.nextLine());
            rectangles.add(new rectangle(w, h));
            System.out.println("Rectangle added!");
        } 
        else if (shapeChoice == 3) {
            System.out.print("Input height: ");
            int h = Integer.parseInt(sc.nextLine());
            triangles.add(new triangle(h));
            System.out.println("Triangle added!");
        } 
        else {
            System.out.println("Invalid shape choice.");
        }
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Menu ===");
            System.out.println("1. View all lines");
            System.out.println("2. View all rectangles");
            System.out.println("3. View all triangles");
            System.out.println("4. Add a new shape");
            System.out.println("5. Quit");
            System.out.print("Choose an opt: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    viewAllLines();
                    break;
                case 2:
                    viewAllRectangles();
                    break;
                case 3:
                    viewAllTriangles();
                    break;
                case 4:
                    addShape(sc);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
}

