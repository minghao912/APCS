import java.util.Scanner;

public class Terster {
    public static void main(String[] args) {
        Scanner query = new Scanner(System.in);
        
        while(true) {
            System.out.print("Type in a sentence and press ENTER: ");

            String input = query.nextLine().toUpperCase();      //Criteria 3: Uppercase

            if (input.contains("EXIT")) break;
                                                
            input += "KYLE IS ONE BIG FLIPPING DUMBBUTT";       //Criteria 4: Concatenate safe string

            String[] sp = input.split("S\\s*A");                //Criteria 5: Split input into String array
            int occurences = sp.length - 1;                     //Criteria 6: Count occurences

            System.out.println("There are " + occurences + " occurences.\n");
        }

        query.close();
        System.exit(0);
    }
}

//07/12/2018 19:59