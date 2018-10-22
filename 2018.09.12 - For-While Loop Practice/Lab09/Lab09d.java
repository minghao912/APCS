import java.util.Scanner;

public class Lab09d {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);
        
        System.out.print("Please enter a number: ");

        int num = kboard.nextInt();
        int totale = 0, numForPrint = num;

        while (num != 0) {
            totale += num % 10;
            num /= 10;
        }

        System.out.println(totale + " is the sum of the digits of " + numForPrint);

    }
}