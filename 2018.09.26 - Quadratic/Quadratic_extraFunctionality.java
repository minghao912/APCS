import java.util.Arrays;

public class Quadratic_extraFunctionality
{
    public static void main(String[] args)
    {
        //Get numbers from args
        Double a = Double.parseDouble(args[0]);
        Double b = Double.parseDouble(args[1]);
        Double c = Double.parseDouble(args[2]);

        Double[] answers = littleMethod(a, b, c);

        //Sort answers from least to greatest, then format to 3 decimal places
        Arrays.sort(answers);
        String answer1 = String.format("%.3f", answers[0]);
        String answer2 = String.format("%.3f", answers[1]);

        //Check for imaginary numbers
        if (answer1.equals("NaN") || answer2.equals("NaN")) 
        {
            String[] imaginaryAnswer = imaginaryCalc(a, b, c);
            Arrays.sort(imaginaryAnswer);

            System.out.println("x is " + imaginaryAnswer[0] + ", " + imaginaryAnswer[1]);
        }
        else System.out.println("x is " + answer1 + ", " + answer2);
    }

    public static Double[] littleMethod(Double a, Double b, Double c)
    {
        Double[] answers = new Double[2];

        Double radical = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        Double bottom = 2 * a;

        answers[0] = (0 - b + radical) / bottom;
        answers[1] = (0 - b - radical) / bottom;

        return answers;
    }

    public static String[] imaginaryCalc(Double a, Double b, Double c) 
    {
        String[] answers = new String[2];

        Double radical = Math.sqrt(Math.pow(b, 2) - (4 * a * c) / -1);  //Divide by -1 to get rid of imaginary
        Double bottom = 2 * a;

        Double answer1 = (0 - b + radical) / bottom;
        Double answer2 = (0 - b - radical) / bottom;

        answers[0] = String.format("%.3f", answer1) + "i";  //Remember to add the "i" to signify imaginary numbers
        answers[1] = String.format("%.3f", answer2) + "i";

        return answers;
    }
}