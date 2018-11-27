import java.util.Arrays;

public class StringSortActual {
    public static void main(String[] args) {
        String[] givenStr = { "Bill", "Mary", "Lee", "Agnes", "Alfred", "Thomas", "Alvin", "Bernard", "Ezra", "Herman" };
        Arrays.sort(givenStr);
        for (String str : givenStr) System.out.println(str);

        String[] strArr2 = new String[givenStr.length - 1];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = givenStr[givenStr.length - 1 - i];
        }

        System.out.println("\n");
        System.out.printf("%-30.30s %-30.30s%n", "Ascending", "Descending");
        System.out.println();
        for (int i = 0; i < givenStr.length; i++) {
            System.out.printf("%-30.30s %-30.30s%n", givenStr[i], strArr2[i]);
        }
    }
}