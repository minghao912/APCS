import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReadWrite {
    public static void main(String[] filepath) {
        try {
            Scanner fileIn = new Scanner(new File(filepath)).useDelimiter(",\\s+"); //Split each section by "," followed by 1+ spaces
        
            List<String> members = new ArrayList<>();

            while (fileIn.hasNext()) {
                members.add(fileIn.next());
            }

            fileIn.close();
            System.out.println(Arrays.toString(members.toArray()));

            return;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
    }
}