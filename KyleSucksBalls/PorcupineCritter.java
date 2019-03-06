import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
public class PorcupineCritter extends Critter
{
    public PorcupineCritter()
    {
        setColor(null);
    }

    public void act()
    {
        PorcupineGrenade teehee = new PorcupineGrenade();
        teehee.setColor(null);
        Location hmm = getGrenadeLocation();
        if (hmm !=null)
        {
            teehee.putSelfInGrid(getGrid(), getGrenadeLocation());
        }
        super.act();
        if (hmm !=null)
        {
            teehee = null;
        }
    }
     public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof PorcupineGrenade) && !(a instanceof PorcupineCritter))
                a.removeSelfFromGrid();
        }
    }

    public Location getGrenadeLocation()
    {
        int row = getLocation().getRow();
        int column = getLocation().getCol();
        if (getDirection() == 0)
        {
            column = column - 2;
        }
        else if (getDirection() == 90)
        {
            row = row + 2;
        }
        else if (getDirection() == 180)
        {
            column = column + 2;
        }
        else if (getDirection() == 270)
        {
            row = row + -2;
        }
        else
        {
            setDirection(getDirection() + 45);
        }
        Location ok = new Location(row,column);
        if (ok.getRow() < 1 || ok.getCol() < 1 || ok.getRow() > getGrid().getNumRows()-1 || ok.getCol() > getGrid().getNumCols()-1)
        {
            setDirection(getDirection() + 90);
            return null;
        }
        return ok;
    }

    public void removeSelfFromGrid()
    {
        return;
    }

}