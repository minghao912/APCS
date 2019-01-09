import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class NumberDoubler2 {
    public static void main(String[] args) {
        String filename = args[0];
        int scale;
        try {
            scale = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid scaling percentage entered.");
            e.printStackTrace();
            return;
        }

        Scanner yeet;
        try {
            yeet = new Scanner(new File(filename));
        } catch (Throwable e) {
            e.printStackTrace();
            return;
        }

        PrintWriter p;
        try {
            p = new PrintWriter(new FileWriter("./" + filename.substring(0, filename.lastIndexOf(".")) + "x2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        while(yeet.hasNext()) {
            String userInput = yeet.nextLine();
            
            if(userInput.toLowerCase().contains("exit")) break;
            
            String response = dub(userInput, scale);
            p.println(response);
        }

        p.close();
        yeet.close();
        System.exit(0);
    }

    public static String dub(String in, int scale) {
        String[] words = in.split("(?<=[\\D+])|(?=[\\D+])");    //Split the input when it encounters non-numbers (but also include the numbers in the result array)
        //System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            try {   //Try to multiply each element by the scaling factor, and if it's not a number, skip
                words[i] = Integer.parseInt(words[i]) * (scale / 100) + "";
            } catch (NumberFormatException e) {
                continue;
            }
        }

        String result = ""; //Concatenate final string
        for (String part : words) result += part;

        return result;
    }
}

//08/01/2019 17:34