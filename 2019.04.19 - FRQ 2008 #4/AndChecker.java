import java.util.ArrayList;

public class AndChecker <T extends Checker> implements Checker {
    private ArrayList<T> checkers;

    public AndChecker(T checker0, T checker1) {
        checkers = new ArrayList<T>();
        checkers.add(checker0);
        checkers.add(checker1);
    }

    public boolean accept(String text) {
        for (T checker : checkers) {
            if (!checker.accept(text)) return false;
        }
        return true;
    }
}