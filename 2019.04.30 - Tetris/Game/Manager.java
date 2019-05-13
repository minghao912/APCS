package Game;

import java.util.ArrayList;

public abstract class Manager<T> {
    protected ArrayList<T> members;

    public Manager() {
        members = new ArrayList<T>();
    }

    protected abstract T getNextMember();

    protected void add(T newMember) {
        members.add(newMember);
    }
}