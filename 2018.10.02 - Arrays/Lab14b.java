import java.util.Arrays;

public class Lab14b {
    public static void main(String[] args) {
        int[] arr = {1, 7, 34, 678};

        //going up?
        boolean goingUp = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (!(arr[i + 1] > arr[i])) goingUp = false;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("is going Up ? " + goingUp);

        //going down?
        boolean goingDown = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (!(arr[i + 1] < arr[i]))
                goingDown = false;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("is going Down ? " + goingDown);
        
    }
}