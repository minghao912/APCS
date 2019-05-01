public class SubstringChecker implements Checker {
    private String sub;

    public SubstringChecker(String string) {
        sub = string;
    }

    public boolean accept(String text) {
        return text.contains(sub);
    }
}