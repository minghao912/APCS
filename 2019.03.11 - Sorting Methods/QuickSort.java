public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3, 18, 0, 9, 6};
        sort(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }
    
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
    
    public static void sort(int[] a, int left, int right) {
        if (left >= right) return;
        int k = left;
        int j = right;
        int pivotValue = a[(left + right) / 2];
        while (k < j) {
            while (a[k] < pivotValue) k++;
            while (pivotValue < a[j]) j--;
            if (k <= j) {
                int temp = a[k];
                a[k] = a[j];
                a[j] = temp;
                k++;
                j--;
            }
        }
        sort(a, left, j);
        sort(a, k, right);
    }
}
