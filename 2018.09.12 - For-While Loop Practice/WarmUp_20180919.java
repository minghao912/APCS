public class WarmUp_20180919 {
    public static void main (String[] args) {

        double[] GPA = {4.0, 1.6, 3.8, 3.0};

        for (double gpa : GPA) {
            if (gpa < 2) System.out.println(gpa + " good job!");
        }
    }
}