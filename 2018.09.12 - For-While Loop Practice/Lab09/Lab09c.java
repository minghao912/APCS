import java.util.Scanner;

public class Lab09c {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);
        System.out.print("Please enter a number: ");

        int num = kboard.nextInt();

        System.out.print(num + " reversed is ");

        while (num != 0) {
            System.out.print(num % 10);
            num /= 10;
        }

        System.out.println();
    }
}