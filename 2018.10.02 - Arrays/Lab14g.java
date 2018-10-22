import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab14g {
    public static void main(String[] args) {
        int[] arr = retreiveInput();

        System.out.println(Arrays.toString(counter(arr)));
    }

    public static int[] retreiveInput() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input data: ");

        String[] str = keyboard.nextLine().split(" ");
        int[] intArr = new int[str.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(str[i]);
        }

        return intArr;
    }

    public static int[] counter(int[] input) {
        int[] count = new int[50];
        for (int n : count) count[n] = 0;
        
        int counter = 1;
        for (int i = 0; i < input.length; i++) {
            if(i < input.length - 1) {
                System.out.println(i + ". " + input[i] + ", " + input[i + 1] + "; " + counter);

                if (input[i] == input [i + 1]) ++counter;
                else {
                    for (int j = 0; j <= counter; j++) {
                        count[j]++;
                    }
                    counter = 1;
                }
            } else {
                count[counter - 1]++;
                counter = 1;
            }
        }

        return count;
    }
}