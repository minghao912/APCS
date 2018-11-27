import java.util.ArrayList;
import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) {
        String[] givenStr = {"Bill", "Mary", "Lee", "Agnes", "Alfred", "Thomas", "Alvin", "Bernard", "Ezra", "Herman"};
        
        ArrayList<String> newList = new ArrayList<String>(givenStr.length);
        for (int i = 0; i < givenStr.length; i++) {
            newList.add(null);
        }

        String[] firstLetter = new String[givenStr.length - 1];
        for (int i = 0; i < givenStr.length - 1; i++) {
            firstLetter[i] = (i + " : " + (int) givenStr[i].charAt(0));
            System.out.println(Arrays.toString(firstLetter));
        }

        int[] numbers = new int[firstLetter.length - 1];
        for (int i = 0; i < firstLetter.length - 1; i++) {
            numbers[i] = Integer.parseInt(firstLetter[i].substring(firstLetter[i].indexOf(":") + 2));
            System.out.println(Arrays.toString(numbers));
        }

        Integer[] sortedNumbers = new Integer[numbers.length - 1];
        for (int j = 0; j < sortedNumbers.length; j++) {
            int smallestNumber = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] < smallestNumber) {
                    smallestNumber = numbers[i];
                    index = i;
                }
            }

            sortedNumbers[j] = smallestNumber;
            smallestNumber = Integer.MAX_VALUE;
            numbers[index] = Integer.MAX_VALUE;
            index = -1;

            System.out.println(Arrays.toString(sortedNumbers));
        }

        ArrayList<Integer> sortedNumbersList = new ArrayList<Integer>(Arrays.asList(sortedNumbers));
        for (int i = 0; i < firstLetter.length; i++) {
            newList.add(sortedNumbersList.indexOf(Integer.parseInt(firstLetter[i].substring(firstLetter[i].indexOf(":") + 2))), givenStr[Integer.parseInt(firstLetter[i].substring(0, 1))]);
            System.out.println(Arrays.toString(newList.toArray(new String[0])));
        }
    }
}