public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3, 18, 0, 9, 6};
        sort(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        boolean loopSomeMore;
        do {
            loopSomeMore = false;
            for (int j = 0; j < a.length - 1; j++) {
                if(a[j] > a[j+1]) {
                    //swap a[j] and a[j+1]
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;

                    loopSomeMore = true;
                }
            }
        } while(loopSomeMore);
    }
}