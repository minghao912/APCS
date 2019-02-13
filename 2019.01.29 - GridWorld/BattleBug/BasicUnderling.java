import info.gridworld.grid.*;
import info.gridworld.actor.*;

import java.util.ArrayList;
import java.awt.Color;

/**
 * An <code>Underling</code> is spawned when a <code>RealAlphasUseVSCode</code>
 * object encounters another actor. The <code>RealAlphasUseVSCode</code> uses
 * infects the enemy, turning it into an <code>Underling</code>. The
 * <code>Underling</code> only serves as a zombie-like infection mechanism, and 
 * in all other purposes acts like a <code>Critter</code>.
 */
public class BasicUnderling extends Critter, implements Underling {
    private UnderlingCommander commander;
    private Grid grid;

    /**
     * Constructs an Underling. Requires a <code>Grid</code>,
     * <code>Location</code>, and an <code>UnderlingCommander</code>.
     * 
     * @param passedGrid
     * @param location
     * @param passedCommander
     */
    public Underling(Grid passedGrid, Location location, UnderlingCommander passedCommander) {
        putSelfInGrid(passedGrid, location);
        setColor(new Color(255, 175, 50));
        grid = passedGrid;
        commander = passedCommander;
    }

    /**
     * An <code>Underling</code> processes its list of <code>Actors</code> by
     * checking if each <code>Actor</code> meets the criteria to be infected.
     * To be infected, the enemy <code>Actor</code> must not be of type
     * <code>RealAlphasUseVSCode</code> or <code>Underling</code>.
     */
    public void processActors(ArrayList<Actor> actors) {
        SharedCode.processActors(actors, commander, grid);
    }

    /**
     * Offer a status message to console upon death of an <code>Underling</code>.
     */
    public void removeSelfFromGrid() {
        super.removeSelfFromGrid();
        System.out.println("> Underling killed at location " + getLocation());
    }
}