public class ID1
{
    public static void main(String[] args)
    {
        int sum = 0;

        for (int num = 1; num < 1000; num++)
        {
            if (num % 3 == 0 || num % 5 == 0)
            {
                sum = sum + num;
                System.out.println(num);
            }
        }

        System.out.println("Sum is " + sum);
    }
}