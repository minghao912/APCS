import java.util.Scanner;

public class Lab09e {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a number: ");

        int num = kboard.nextInt();
        int i = 1;

        System.out.print(num + " has divisors ");

        while (i < num) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }

            i++;
        }

        System.out.println();
        
    }
}