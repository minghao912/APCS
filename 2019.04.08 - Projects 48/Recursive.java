import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Recursive {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.print("What is the number? ");
        long n = k.nextLong();
        if (n <= 180000000L) {
            try {
                three(n);
            } catch (StackOverflowError e) {
                System.out.println("Stack Overflow: re-launch with option -Xss4095m flag");
                System.exit(0);
            }
        } else System.out.println("Largest number this program can handle is 180,000,000");
        k.close();
    }

    public static void three(long n) {
        System.out.println("Calculating...");
        ArrayList<Long> factors = new ArrayList<Long>();

        long start = System.nanoTime();

        long d = 1L;
        long end = n/2;

        qwerty(n, d, end, factors);

        long stop = System.nanoTime();
        
        java.util.Collections.sort(factors);
        factors.forEach(a -> System.out.print(a + " "));
        System.out.println("\nTime elapsed " + (stop - start) + "ns");
    }

    public static void qwerty(long n, long d, long end, ArrayList<Long> f) {
        if (d >= end) return;
        if (n % d == 0) {
            f.add(d);
        }
        qwerty(n, d + 1, end, f);
    }
}