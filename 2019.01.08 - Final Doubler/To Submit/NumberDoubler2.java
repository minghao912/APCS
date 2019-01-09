import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;

public class NumberDoubler2 {
    public static void main(String[] args) {
        String filename = args[0];
        double scale;
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
            String inputLine = yeet.nextLine();

            if (containsWhitelistedWord(filename, inputLine)) {
                    p.println(dub(inputLine, scale));
            } else p.println(inputLine);
        }

        p.close();
        yeet.close();
        System.exit(0);
    }

    public static String dub(String in, double scale) {
        String[] words = in.split("(?<=[\\D+])|(?=[\\D+])");    //Split the input when it encounters non-numbers (but also include the numbers in the result array)
        //System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            try {   //Try to multiply each element by the scaling factor, and if it's not a number, skip
                words[i] = (int) (Integer.parseInt(words[i]) * (double) (scale / 100)) + "";    //This program outputs truncated decimals
            } catch (NumberFormatException e) {
                continue;
            }
        }

        String result = ""; //Concatenate final string
        for (String part : words) result += part;

        return result;
    }

    public static String[] getWhitelist(String filename) throws FileNotFoundException{
        ArrayList<String> whitelistWords = new ArrayList<String>();

        Scanner getWordsFromFile = new Scanner(new File(filename + ".whitelist"));
        while(getWordsFromFile.hasNext()) 
            whitelistWords.add(getWordsFromFile.nextLine());

        getWordsFromFile.close();
        return whitelistWords.toArray(new String[0]);
    }

    public static boolean containsWhitelistedWord(String filename, String lineToCheck) {
        // Get whitelist
        String[] whitelist = null; 
        try {
            whitelist = getWhitelist(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please ensure whitelist is in the directory as follows:\n<filename>.whitelist\n");
            e.printStackTrace();
            System.exit(1);
        }

        for (String word : whitelist)
            if (lineToCheck.contains(word))
                return true;

        return false;
    }
}

//08/01/2019 17:38