import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.File;

public class NumberDoubler2 {
    public static void main(String[] args) {
        FileChooser ken = new FileChooser("Select File");
        Scanner yeet;

        try {
            yeet = new Scanner(new File(ken.getFilePath()));
        } catch (Throwable e) {
            e.printStackTrace();
            return;
        }
        
        while(yeet.hasNext()) {
            String userInput = yeet.nextLine();
            
            if(userInput.toLowerCase().contains("exit")) break;
            
            String response = dub(userInput);
            System.out.println(response);
        }

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

//17/12/2018 10:32