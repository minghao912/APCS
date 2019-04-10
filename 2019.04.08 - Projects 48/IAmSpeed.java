import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class IAmSpeed {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.print("What is the number? ");
        long n = k.nextLong();
        System.out.print("Choose one:\n\t1. Level One\n\t2. Level Two\n\t3. Level Three\n> ");
        int o = k.nextInt();
        switch(o) {
            case 1: one(n);
                    break;
            case 2: two(n);
                    break;
            case 3: three(n);
                    break;
            default:    
                System.out.println("Invalid option. Please try again.");
                System.exit(0);
        }
        k.close();
    }

    public static void one(long n) {
        System.out.println("Calculating...");
        ArrayList<Long> factors = new ArrayList<Long>();

        long start = System.nanoTime();
        
        long d = 1L;
        do {
            if (n % d == 0) factors.add(d);
            d++;
        } while(d <= n/2);

        long stop = System.nanoTime();

        factors.forEach(a -> System.out.print(a + " "));
        System.out.print(n);
        System.out.println("\nTime elapsed " + (stop - start) + "ns");
    }

    public static void two(long n) {
        System.out.println("Calculating...");
        ArrayList<Long> factors = new ArrayList<Long>();

        long start = System.nanoTime();

        long d = 1L;
        long end = n/2;
        do {
            if (n % d == 0)
                factors.add(d);
            d++;
        } while (d <= end);

        long stop = System.nanoTime();

        factors.forEach(a -> System.out.print(a + " "));
        System.out.print(n);
        System.out.println("\nTime elapsed " + (stop - start) + "ns");
    }

    public static void three(long n) {
        System.out.println("Calculating...");
        ArrayList<Long> factors = new ArrayList<Long>();

        long start = System.nanoTime();

        long d = 1;
        long end = (long) Math.sqrt(n);

        do {
            if (n % d == 0) {
                factors.add(d);
                factors.add(n/d);
            }
            d++;
        } while (d <= end);

        long stop = System.nanoTime();

        Collections.sort(factors);
        factors.forEach(a -> System.out.print(a + " "));
        System.out.print(n);
        System.out.println("\nTime elapsed " + (stop - start) + "ns");
    }
}

/*
 * Level 1: 25405583702ns, 25406ms 
 * Level 2: 24893103088ns, 24893ms
 * Level 3: 00002014016ns, 02.01ms
 * 
 * i7-6700K 4.00GHz => Turbo 4.20 GHz
 * 3.5 years old
 */