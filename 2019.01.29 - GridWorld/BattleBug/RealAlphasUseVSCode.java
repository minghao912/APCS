import info.gridworld.actor.Actor;

public class RealAlphasUseVSCode extends Actor{
    @Override
    public void removeSelfFromGrid() {
        if (getGrid() == null) throw new IllegalStateException("This actor is not in a grid.");
        if (getGrid().get(getLocation()) != this) throw new IllegalStateException("The grid contains a different actor at location " + getLocation() + ".");

        return;
    }
}