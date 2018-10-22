import java.util.Scanner;
import java.util.Arrays;

public class Lab08i {
    public static void main(String[] args) {

        stepOne();
        
    }

    public static void stepOne() {
        
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a number, greater than 1: ");

        int num = kboard.nextInt();

        if (num == 1) {
            System.out.println("1 is not a valid input.\n");
            System.exit(1);
        }

        boolean[] val = new boolean[num - 2];   //num must be 2 or greater, so index[0] is the number 2

        //Initially set all values to be true
        for (int i = 0; i < val.length; i++) {
            val[i] = true;
        }

        boolean[] primeTestReturn = quickMaths(val, num);   //Retreive result from quickMaths
        
        //Count the number of trues in the resulting boolean arr
        int trueCount = 0;
        for (int i = 0; i < primeTestReturn.length; i++) {
            if (primeTestReturn[i]) {
                trueCount++;
            }
        }

        System.out.println("There are " + trueCount + " primes under " + num);

        //Create new array of primes
        int[] primes = new int[trueCount];

        for (int i = 0; i < primeTestReturn.length; i++) {
            if (primeTestReturn[i]) {
                primes[i] = i;
            }
        }

        String[] primeString = Arrays.stream(primes).mapToObj(String :: valueOf).toArray(String[]::new);

        System.out.println("For all numbers under " + num + ", these are prime: \n" + String.join(", ", primeString));

    }

    public static boolean[] quickMaths(boolean[] valArr, int max) {

        //Starting at index[0] (number 2)
        for (int i = 0; i < Math.sqrt(valArr.length); i++) {

            System.out.println("index " + i + ", number " + (i + 2) + ", working...");
            
            //If array value is true
            if (valArr[i] = true) {
                
                //index[0] is equal to the number 2
                int k = i + 2;

                //Then for i^2, i^2 + i, i^2 + 2i, etc.
                for (int j = k * k; j < max; j = j + k) {
                    valArr[j - 2] = false;  //Set array value to be false
                    System.out.println(j + " is not a prime.");
                }
            }
            
        }

        return valArr;
    }
}