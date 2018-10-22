import java.util.Scanner;

public class Lab08k
{
    public static void main(String[] args)
    {

        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter two numbers, seperated by a space: ");

        int n1 = kboard.nextInt();
        int n2 = kboard.nextInt();

        int gcd = 1, p;
        
        p = n1 > n2 ? n1 : n2;  //If n1 is the bigger number, "p" is n1, n2 bigger -> p is n2

        for (int i = 1; i <= p; i++)
        {
            //If i divides both n1 and n2, and is greater than gcd, then i becomes gcd
            if (n1 % i == 0 && n2 % i == 0 && i > gcd) gcd = i; 
        }

        System.out.println("the gcd of " + n1 + " and " + n2 + " is " + gcd);
        
    }
}