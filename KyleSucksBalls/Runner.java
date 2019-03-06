import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        Actor alpha = new RealAlphasUseVSCode();
        Actor kyle = new PorcupineCritter();

        /*
        Actor bug = new Bug();
        Actor critter = new Critter();

        world.add(new Location(7, 8), alpha);
        world.add(new Location(7, 7), bug);
        world.add(new Location(5, 8), critter);
        */

        /*
        ArrayList<Actor> enemies = new ArrayList<Actor>();
        for (int i = 0; i < 10; i++) {
            Actor actor = new Actor();
            Bug bug = new Bug();
            Critter critter = new Critter();
            actor.setColor(new Color(getRandomNum(255), getRandomNum(255), getRandomNum(255)));
            bug.setColor(new Color(getRandomNum(255), getRandomNum(255), getRandomNum(255)));
            critter.setColor(new Color(getRandomNum(255), getRandomNum(255), getRandomNum(255)));

            enemies.add(actor);
            enemies.add(bug);
            enemies.add(critter);
        }

        enemies.forEach(e -> {
            //world.add(new Location(getRandomNum(), getRandomNum()), e);
            world.add(e);
        });
        */

        //world.add(new Location(7, 8), alpha);
        world.add(alpha);
        world.add(kyle);
        world.show();
    }

    public static int getRandomNum(int max) {
        return (int)(Math.random() * (max - 1) + 1);
    }
}
