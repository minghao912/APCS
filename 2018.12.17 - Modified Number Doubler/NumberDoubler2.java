import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class NumberDoubler2 {
    public static void main(String[] args) {
        Scanner yeet;
    
        try {
            yeet = new Scanner(new File(args[0]));
        } catch (Throwable e) {
            e.printStackTrace();
            return;
        }

        PrintWriter p;
        try {
            p = new PrintWriter(new FileWriter("./" + args[0].substring(0, args[0].lastIndexOf(".")) + "x2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        while(yeet.hasNext()) {
            String userInput = yeet.nextLine();
            
            if(userInput.toLowerCase().contains("exit")) break;
            
            String response = dub(userInput);
            p.println(response);
        }

        p.close();
        yeet.close();
        System.exit(0);
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

//07/01/2019 22:13