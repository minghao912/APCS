import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class DBRunner {
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1};
        DancingBug asdf = new DancingBug(array, Color.MAGENTA);

        ActorWorld aw = new ActorWorld();
        aw.add(new Location(2, 2), asdf);
        aw.show();
    }
}