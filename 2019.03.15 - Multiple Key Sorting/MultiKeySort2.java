import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class MultiKeySort2 {
    public static void main(String[] args) {
        ArrayList<String> qwerty = new ArrayList<String>();

        try {
            Scanner s = new Scanner(new File("./Names_ages.kylebigdumb"));
            while(s.hasNextLine()) qwerty.add(s.nextLine());
            s.close();
        } catch (Exception e) {e.printStackTrace();}

        System.out.println("> Source: " + qwerty); //Before
        sort(qwerty);
        System.out.println("> Result: " + qwerty); //After
    }

    public static void sort(ArrayList<String> asdf) {
        for(int i = 0; i < asdf.size(); i++) {
            int minIndex = i;
            for(int j = i + 1; j < asdf.size(); j++) {
                String curString = asdf.get(j);         //Current string j
                String minString = asdf.get(minIndex);  //String to compare against

                //Compares the names
                int nameComparison = curString.substring(0, curString.lastIndexOf(" ")).compareTo(minString.substring(0, minString.lastIndexOf(" ")));
                if (nameComparison < 0) minIndex = j;
                else if (nameComparison == 0) { //Only compare the ages if the names are the same
                    //Will be 'true' if the age1 is less than age2
                    boolean ageComparison = Integer.parseInt(curString.substring(curString.lastIndexOf(" ") + 1)) < Integer.parseInt(minString.substring(minString.lastIndexOf(" ") + 1));
                    if (ageComparison) minIndex = j;
                }
            }

            //Swap
            String temp = asdf.get(i);
            asdf.set(i, asdf.get(minIndex));
            asdf.set(minIndex, temp);

            //System.out.println(asdf);
        }
    }
}