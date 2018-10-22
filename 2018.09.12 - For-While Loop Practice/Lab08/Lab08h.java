import java.util.Scanner;

public class Lab08h {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a number (max 20): ");

        int num = kboard.nextInt();
        long fat = 1;

        for (int i = num; i > 0; i--) {
            fat = fat * i;
        }

        System.out.println("factorial of " + num + " is " + fat);
        
    }
}