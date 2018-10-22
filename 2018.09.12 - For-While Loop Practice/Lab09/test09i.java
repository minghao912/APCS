import java.util.Scanner;

public class test09i {
    public static void main(String[] args) {

        int number = 2500;
        int base = 16;

        int quotient = number / base;
        int remainder = number % base;

        if (quotient == 0) // base case
        {
            System.out.print(Integer.toString(remainder));   
        }
        else
        {
            System.out.println(convert(quotient, base) + Integer.toString(remainder));
        }            
        
    }
}