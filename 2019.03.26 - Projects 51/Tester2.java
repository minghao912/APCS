public class Tester2 {
    public static void main(String[] args) {
        int[] i = {-7, 15, 21, 22, 43, 49, 51, 67, 78, 81, 84, 89, 95, 97};
        Integer[] iw = new Integer[i.length];
        for (int c = 0; c < i.length; c++) iw[c] = i[c];

        System.out.println(binarySearch(iw, 22));
        System.out.println(binarySearch(iw, 89));
        System.out.println(binarySearch(iw, -100));
        System.out.println(binarySearch(iw, 72));
        System.out.println(binarySearch(iw, 102));
    }

    public static <T> int binarySearch(T[] ab, T passVal) {
        if (!(passVal instanceof Comparable)) return Integer.MIN_VALUE;   //Check if it's comparable
        Comparable value = (Comparable) passVal;
        Comparable[] a = new Comparable[ab.length];
        for (int i = 0; i < ab.length; i++) a[i] = (Comparable) ab[i];

        int lower = 0;
        int upper = a.length - 1;

        while(lower <= upper) {
            int mid = (lower + upper) / 2;
            if (a[mid].compareTo(value) == 0) return mid;
            else if (value.compareTo(a[mid]) > 0) lower = mid + 1;
            else upper = mid - 1;
        } return -1;
    }
}