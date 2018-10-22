import java.util.Scanner;

public class Lab08g {
    public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter arguments (start, end): ");

        int start = kboard.nextInt();
        int end = kboard.nextInt();

        int total, evenCount, oddCount;
        total = evenCount = oddCount = 0;

        for (int i = start; i <= end; i++) {
            total = total + i;
            
            if (i % 2 == 0) evenCount++;
            else oddCount++;
        }
        
        System.out.println(start + " " + end);
        System.out.println("total " + total);
        System.out.println("even count " + evenCount);
        System.out.println("odd count " + oddCount);

    }
}