import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;

public class RockDropper extends Critter {
    public RockDropper(Color colour) {
        this.setColor(colour);
    }
    
    public void makeMove(Location loc) {
        Location oldLocation = this.getLocation();  //Get old location to put rock in
        
        if (loc == null) return;
        else moveTo(loc);
 
        Rock rock = new Rock(getColor());
        rock.putSelfInGrid(getGrid(), oldLocation);
        
        
    }       
}
