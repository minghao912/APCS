import java.util.Scanner;

public class Lab09g {
    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter a string, with the removal string seperated by three spaces: ");

        //Inputs
        String input = kboard.nextLine();
        int indexOfSpace = input.indexOf("   ");  //Find first (two)space

        //Make the actual data to be used
        String removalStr = input.substring(indexOfSpace).replaceAll("\\s+", "");   //Delete all spaces in removal substring
        String data = input.substring(0, indexOfSpace); //Seperate out the string itself

        System.out.println(data + " - String to remove " + removalStr);

        //RegEx removal
        boolean i = true;
        while(i) {
            data = data.replaceAll("." + removalStr, "");
  
            //Keep running until the data string (resultant) no longer contains removal string
            if (!data.contains(removalStr)) i = false;
        }

        //Final printout
        System.out.println(data);

        //Close
        kboard.close();
    }
}