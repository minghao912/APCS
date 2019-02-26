import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;

public class RockDropper extends Critter {
    private String name;

    public RockDropper(Color colour, String naame) {
        this.setColor(colour);
        name = naame;
    }
    
    public void makeMove(Location loc) {
        Location oldLocation = this.getLocation();  //Get old location to put rock in
        
        if (loc == null | loc == getLocation()) {
            System.out.println("> RockDropper " + name + " unable to move");
            return;
        }
        else {
            moveTo(loc);
 
            Rock rock = new Rock(getColor());
            rock.putSelfInGrid(getGrid(), oldLocation);

            System.out.println("> RockDropper " + name + " dropped a rock at " + oldLocation);
        }

        System.out.println("> RockDropper " + name + " now at " + getLocation());
    }       
}
