import java.util.Arrays;

public class Lab14c {
    public static void main(String[] args) {
        int[] arr = {154, 2451, 541, 541, 5854, 0};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("num " + i + " :: ");
            System.out.printf("%-8.3s", arr[i]);
            System.out.println();
        }

        System.out.println("\nbiggest = " + arr[arr.length - 1]);
    }
}