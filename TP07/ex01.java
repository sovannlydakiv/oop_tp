import java.util.*;

abstract class ShapeArea {
    abstract double calcuateRectangleArea(double width, double height);
    abstract double calcuateCircleArea(double radius);
    abstract double calcuateTraingleArea(double a, double b, double c);
    abstract double calcuateTraingleArea(double base, double height);
    abstract double calcuateSemicirleArea(double radius);
    abstract double calcuateSectorArea(double radius, double angle);
}

class GeometryArea extends ShapeArea {

    @Override
    double calcuateRectangleArea(double width, double height) {
        return width * height;
    }

    @Override
    double calcuateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    @Override
    double calcuateTraingleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    double calcuateTraingleArea(double base, double height) {
        return 0.5 * base * height;
    }

    @Override
    double calcuateSemicirleArea(double radius) {
        return (Math.PI * radius * radius) / 2;
    }

    @Override
    double calcuateSectorArea(double radius, double angle) {
        return (angle / 360) * Math.PI * radius * radius;
    }
}

public class ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GeometryArea geo = new GeometryArea();
        int opt;

        do {
            System.out.println("==== Shape Area Calculation ===");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Triangle (three sides)");
            System.out.println("4. Triangle (base and height)");
            System.out.println("5. Semi circle");
            System.out.println("6. Sector");
            System.out.println("7. Quit");
            System.out.print("Choose an opt: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Enter width: ");
                    double w = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double h = sc.nextDouble();
                    System.out.printf("Area = %.2f%n", geo.calcuateRectangleArea(w, h));
                    break;
                case 2:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    System.out.printf("Area = %.2f%n", geo.calcuateCircleArea(r));
                    break;
                case 3:
                    System.out.print("Enter side a: ");
                    double a = sc.nextDouble();
                    System.out.print("Enter side b: ");
                    double b = sc.nextDouble();
                    System.out.print("Enter side c: ");
                    double c = sc.nextDouble();
                    System.out.printf("Area = %.2f%n", geo.calcuateTraingleArea(a, b, c));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double height = sc.nextDouble();
                    System.out.printf("Area = %.2f%n", geo.calcuateTraingleArea(base, height));
                    break;
                case 5:
                    System.out.print("Enter radius: ");
                    double sr = sc.nextDouble();
                    System.out.printf("Area = %.2f%n", geo.calcuateSemicirleArea(sr));
                    break;
                case 6:
                    System.out.print("Enter radius: ");
                    double secR = sc.nextDouble();
                    System.out.print("Enter angle (degrees): ");
                    double angle = sc.nextDouble();
                    System.out.printf("Area = %.2f%n", geo.calcuateSectorArea(secR, angle));
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (opt != 7);

        sc.close();
    }
}