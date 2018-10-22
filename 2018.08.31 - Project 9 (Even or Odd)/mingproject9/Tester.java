import java.util.Scanner;

public class Tester
{
    public static void main(String[] args) {
        
        Scanner kboard = new Scanner(System.in);
        
        while(true) {
            System.out.println("Enter an integer:");
            
            if (!kboard.hasNextInt()) {
                System.out.println("Invalid input. Please try again.");
                return;
            }
            
            int num = kboard.nextInt();
            
            if (num == 0) {
                System.out.println("0 is an invalid input.");
                return;
            }
            
            if (num % 2 == 0) System.out.println("The integer " + num + " is even.");
            else System.out.println("The integer " + num + " is odd.");
            
        }
    }
}
