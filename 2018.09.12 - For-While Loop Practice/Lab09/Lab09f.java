import java.util.Scanner;

public class Lab09f {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a sentence, with the letter to remove seperated by three (3) spaces: ");

        //Seperate arguments out
        String str = kboard.nextLine();
        String remove = str.substring(str.length() - 1);
        str = str.substring(0, str.length() - 4);   

        System.out.println(str + " - letter to remove " + remove);

        int i = 0;
        String replaced = "";

        while (i == 0) {
            replaced = str.replace(remove, "");
            i = 1;
        }

        System.out.println(replaced);
        
    }
}