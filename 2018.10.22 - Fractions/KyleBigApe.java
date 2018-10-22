import java.util.Scanner;

public class KyleBigApe {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter numerator: ");
        int numerator = keyboard.nextInt();
        System.out.print("Please enter denominator: ");
        int denominator = keyboard.nextInt();

        Fraction doofus = new Fraction(numerator, denominator);

        //Printing
        System.out.println();
        doofus.print();
        System.out.println();
        doofus.printFancy();

        //Factors
        System.out.println();
        Object[] factors = doofus.getFactors();
        Integer[] factorsN = (Integer[]) factors[0];
        Integer[] factorsD = (Integer[]) factors[1];

        System.out.print("The factors of the numerator is: ");
        for (Integer factor : factorsN)
            System.out.print(factor + " ");
        System.out.println();
        System.out.print("The factors of the denominator is: ");
        for (Integer factor : factorsD)
            System.out.print(factor + " ");
        System.out.println("\n");

        // Reducibility
        System.out.println();
        if (doofus.isReducible())
            System.out.println("Your fraction is reducible.");
        else
            System.out.println("Your fraction is not reducible.");

        //Reduce
        Fraction reduced = doofus.reduce();
        System.out.println("Your reduced fraction is " + reduced.getNumerator() + "/" + reduced.getDenominator());
    }
}