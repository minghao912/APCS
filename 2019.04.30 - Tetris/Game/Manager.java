package Game;

import java.util.ArrayList;

/**
 * A {@code Manager} manages type {@code <T>}
 * objects.
 */
public abstract class Manager<T> {
    protected ArrayList<T> members;

    public Manager() {
        members = new ArrayList<T>();
    }

    /**
     * Get the next {@code member} from
     * objects under the {@code Manager}'s 
     * management.
     * @return <T> the next {@code member}
     */
    protected abstract T getNextMember();

    /**
     * Add the passed member for the 
     * {@code Manager} to control.
     * @param <T> the type of object under control
     * @param newMember the new member
     */
    protected void add(T newMember) {
        members.add(newMember);
    }
}