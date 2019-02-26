import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(35, 75));
        
        RockDropper one = new RockDropper(new Color(getRandomNum(255), getRandomNum(255), getRandomNum(255)), "1");
        RockDropper two = new RockDropper(new Color(getRandomNum(255), getRandomNum(255), getRandomNum(255)), "2");
        RockDropper three = new RockDropper(new Color(getRandomNum(255), getRandomNum(255), getRandomNum(255)), "3");
        RockDropper four = new RockDropper(new Color(getRandomNum(255), getRandomNum(255), getRandomNum(255)), "4");
        RockEater five = new RockEater();
        
        world.add(one);
        world.add(two);
        world.add(three);
        world.add(four);
        world.add(five);
        world.show();
    }

    public static int getRandomNum(int max) {
        return (int)(Math.random() * (max - 1) + 1);
    }
}
