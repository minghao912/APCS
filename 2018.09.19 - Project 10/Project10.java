import java.util.Scanner;

public class Project10 
{
    public static void main (String[] args) 
    {
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter your weight on Earth: ");

        if (!kboard.hasNextInt()) System.exit(1);

        int weight = kboard.nextInt();

        System.out.println("1. Venus");
        System.out.println("2. Jupiter");
        System.out.println("3. Uranus");
        System.out.println("4. Neptune");
        System.out.print("\n      Selection? ");

        int selection = kboard.nextInt();

        switch (selection) {
            case 1: System.out.print("\nYour weight on Venus would be ");
                    System.out.printf("%.3f", (weight * 0.9051));
                    System.out.println();
                    break;

            case 2: System.out.print("\nYour weight on Jupiter would be ");
                    System.out.printf("%.3f", (weight * 2.52959));
                    System.out.println();
                    break;

            case 3: System.out.print("\nYour weight on Uranus would be ");
                    System.out.printf("%.3f", (weight * 0.9051));
                    System.out.println();
                    break;

            case 4: System.out.println("Your weight on Neptune would be ");
                    System.out.printf("%.3f", (weight * 1.1377551));
                    System.out.println();
                    break;

            default:    System.out.println("The entry is not a valid planet.");
                        System.exit(1);
                        break;
        } 
    }
}