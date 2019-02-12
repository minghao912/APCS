import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld(new UnboundedGrid<Actor>());

        Actor alpha = new RealAlphasUseVSCode();

        /*
        Actor bug = new Bug();
        Actor critter = new Critter();

        world.add(new Location(7, 8), alpha);
        world.add(new Location(7, 7), bug);
        world.add(new Location(5, 8), critter);
        */

        ArrayList<Actor> enemies = new ArrayList<Actor>();
        for (int i = 0; i < 5; i++) {
            enemies.add(new Actor());
            enemies.add(new Bug());
            enemies.add(new Critter());
        }

        enemies.forEach(e -> {
            //world.add(new Location(getRandomNum(), getRandomNum()), e);
            world.add(e);
        });

        //world.add(new Location(7, 8), alpha);
        world.add(alpha);
        world.show();
    }

    public static int getRandomNum() {
        return (int)(Math.random() * 9 + 1);
    }
}
