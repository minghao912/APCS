public class Tester {
    public static void main(String[] args) {
        Checker bChecker = new SubstringChecker("beets");
        Checker cChecker = new SubstringChecker("carrots");
        Checker bothChecker = new AndChecker(bChecker, cChecker);

        Checker aChecker = new SubstringChecker("artichokes");
        Checker veggies = new AndChecker(bothChecker, aChecker);

        System.out.println(bothChecker.accept("I love beets and carrots"));
        System.out.println(bothChecker.accept("beets are great"));
        System.out.println(veggies.accept("artichokes, beets, and carrots"));
    }
}