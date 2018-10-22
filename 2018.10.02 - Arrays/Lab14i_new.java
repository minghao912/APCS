import java.util.Arrays;
import java.util.Scanner;

public class Lab14i_new 
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
                System.out.println("no. pls smaller number");
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
                
                if ((num + "").contains("9")) 
                { 
                    int indexOf9FromBack = numStr.length() - 1 - numStr.indexOf("9");   //Find the magnitude of the 9, i.e. 9x100
                    
                    num -= (9 * Math.pow(10, indexOf9FromBack));

                    nineFour += RM[Arrays.asList(value).indexOf((int) Math.pow(10, indexOf9FromBack))];
                    nineFour += RM[Arrays.asList(value).indexOf((int) Math.pow(10, (indexOf9FromBack + 1)))];
                }
                else if ((num + "").contains("4")) {
                    int indexOf4FromBack = numStr.length() - 1 - numStr.indexOf("4"); //Find the magnitude of the 9, i.e. 9x100

                    num -= (4 * Math.pow(10, indexOf4FromBack));

                    nineFour += RM[Arrays.asList(value).indexOf((int) Math.pow(10, indexOf4FromBack))];
                    nineFour += RM[Arrays.asList(value).indexOf((int) (5 * Math.pow(10, indexOf4FromBack)))];
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
                if (i < romanNumerals.length - 1) 
                { //Check if there is any instances of IX, IV, etc.
                    char char2 = romanNumerals[i + 1];
                
                    if (value[RMStr.indexOf(char2)] > value[RMStr.indexOf(char1)])
                    {
                        result += (value[RMStr.indexOf(char2)] - value[RMStr.indexOf(char1)]);
                        
                        romanNumerals[i] = ' ';
                        romanNumerals[i + 1] = ' ';
                    }
                    else {
                        int ind = RMStr.indexOf(char1);  //Find index of the roman numeral

                        result += value[ind];   //add the value of the roman numeral to the result

                        romanNumerals[i] = ' '; //remove the roman numeral from the array of roman numerals
                    }
                }
                else 
                {
                    int ind = RMStr.indexOf(char1);

                    result += value[ind];

                    romanNumerals[i] = ' ';
                }
            }
        }

        return result;
    }
}

//5th SPOOKtober 2018 (05 10 2018)