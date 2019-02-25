import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;

public class RockEater extends Critter {
    public ArrayList<Location> getMoveLocations() {
        ArrayList<Location> occupiedLocations = getGrid().getOccupiedLocations();
        occupiedLocations.removeIf(a -> !(getGrid().get(a) instanceof Rock));  //Remove all non-rocks
        
        return occupiedLocations;
    }
}
