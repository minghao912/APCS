public class Quadratic
{
    public static void main(String[] args)
    {
        Double a = Double.parseDouble(args[0]);
        Double b = Double.parseDouble(args[1]);
        Double c = Double.parseDouble(args[2]);

        System.out.println("The positive x value is " + littleMethod(a, b, c));
    }

    public static Double littleMethod(Double a, Double b, Double c)
    {
        Double radical = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        Double twoA = 2 * a;
        
        Double answer = (0 - b + radical) / twoA;
        return answer;
    }
}