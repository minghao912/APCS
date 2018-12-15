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
    }

    public static String dub(String in) {
        String[] words = in.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            int num;

            try {
                num = Integer.parseInt(words[i]);
            } catch (NumberFormatException e) {
                continue;
            }
            
            words[i] = num * 2 + "";
        }

        String result = "";
        for (String part : words) {
            result += part + " ";
        }

        return result;
    }
}