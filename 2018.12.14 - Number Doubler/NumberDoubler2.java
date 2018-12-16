//This only works if the numbers are surrounded by spacees.

import java.util.Scanner;
import java.util.Arrays;

public class NumberDoubler2 {
    public static void main(String[] args) {
        Scanner yeet = new Scanner(System.in);
        
        while(true) {
            System.out.print("Please enter a sentence: ");
            String userInput = yeet.nextLine();
            
            if(userInput.toLowerCase().contains("exit")) break;
            
            String response = dub(userInput);
            System.out.println(response);
        }

        yeet.close();
    }

    public static String dub(String in) {
        String[] words = in.split("(?<=[\\D+])|(?=[\\D+])");    //Split the input when it encounters non-numbers (but also include the numbers in the result array)
        //System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            try {   //Try to multiply each element by 2, and if it's not a number, skip
                words[i] = Integer.parseInt(words[i]) * 2 + "";
            } catch (NumberFormatException e) {
                continue;
            }
        }

        String result = ""; //Concatenate final string
        for (String part : words) result += part;

        return result;
    }
}

//15/12/2018 19:25