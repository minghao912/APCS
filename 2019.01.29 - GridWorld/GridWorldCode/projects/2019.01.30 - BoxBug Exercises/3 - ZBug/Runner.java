import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;

public class Runner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        Bug yeetBug = new ZBug(3);
        Bug epicBug = new ZBug(6);
        epicBug.setColor(Color.ORANGE);
        
        world.add(new Location(7, 8), yeetBug);
        world.add(new Location(5, 5), epicBug);
        world.show();
    }
}