import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReadWrite {
    public static List<String> read(String filepath) {
        try {
            Scanner fileIn = new Scanner(new File(filepath)).useDelimiter(",\\s+"); //Split each section by "," followed by 1+ spaces
        
            List<String> members = new ArrayList<>();
            List<String> membersCopy = members;

            while (fileIn.hasNext()) {
                members.add(fileIn.next());
            }

            fileIn.close();
            System.out.println("> Leaderboard scores: " + Arrays.toString(membersCopy.toArray()));

            return members;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            Error.displayError("Fatal Error", "Could not find file" + filepath);
        }
        return null;
    }
}