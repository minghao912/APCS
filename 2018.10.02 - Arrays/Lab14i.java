import java.util.Scanner;

public class Lab14i 
{
    public static void main(String[] args) 
    {
        String input = getInput();
        
        try {   //If input is number
            int num = Integer.parseInt(input);
            if (num > 8988) {   //max number
                System.out.println("no. pls smaller number");
                System.exit(1);
            }

            String result = intToRM(num);

            System.out.println(input + " is " + result);

        } catch (NumberFormatException e) { //If input is not a number
            int result = RMtoInt(input);

            System.out.println(input + " is " + result);
        }
    }

    public static String getInput() 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input a number, either in base 10 or roman numeral: ");
        
        return keyboard.nextLine();
    }

    public static String intToRM(int num) 
    {
        //Roman numerals and values
        String[] RM = {"I", "V", "X", "L", "C", "D", "M"};  
        int[] value = {1, 5, 10, 50, 100, 500, 1000};
        String result = "";

        int i = 1;
        while(num > 0) 
        {
            if (value[value.length - i] <= num) 
            {   //Deal with the roman numerals IX, IV, etc.
                if ((num + "").contains("9") || (num + "").contains("4")) 
                {
                    if (num - 900 > 0) {
                        result += "CM";
                        num -= 900;
                    } else if (num - 400 > 0) {
                        result += "CD";
                        num -= 400;
                    } else if (num - 90 > 0) {
                        result += "XC";
                        num -= 90;
                    } else if (num - 40 > 0) {
                        result += "XL";
                        num -= 40;
                    }

                    switch (num) {
                        case 9 :    result += "IX";
                                    num -= 9;
                                    break;
                        
                        case 4 :    result += "IV";
                                    num -= 4;
                                    break;

                        default :   {
                            result += RM[RM.length - i];
                            num -= value[value.length - i];
                            break;
                        }
                    } 
                }
                else 
                {
                    result += RM[RM.length - i];
                    num -= value[value.length - i];
                }
            }

            else i++;
        }

        return result;
    }

    public static int RMtoInt(String roem) 
    {
        //Roman numerals and values
        char[] RM = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int[] value = { 1, 5, 10, 50, 100, 500, 1000 };

        int result = 0;

        char[] romanNumerals = roem.toCharArray();

        for (int i = 0; i < romanNumerals.length; i++) 
        {
            char r = romanNumerals[i];

            if ((new String(RM)).contains(r + ""))  //if the roman numerals array contains a character of the user's input
            {   
                if (i < romanNumerals.length - 1) 
                { //Check if there is any instances of IX, IV, etc.
                    char s = romanNumerals[i + 1];
                
                    if (value[(new String(RM)).indexOf(s)] > value[(new String(RM)).indexOf(r)])
                    {
                        result += (value[(new String(RM)).indexOf(s)] - value[(new String(RM)).indexOf(r)]);
                        
                        romanNumerals[i] = ' ';
                        romanNumerals[i + 1] = ' ';
                    }
                    else {
                        int ind = (new String(RM)).indexOf(r);  //Find index of the roman numeral

                        result += value[ind];   //add the value of the roman numeral to the result

                        romanNumerals[i] = ' '; //remove the roman numeral from the array of roman numerals
                    }
                }
                else 
                {
                    int ind = (new String(RM)).indexOf(r);

                    result += value[ind];

                    romanNumerals[i] = ' ';
                }
            }
        }

        return result;
    }
}

// 2nd SPOOKtober 2018 (02 10 2018)