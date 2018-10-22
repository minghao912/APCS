public class Lab14a {
    public static void main(String[] args) {

        int start = 2;
        int end = 9;
        int number = 4;
        int[] providedArr = { 4, 10, 0, 1, 7, 6, 5, 3, 2, 9 };

        int sum = sum(providedArr, start, end);
        int numberOf = numberOf(providedArr, number);

        System.out.println("sum of spots " + start + "-" + end + " = " + sum);
        System.out.println("# of " + number + "s = " + numberOf);

    }

    public static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i - 1];
        }

        return sum;
    }

    public static int numberOf(int[] arr, int number) {
        int n = 0;
        for (int num : arr) {
            if (num == number) n++;
        }

        return n;
    }
}