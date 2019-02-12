import java.util.ArrayList;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

/**
 * This class serves only to act as an intermediary between
 * <code>RealAlphasUseVSCode</code> and <code>Underling</code>.
 * Both share the same <code>processActors()</code> method.
 */
public class SharedCode {
    /**
     * Processes the <code>Actors</code> on command. Requires a list
     * of <code>Actors</code>, an <code>UnderlingCommander</code>, and
     * a <code>Grid</code>.
     * 
     * @param actors List of <code>Actors</code> to check.
     * @param commander <code>UnderlingCommander</code> to control created <code>Underlings</code>
     * @param grid  <code>Grid</code> in which the created <code>Underlings</code> will be placed
     */
    public static void processActors(ArrayList<Actor> actors, UnderlingCommander commander, Grid grid) {
        for (Actor actor : actors) {
            if (actor instanceof RealAlphasUseVSCode || actor instanceof Underling) return;

            //Store actor's location
            Location actorLocation = actor.getLocation();

            // Try the regular remove actor from grid
            try {
                actor.removeSelfFromGrid();
            } catch (Throwable e) {
                System.out.println("> Error calling `removeSelfFromGrid()` on actor");
            }

            // Try to get actor to suicide by moving it to a corner and calling move()
            try {
                if (!(actor.getGrid() instanceof BoundedGrid))
                    throw new IllegalStateException();
                if (!(actor instanceof Bug))
                    throw new IllegalStateException();

                System.out.println("> Detected Actor of type `Bug`, conducting exploit...");
                Bug bug = (Bug) actor;

                int gridRows = bug.getGrid().getNumRows();
                int gridCols = bug.getGrid().getNumCols();

                bug.moveTo(new Location(gridRows - 1, gridCols - 1));
                bug.setDirection(Location.SOUTHEAST);
                bug.move();
            } catch (IllegalStateException e) {}

            Underling underling = new Underling(grid, actorLocation, commander);
            commander.add(underling);
            System.out.println("> Adding Underling to location " + actorLocation);
        }
    }
}