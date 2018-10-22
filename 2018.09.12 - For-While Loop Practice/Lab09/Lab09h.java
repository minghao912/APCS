import java.util.Scanner;

public class Lab09h {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a number: ");

        int num = kboard.nextInt();
        int totale = 0;

        //Loop (Find divisors)
        int i = 1;

        while (i < num) {
            if (num % i == 0) {
                totale += i;
            }

            i++;
        }

        //Check if sum of divisors is equal
        if (totale == num) System.out.println(num + " is perfect.");
        else System.out.println(num + " is not perfect.");
        
    }
}