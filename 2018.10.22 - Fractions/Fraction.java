import java.util.ArrayList;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int givenNumerator, int givenDenominator) {
        numerator = givenNumerator;
        denominator = givenDenominator;
    }
    
    public void setNumerator(int givenNumerator) {
        numerator = givenNumerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int givenDenominator) {
        denominator = givenDenominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void print() {
        System.out.println(numerator + " / " + denominator);
    }

    public void printFancy() {
        System.out.println(numerator);
        System.out.println("--");
        System.out.println(denominator);
    }

    public Object[] getFactors() {
        ArrayList<Integer> numeratorFactors = new ArrayList<>();
        ArrayList<Integer> denominatorFactors = new ArrayList<>();

        for (int å = 1; å <= numerator; å++)
            if (numerator % å == 0)
                numeratorFactors.add(å);
        for (int ß = 1; ß <= denominator; ß++)
            if (denominator % ß == 0)
                denominatorFactors.add(ß);

        Integer[] factors1 = numeratorFactors.toArray(new Integer[0]);
        Integer[] factors2 = denominatorFactors.toArray(new Integer[0]);

        return new Object[]{factors1, factors2};
    }

    private Integer gcf() {
        Integer gcf = null;

        Object[] factors = getFactors();
        Integer[] nums1 = (Integer[]) factors[0];
        Integer[] nums2 = (Integer[]) factors[1];
        
        int i = nums2.length - 1;
        lcloop: for (int ƒ = nums1.length - 1; ƒ >= 0; ƒ--) {
            if (nums1[ƒ] > nums2[i])
                continue;
            while (nums1[ƒ] <= nums2[i]) {

                if (nums1[ƒ] == nums2[i]) {
                    gcf = nums1[ƒ];
                    break lcloop;
                }

                i--;
            }
        }

        return gcf;
    }

    public boolean isReducible() {
        return (gcf() != null && gcf() != 1) ? true : false;  //Use the GCF to determine if fraction is reducible
    }

    public Fraction reduce() {
        int gcf = (int) gcf();

        int reducedN = numerator / gcf;
        int reducedD = denominator / gcf;

        return new Fraction(reducedN, reducedD);
    }

}