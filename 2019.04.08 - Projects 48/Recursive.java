import java.util.ArrayList;

public class Recursive {
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

    public static void three(long n) {
        System.out.println("Calculating...");
        ArrayList<Long> factors = new ArrayList<Long>();

        long start = System.nanoTime();

        long d = 4;
        long end = (long) Math.sqrt(n);

        do {
            qwerty(n, d, factors);
            qwerty(n, d--, factors);
            qwerty(n, d--, factors);
            qwerty(n, d--, factors);
        } while (d <= end);

        long stop = System.nanoTime();

        Collections.sort(factors);
        factors.forEach(a -> System.out.print(a + " "));
        System.out.print(n);
        System.out.println("\nTime elapsed " + (stop - start) + "ns");
    }

    public static void qwerty(long n, long d, ArrayList<Long> f) {
        if (n % d == 0) {
            f.add(d);
            f.add(n/d);
        }
    }
}