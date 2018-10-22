import java.util.Scanner;

public class Lab08j {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a binary number: ");

        String binStr = kboard.nextLine();
        
        if (binStr.contains("[2-9]") || binStr.contains("[ ]")) {
            System.out.println("You have entered an invalid binary number.");
            System.exit(1);
        }

        Integer dec = null;

        for (int i = 0; i < 1; i++) {
            dec = Integer.parseInt(binStr, 2);
        }

        System.out.println(binStr + " == " + dec);

        kboard.close();
        
    }
}