import java.util.Scanner;

public class Lab08c
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please input a word: ");

        String input = kboard.nextLine();

        for (int i = 1; i <= input.length(); i++)
        {
            System.out.println(input);
        }
    }
}