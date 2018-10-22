import java.util.Scanner;

public class RadiusOfCircle{

    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);
        double input;

        //Ask for input
        System.out.println("What is the area?");

        if (kboard.hasNextDouble()){

            input = kboard.nextDouble();
            
            //Do math
            double radius, toBeSqrt;
            
            toBeSqrt = input / Math.PI;
            radius = Math.sqrt(toBeSqrt);

            //Out
            System.out.println("Radius of your circle is " + radius + ".");
           
        } else System.out.println("Invalid input. Please try again.");

    }
}