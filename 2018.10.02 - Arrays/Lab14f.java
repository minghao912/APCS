import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab14f {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the term you would like: ");
        int term = keyboard.nextInt();

        if (term > 169) {
            System.out.println("-1"); 
            System.exit(1);
        }

        List<Long> fibSeq = fibonacci(term + 1);

        System.out.println("\nThe " + term + "th term is: " + fibSeq.get(term - 1));
    
    }

    public static List fibonacci(int termLimit) {
        List<Long> fib = new ArrayList<>();

        fib.add((long)1);
        fib.add((long)1);

        for (int i = 0; i < termLimit; i++) {
            fib.add((long)(fib.get(i) + fib.get(i + 1)));
        }

        return fib;
    }
}