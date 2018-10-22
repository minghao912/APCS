import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;

public class EulerCollective
{
    public static void main(String[] args) {
        
        userInput();
    }

    /*
        Ask user to input the ID of project
    */
    public static void userInput()
    {
        Scanner kboard = new Scanner(System.in);
        int idNo = 0;

        //Ask user for id number input
        System.out.print("\nPlease enter an ID number: ");

        try {
            if (kboard.hasNextInt()) 
            {
                idNo = kboard.nextInt();

                //Go to different "programs" depending on user input
                switch(idNo)
                {
                    case 0 : {
                        System.out.println("\nYou have selected Project ID 0\n______________________________\n");
                        ID0_sum1000();
                    }
                    break;

                    case 1 : {
                        System.out.println("\nYou have selected Project ID 1\n______________________________\n");
                        ID1_sum3and5();
                    }
                    break;

                    case 2 : {
                        System.out.println("\nYou have selected Project ID 2\n______________________________\n");
                        ID2_evenFib();
                    }
                    break;

                    case 4 : {
                        System.out.println("\nYou have selected Project ID 4\n______________________________\n");
                        ID4_3digitPalindrome();
                    }

                    case 6 : {
                        System.out.println("\nYou have selected Project ID 6\n______________________________\n");
                        ID6_differenceOfSumsAndSquares();
                    }

                    default : System.out.println("Please enter a valid ID number.\n");
                            userInput();
                    break;
                }
            } else {
                String str = kboard.nextLine();                                         //If user did not input a number, check if they want to exit

                if (str.equalsIgnoreCase("exit")) {
                    System.out.println("System shutting down...\n");
                    System.exit(0);  
                } 
                else {
                    System.out.println("Please enter a valid ID number.\n");
                    userInput();
                }
            }
        } catch (Throwable e) {
            System.out.println(e);
        }
        finally {kboard.close();}
    }

    /*
        ID 0: Sum of all integers less than or equal to 1000
    */
    public static void ID0_sum1000()
    {
        int sum = 0;
        int num;

        for (num = 0; num <= 1000; num++)
        {
            sum = sum + num;
        }

        System.out.println("Sum of all integers less than or equal to 1000:\nThe sum is " + sum + ".\n");

        userInput();
    }

    /*
        Project Euler ID 1
            Sum of all integers less than 1000 that are divisible by 3 or 5
    */
    public static void ID1_sum3and5()
    {
        int sum = 0;

        for (int num = 1; num < 1000; num++)
        {
            if (num % 3 == 0 || num % 5 == 0)   //Check divisibility
            {
                sum = sum + num;                //Add to total
            }
        }

        System.out.println("Sum of all integers divisible by 3 or 5 less than 1000:\nThe sum is " + sum + ".\n");
        userInput();
    }

    /*
        Project Euler ID 2
            Sum of all even fibonnaci numbers that are less than 4 000 000
    */
    public static void ID2_evenFib()
    {
        int fib1 = 1;   //Start with two fibonnaci numbers
        int fib2 = 2;
        int fib3 = 0;
        int total = 0;

        //Find fibonacci numbers
        while(fib3 < 3000000)   //This has to be less than 3 000 000 instead of 4 000 000 because fib3 has not been updated yet
        {
            fib3 = fib1 + fib2; //Fibonnaci numbers & shifting
            fib1 = fib2;
            fib2 = fib3;

            
            if (fib3 % 2 == 0)  //Check divisibility
            {
                total = total + fib3;   
            }
        }

        System.out.println("Sum of all even fibonnaci numbers less than 4,000,000:\nThe sum is " + total + ".\n");

        userInput();
    }

    /*
        Project Euler ID 4
        Largest palindrome made by multiplying two 3 digit numbers
    */
    public static void ID4_3digitPalindrome()
    {
        int palindrome = 0;
        int product;

        //Multiply all 3 digit numbers together (no need to check anything below 900)
        for (int i = 900; i >= 100 && i <= 999; i++)    
        {
            for (int j = 900; j>= 100 && j <= 999; j++)
            {
                product = i * j;

                //Check if it is a palindrome
                String prodString = String.valueOf(product);

                if (prodString.equals(new StringBuilder(prodString).reverse().toString()))
                {
                    palindrome = product;
                }
                

            }
        }

        System.out.println("Largest palindrome made by multiplying two 3-digit numbers:\nThe palindrome is " + palindrome + ".\n");

        userInput();
    }

    /*
        Project Euler ID 6
        Difference between:
            a) sum of the squares of the first ten natural numbers, i.e. 1^2 + 2^2 ...
            b) squares of the sum of the first ten natural numbers, i.e. (1 + 2 + ...)^2
    */
    public static void ID6_differenceOfSumsAndSquares()
    {
        double sumSquare = 0;
        double squareSum = 0;

        for (double i = 0; i <= 100; i++)
        {
            sumSquare = Math.pow(i, 2) + sumSquare;
            squareSum = squareSum + i;
        }

        squareSum = Math.pow((double)squareSum, 2.0);

        double difference = squareSum - sumSquare;
        System.out.println("Difference:\nThe difference is " + (int)difference + ".\n");
    }
}