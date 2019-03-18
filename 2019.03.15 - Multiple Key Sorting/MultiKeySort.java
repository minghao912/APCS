import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;

public class MultiKeySort {
    public static void main(String[] args) {
        ArrayList qwerty = new ArrayList<String>();

        try {
            Scanner s = new Scanner(new File("./Names_ages.kylebigdumb"));
            while(s.hasNextLine()) {
                qwerty.add(s.nextLine());
            }
            s.close();
        } catch (Exception e) {e.printStackTrace();}

        System.out.println(qwerty);

        sort(qwerty);
        System.out.println(qwerty);
    }

    public static void sort(ArrayList<String> asdf) {
        int min, minIndex;
        for(int i = 0; i < asdf.size(); i++) {
            minIndex = i;
            for(int j = i + 1; j < asdf.size(); j++) {
                if(asdf.get(j).compareTo(asdf.get(minIndex)) < 0) minIndex = j;
            }
            String temp = asdf.get(i);
            asdf.set(i, asdf.get(minIndex));
            asdf.set(minIndex, temp);
        }
    }
}