import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;

public class Runner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        Actor master = new RealAlphasUseVSCode();

        Actor bug = new Bug();
        Actor critter = new Critter();

        world.add(new Location(7, 8), master);
        world.add(new Location(7, 7), bug);
        world.add(new Location(5, 8), critter);

        world.show();
    }
}