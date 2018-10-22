import java.util.Scanner;

public class Lab08i {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);
        
        System.out.print("Please enter a number: ");

        int num = kboard.nextInt();
        int divisor = 0;

        for (int i = 1; i < num; i++) {
            
            if (i > divisor) {
                if (num % i == 0) {
                    divisor = i;
                }
            }
        }

        if (divisor == 1) System.out.println(num + " is prime.");
        else System.out.println(num + " is not prime.");
    }
}