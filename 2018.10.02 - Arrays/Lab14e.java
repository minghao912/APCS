import java.util.Scanner;

public class Lab14e {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input a list of numbers: ");
        String listOfNumbers = keyboard.nextLine();

        String[] numArr = listOfNumbers.split(" ");
        int[] integer = new int[numArr.length];
        for (int i = 0; i < integer.length; i++) {
            integer[i] = Integer.parseInt(numArr[i]);
        }

        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int num : integer) {
            count[num]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " - " + count[i]);
        }

    }
}