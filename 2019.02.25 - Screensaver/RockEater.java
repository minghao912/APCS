import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class RockEater extends Critter {
    //Status message
    public void act() {
        super.act();
        System.out.println("> RockEater now at  " + getLocation());
    }

    public ArrayList<Location> getMoveLocations() {
        ArrayList<Location> occupiedLocations = new ArrayList<Location>();

        /*Get rid of all neighbour rocks before teleporting to a random location
        if (getRockNeighbours(getLocation()).size() > 0) {
            occupiedLocations = getRockNeighbours(getLocation());
        } else {
            occupiedLocations = getGrid().getOccupiedLocations();
            occupiedLocations.removeIf(a -> !(getGrid().get(a) instanceof Rock));  //Remove all non-rocks
        }
        */

        //This does it randomly
        occupiedLocations = getGrid().getOccupiedLocations();
        occupiedLocations.removeIf(a -> !(getGrid().get(a) instanceof Rock)); // Remove all non-rocks
        
        return occupiedLocations;
    }

    public ArrayList<Location> getRockNeighbours(Location loc) {
        ArrayList<Location> list = getGrid().getOccupiedAdjacentLocations(loc);
        list.removeIf(a -> !(getGrid().get(a) instanceof Rock));   //Remove all non-rocks
        return list;
    }
}
