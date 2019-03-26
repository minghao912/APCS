public class Tester1 {
    public static void main(String[] args) {
        int[] i = {97, 95, 89, 84, 81, 78, 67, 51, 49, 43, 22, 21, 15, -7};
        System.out.println(binarySearch(i, 22));    
        System.out.println(binarySearch(i, 89));
        System.out.println(binarySearch(i, -100));
        System.out.println(binarySearch(i, 72));
        System.out.println(binarySearch(i, 102));
    }

    public static int binarySearch(int[] a, int searchVal) {
        int lb = 0;
        int ub = a.length - 1;
        while(lb <= ub) {
            int mid = (lb + ub) / 2;
            if (a[mid] == searchVal) return mid;
            else if (searchVal < a[mid]) lb = mid + 1;
            else ub = mid - 1;
        } return -1;
    }
}