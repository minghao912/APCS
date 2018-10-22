import java.util.Scanner;

public class Lab08f
{
    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a word: ");

        String word = kboard.nextLine();

        System.out.println(word.substring(0,1));
        System.out.println(word.substring(word.length() - 1, word.length()));
        
        for (int i = word.length() - 1; i >= 0; i--)
        {
            System.out.print(word.charAt(i));
        }

        System.out.println("\n" + word);
    }
}