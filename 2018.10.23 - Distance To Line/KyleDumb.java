import java.util.Scanner;

public class KyleDumb {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the A value for the line: ");
        double A = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.print("Enter the B value for the line: ");
        double B = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.print("Enter the C value for the line: ");
        double C = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.print("Enter the x coordinate for the point: ");
        double a = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.print("Enter the y coordinate for the point: ");
        double b = keyboard.nextDouble();
        keyboard.nextLine();

        DistToLine.A = A;
        DistToLine.B = B;
        DistToLine.C = C;
        System.out.println("\nDistance from the point to the line is: " + DistToLine.getDist(a, b));
    }
}