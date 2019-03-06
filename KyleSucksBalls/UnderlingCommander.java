import info.gridworld.actor.*;
import java.util.ArrayList;

/**
 * An <code>UnderlingCommander</code> controls all Underlings
 * of a given <code>RealAlphasUseVSCode</code>.
 * 
 * @param <T>   type of <code>Actor</code> to govern
 */
public class UnderlingCommander<T extends Actor> {
    private ArrayList<T> list;

    public UnderlingCommander() {
        list = new ArrayList<T>();
    }

    /**
     * Adds a given <code>Actor</code> to control.
     * 
     * @param actor
     */
    public void add(T actor) {
        list.add(actor);
    } 

    /**
     * Commands the <code>Actors</code> under the
     * <code>UnderlingCommander</code>'s control.
     */
    public void command() {
        if (RealAlphasUseVSCode.winState) return;   //Don't do anything if the game has already been won

        int oldInfected = SharedCode.infectedCounter;

        ArrayList<T> oldList = new ArrayList<T>(list);
        oldList.forEach(actor -> {
            actor.act();
        });
        oldList = null;

        int newInfected = SharedCode.infectedCounter;
        
        System.out.println("> " + newInfected + " objects have been infected this round, an increase of " + (newInfected - oldInfected));
        newInfected = oldInfected = Integer.MIN_VALUE;
    }
}
