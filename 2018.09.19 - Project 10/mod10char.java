import java.util.Scanner;

public class mod10char
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

        System.out.println();
        for (String planet : planets) System.out.println(planet);
        
        System.out.print("\nPlease enter the first letter of your selection: ");
        char selection = keyboard.nextLine().charAt(0);

        int placeholder = 0;
        switch (selection)
        {
            case 'v':
            case 'V':   placeholder = 0;
                        break;
            case 'j':
            case 'J':   placeholder = 1;
                        break;
            case 'u':
            case 'U':   placeholder = 2;
                        break;
            case 'n':
            case 'N':   placeholder = 3;
                        break;

            default:    System.out.println("The entry is not a valid planet.");
                        System.exit(1);
                        break;
        }

        System.out.print("\nYour weight on " + planets[placeholder] + " would be ");
        System.out.printf("%.3f", (weight * gravity[placeholder]));
        System.out.println();
    }  
}