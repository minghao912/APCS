import java.util.Scanner;

public class Lab08b
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter arguments (start, end, increment): ");
        
        if (!kboard.hasNextInt())
        {
            System.out.println("Please enter a valid value.");
            System.exit(1);
        }

        int start = kboard.nextInt();
        int end = kboard.nextInt();
        int increment = kboard.nextInt();

        System.out.println("start " + start + " : stop " + end + " : increment " + increment);

        for (int i = start; i < end; i = i + increment)
        {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}