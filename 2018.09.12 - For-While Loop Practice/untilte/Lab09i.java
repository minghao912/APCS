import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Lab09i 
{
    public static void main(String[] args) 
    {
        Scanner kboard = new Scanner(System.in);

        //Ask user for input and do Scanner stuff
        System.out.print("Please enter a decimal number, followed by the destination base (up to 25): ");        
        int num = kboard.nextInt();
        int base = kboard.nextInt();

        if (base > 25) 
        {
            System.out.println("Invalid destination base.");
            System.exit(1);
        }

        System.out.print(num + " base 10 is "); //Print first part of the result

        //Do actual work
        ArrayList<Integer> result = new ArrayList<Integer>();   //Make an list to store the converted number

        //Convert the number
        while (num > 0)
        {
            result.add(num % base);
            num = num / base;
        }

        //Reverse the result
        Collections.reverse(result);
        
        //Convert numbers to letters, if necessary
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
        
        for (int element : result) 
        {
            char digit = '\u0000';  //Start off as null
            
            //If the resulting number contains any number higher than 10, convert to letters A-O
            if (element >= 10) digit = alphabet[element - 10];
            else digit = (char)(element + 48);  //Add 48 because ASCII numbers start at 48 and up

            System.out.print(digit);           
        }

        //Print final part of result
        System.out.print(" in base " + base + "\n");

        //End
        kboard.close();        
    }
}