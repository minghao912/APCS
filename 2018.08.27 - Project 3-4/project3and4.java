public class project3and4{
    public static void main(String[] args) {
        System.out.println("Project 3");
        System.out.println("---------");
        project3();

        System.out.println("\n\n");

        System.out.println("Project 4");
        System.out.println("---------");
        project4_Tester();
    }

    public static void project3() {

        //Declare given names
        String s1, s2, s3;
        s1 = "Allan Alda";
        s2 = "John Wayne";
        s3 = "Gregroy Peck";

        //Form the output
        System.out.println(s1 + ">>>" + s1.substring(2, s1.length() - 3));
        System.out.println(s2 + ">>>" + s2.substring(2, s2.length() - 3));
        System.out.println(s3 + ">>>" + s3.substring(2, s3.length() - 3));

    }

    public static void project4_Tester() {
        String math1, math2, math3;
        int int1, int2, int3;

        //Arithmetic 1
        math1 = "79 + 3 * (4 + 82 - 68) - 7 + 19";
        int1 = 79 + 3 * (4 + 82 - 68) - 7 + 19;

        //Arithmetic 2
        math2 = "(179 + 21 + 10) / 7 + 181";
        int2 = (179 + 21 + 10) / 7 + 181;

        //Arithmetic 3
        math3 = "10389 * 56 * 11 + 2246";
        int3 = 10389 * 56 * 11 + 2246;

        //Final Print
        System.out.println(math1 + " = " + int1);
        System.out.println(math2 + " = " + int2);
        System.out.println(math3 + " = " + int3);

    }
}