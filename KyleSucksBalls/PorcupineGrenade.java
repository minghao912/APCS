import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
public class PorcupineGrenade extends Actor
{
    public void makeMove(Location loc)
    {
        return;
    }

    public void processActors(ArrayList<Actor> actors)
    {
        boolean check = false;
        if (actors.size() == 0)
        {
            return;
        }
        for (Actor a : actors)
        {

            if (!(a instanceof PorcupineGrenade) && !(a instanceof PorcupineCritter))
            {
                if (a.getLocation() != null)
                    a.removeSelfFromGrid();

                check = true;
                if (this.getLocation() != null)
                    this.removeSelfFromGrid();

                for (Actor b : actors)
                {
                    if (b.getLocation() != null)
                        b.removeSelfFromGrid();

                }
            }
        }
        if (check = true)
        {
            return;
        }
    }

    public void act()
    {
        ArrayList<Actor> actors = getActors();
        processActors(actors);
    }

    public ArrayList<Actor> getActors()
    {
        return getGrid().getNeighbors(getLocation());
    }

}
