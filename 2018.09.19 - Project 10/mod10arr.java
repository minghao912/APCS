import java.util.Scanner;

public class mod10arr 
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter your weight on Earth: ");

        if (!keyboard.hasNextDouble()) {
            System.out.println("Invalid weight. Please try again.");
            System.exit(1);
        }
        double weight = keyboard.nextDouble();

        String[] planets = {"Venus", "Jupiter", "Uranus", "Neptune"};
        double[] gravity = {0.9051, 2.52959, 0.9051, 1.1377551};

        for (int i = 1; i <= planets.length; i++) 
            System.out.println(i + ". " + planets[i - 1]);

        System.out.print("\n        Selection? ");

        if (!keyboard.hasNextInt()) {
            System.out.println("Invalid selection. Please try again.");
            System.exit(1);
        }
        int selection = keyboard.nextInt();

        System.out.print("\nYour weight on " + planets[selection - 1] + " would be ");
        System.out.printf("%.3f", (weight * gravity[selection - 1]));
        System.out.println();

        keyboard.close();
    }
}