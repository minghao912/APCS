import java.util.Scanner;

public class Lab08d
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        
        System.out.print("Please enter a word: ");

        String word = kboard.nextLine();

        for (int i = word.length() - 1; i >= 0; i--)
        {
            System.out.println(word.substring(0, i + 1));
        }
    }
}