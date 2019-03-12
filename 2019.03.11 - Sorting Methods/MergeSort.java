public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3, 18, 0, 9, 6};
        sort(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }
    
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
    
    public static void sort(int[] a, int left, int right) {
        if (right == left) return;
        int middle = (left + right) / 2;
        sort(a, left, middle);
        sort(a, middle + 1, right);
        merge(a, left, middle, right);
    }
    
    public static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArray = new int[right - left + 1]; //important
        
        int index1 = left;
        int index2 = middle + 1;
        int indx = 0;
        
        while(index1 <= middle && index2 <= right) {
            if (a[index1] < a[index2]) {
                tmpArray[indx] = a[index1];
                index1++;
            } else {
                tmpArray[indx] = a[index2];
                index2++;
            }
            indx++;
        }
        
        while(index1 <= middle) {
            tmpArray[indx] = a[index1];
            index1++;
            indx++;
        }
        while(index2 <= right) {
            tmpArray[indx] = a[index2];
            index2++;
            indx++;
        }
        
        for(indx = 0; indx < tmpArray.length; indx++) a[left + indx] = tmpArray[indx];
    }
}
