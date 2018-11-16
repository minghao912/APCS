import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;

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
            System.out.println("> File to read not found");
            e.printStackTrace();
            Error.displayError("Fatal Error", "Could not find file to read: " + filepath);
        }
        return null;
    }

    public static void write(String filepath, String[] stuffToWrite) {
        try {
            PrintWriter writer = new PrintWriter(filepath, "UTF-8");
            for (String line : stuffToWrite) 
                writer.println(line + ",");
            writer.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println("> Unsupported Encoding");
            e.printStackTrace();
            Error.displayError("Fatal Error", "Unsupported Encoding: " + filepath);
        } catch (FileNotFoundException e) {
            System.out.println("File to write not found");
            e.printStackTrace();
            Error.displayError("Fatal Error", "Could not find file to write: " + filepath);
        }
    }
}