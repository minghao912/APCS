public class ID2
{
    public static void main(String[] args)
    {
        int fib1 = 1;
        int fib2 = 2;
        int fib3 = 0;
        int total = 0;

        //Find fibonacci numbers
        while(fib3 < 3000000)
        {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;

            
            if (fib3 % 2 == 0) 
            {
                System.out.println(fib3 + ", " + total);
                total = total + fib3;
            }

            
        }

        System.out.println("The sum is " + total);

    }
}