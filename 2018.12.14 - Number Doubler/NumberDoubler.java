import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberDoubler {
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
        String result = "";

        //Split the input into 2 arrays: one of the words, and one of the numbers.
        String[] userInArr = in.split("\\d+");
        String[] resultArr = in.replaceAll("\\D", " ").split("\\s+");

        //Test only
        System.out.println(Arrays.toString(userInArr));
        System.out.println(Arrays.toString(resultArr));

        //Convert the split arrays into arraylists so we can add things to them
        ArrayList<String> userInList = new ArrayList<String>(Arrays.asList(userInArr));
        ArrayList<String> resultList = new ArrayList<String>(Arrays.asList(resultArr));

        //Make the two lists equal in length
        if (userInList.size() > resultList.size()) resultList.add("");
        else if (userInList.size() < resultList.size()) userInList.add("");
        
        //Double the numbers
        for (int i = 0; i < resultList.size(); i++) 
            if (!resultList.get(i).equals("")) 
                resultList.set(i, Integer.parseInt(resultList.get(i)) * 2 + "");

        //Piece the two arrays together
        boolean starter = (userInList.get(0).equals(null)) ? false : true;  //Figure out which array to start with
        for (int i = 0; i < resultList.size(); i++) {
            if (starter) result += resultList.get(i) + userInList.get(i);
            else result += userInList.get(i) + resultList.get(i);
        }

        return result;
    }
}

//14/12/2018 20:23