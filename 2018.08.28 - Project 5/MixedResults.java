public class MixedResults {
    public static void main(String[] args) {
        
        //Starting vars
        double d1 = 37.9;
        double d2 = 1004.128;
        int i1 = 12;
        int i2 = 18;

        //Actual work
        double problem1 = 57.2 * (i1/i2) + 1;
        double problem2 = 57.2 * ((double)i1/i2) + 1;
        double problem3 = 15 - i1 * (d1 * 3) + 4;
        int problem4 = 15 - i1 * (int)(d1 * 3) + 4;
        int problem5 = 15 - i1 * ((int)d1 * 3) + 4;

        //Print
        System.out.println("Problem 1: " + problem1);
        System.out.println("Problem 2: " + problem2);
        System.out.println("Problem 3: " + problem3);
        System.out.println("Problem 4: " + problem4);
        System.out.println("Problem 5: " + problem5);

    }
}