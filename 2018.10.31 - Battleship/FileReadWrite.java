import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;

/**
 * Reads and writes files.
 */
public class FileReadWrite {
    /**
     * <h3>Reads Specified Files</h3>
     * Reads a file from a specified filepath and
     * returns a {@code List<String>} of elements
     * seperated by commas in the file.
     * 
     * @param   filepath                 - a {@code String} of the file to read
     * @return  {@code List<String>}    of elements seperated by commas
     * @exception   FileNotFoundException   if file not found
     */
    public static List<String> read(String filepath) {
        try {
            Scanner fileIn = new Scanner(new File(filepath)).useDelimiter(",\\s+"); //Split each section by "," followed by 1+ spaces
        
            List<String> members = new ArrayList<>();
            List<String> membersCopy = members;

            while (fileIn.hasNext()) {
                members.add(fileIn.next());
            }

            fileIn.close();
            System.out.println("> Leaderboard Scores: " + Arrays.toString(membersCopy.toArray()));

            return members;

        } catch (FileNotFoundException e) {
            System.out.println("> File to read not found");
            e.printStackTrace();
            Error.displayError("Fatal Error", "Could not find file to read: " + filepath);
        }
        return null;
    }

    /**
     * <h3>Writes Information to File</h3> Given a specified filepath and a
     * {@code String[]} of values to write, it will overwrite/create a file with
     * those values.
     * 
     * @param filepath - a {@code String} of the file to be created and/or written to
     * @param stuffToWrite - a {@code String[]} of elements to be written to the file
     * @throws UnsupportedEncodingException if the file is not utilising UTF-8
     * @throws FileNotFoundException        when the file could not be found
     */
    public static void write(String filepath, String[] stuffToWrite) {
        try {
            PrintWriter writer = new PrintWriter(filepath, "UTF-8");
            for (int i = 0; i < stuffToWrite.length - 1; i++) 
                writer.println(stuffToWrite[i] + ",");
            writer.println(stuffToWrite[stuffToWrite.length - 1]);  //Don't want comma on last line
            
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

// 18/11/2018 18:25