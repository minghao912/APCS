import java.util.InputMismatchException;
import java.util.Scanner;   //for user input

public class Tester {
    public static void main (String[] args) {
        
        program();

    }

    public static void program() {
        
        Scanner kboard = new Scanner(System.in);
        
        //Runs in a loop so the program won't end after every number
        while (true) {

            System.out.print("Enter an integer: "); //Ask user
            
            //Deal with unwanted inputs
            if (!kboard.hasNextInt()) {

                //If user did not input a number, check if they input a command
                String str = kboard.nextLine();

                //If user inputs "END"
                if (str.equalsIgnoreCase("end")) {

                    System.out.println("System shutting down...");
                    System.exit(0); //shutdown

                } else {    //Otherwise, user input is invalid, so start from the top again
                    System.out.println("Invalid input. Please try again.\n");
                    program();
                }
            }
            
            //If user did input a number, then execute this
            else {

                int num = kboard.nextInt(); 
                
                //Math and result
                if (num % 2 == 0) System.out.println("The integer " + num + " is even.\n");
                else System.out.println("The integer " + num + " is odd.\n");

            }
        }
    }
}

//03 September 2018, 11:59