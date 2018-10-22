import java.util.Arrays;
import java.util.Scanner;

public class Lab14i_new2
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input a number, either in base 10 or roman numeral: ");

        String input = keyboard.nextLine();
        keyboard.close();

        try {   //If input is number
            int num = Integer.parseInt(input);

            if (num > 3999) {   //max number with support in Roman Numeral System
                System.out.println("The Roman Numeral System only supports numbers less than 3999. Please try again with a smaller number.");
                System.exit(1);
            }

            String result = intToRM(num);
            System.out.println(input + " is " + result);

        } catch (NumberFormatException e) { //If input is not a number
            String rn = input.toUpperCase().replaceAll("[^IVXLCDM]", "");     //Remove all non-roman numerals 
            int result = RMtoInt(rn);

            System.out.println(rn + " is " + result);
        }
    }

    //Roman numerals and values
    public static char[] RM = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
    public static Integer[] value = { 1, 5, 10, 50, 100, 500, 1000 };
    
    public static String intToRM(int num) 
    {
        String result = "", nineFour = "";

        int i = 1;
        while(num > 0) 
        {
            if (value[value.length - i] <= num) 
            {   //Deal with the roman numerals IX, IV, etc.
                String numStr = num + "";
                
                if (numStr.contains("9") || numStr.contains("4")) 
                { 
                    int nineOrFour = numStr.contains("9") ? 9 : 4;    //Determine if input contains nine or four

                    int indexFromBack = numStr.length() - 1 - numStr.indexOf(nineOrFour + "");   //Find the magnitude of the 9 or 4, i.e. 9x100, 4x10

                    num -= (nineOrFour * Math.pow(10, indexFromBack));

                    //Add values to the resulting
                    nineFour += RM[Arrays.asList(value).indexOf((int) Math.pow(10, indexFromBack))];
                    if (nineOrFour == 9) nineFour += RM[Arrays.asList(value).indexOf((int) Math.pow(10, (indexFromBack + 1)))];
                    else nineFour += RM[Arrays.asList(value).indexOf((int) (5 * Math.pow(10, indexFromBack)))];
                }
                else 
                {
                    result += RM[RM.length - i];
                    num -= value[value.length - i];
                }
            }
            else i++;
        }

        return result + nineFour;
    }

    public static int RMtoInt(String roem) 
    {
        char[] romanNumerals = roem.toCharArray();
        String RMStr = new String(RM);

        int result = 0;

        for (int i = 0; i < romanNumerals.length; i++) 
        {
            char char1 = romanNumerals[i];

            if (RMStr.contains(char1 + ""))  //if the roman numerals array contains a character of the user's input
            {   
                int ind1 = RMStr.indexOf(char1);

                if (i < romanNumerals.length - 1) 
                { //Check if there is any instances of IX, IV, etc.
                    char char2 = romanNumerals[i + 1];
                    int ind2 = RMStr.indexOf(char2);
                
                    if (value[ind2] > value[ind1])
                    {
                        result += (value[ind2] - value[ind1]);  //add the value of the roman numeral to the result
                        romanNumerals[i] = ' ';         //remove the roman numerals from the array of roman numerals
                        romanNumerals[i + 1] = ' ';
                    }
                    else {
                        result += value[ind1];   //add the value of the roman numeral to the result
                        romanNumerals[i] = ' '; //remove the roman numeral from the array of roman numerals
                    }
                }
                else 
                {
                    result += value[ind1];
                    romanNumerals[i] = ' ';
                }
            }
        }

        return result;
    }
}

//8th SPOOKtober 2018 (08 10 2018) 16:56