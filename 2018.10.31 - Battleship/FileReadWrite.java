import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

/**
 * Reads and writes files.
 */
public class FileReadWrite {
    /**
     * <h3>Reads Specified Files</h3> Reads a file from a specified filepath and
     * returns a {@code List<String>} of elements seperated by commas in the file.
     * 
     * @param filepath - a {@code String} of the file to read
     */
    public List<String> read(String filepath) {
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

        } catch (Throwable e) {
            System.out.println("> Error occured reading file");
            e.printStackTrace();
            Error.displayError("Fatal Error", "Could not read file: " + filepath);
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
     */
    public void write(String filepath, String[] stuffToWrite) {
        try {
            PrintWriter writer = new PrintWriter(filepath, "UTF-8");
            
            for (int i = 0; i < stuffToWrite.length - 1; i++) 
                if (stuffToWrite[i].trim().length() != 0)
                    writer.println(stuffToWrite[i] + ",");
            if (stuffToWrite[stuffToWrite.length - 1].trim().length() != 0)   //Don't want comma on last line
                writer.println(stuffToWrite[stuffToWrite.length - 1]);  
            
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