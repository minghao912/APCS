import java.util.Scanner;

public class Lab08e
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter arguments (factor, lines): ");

        int factor = kboard.nextInt();
        int lines = kboard.nextInt();

        System.out.println("multiplication table for " + factor);

        for (int i = 1; i <= lines; i++)
        {
            System.out.printf("%-5.30s  %5.30s%n", i, factor * i);
        }        
    }
}