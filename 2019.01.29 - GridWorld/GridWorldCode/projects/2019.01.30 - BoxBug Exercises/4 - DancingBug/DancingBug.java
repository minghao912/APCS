import info.gridworld.actor.Bug;
import java.awt.Color;

public class DancingBug extends Bug {
    private int[] turns;
    private int currentIndex;

    public DancingBug(int[] turns) {
        this.turns = turns;
    }
    public DancingBug(int[] turns, Color bugColor) {
        super(bugColor);
        this.turns = turns;
    }

    public void act() {
        if (canMove()) move();
        else {
            System.out.println("Current i: " + currentIndex + " turns to make: " + turns[currentIndex % turns.length]);

            this.setDirection(45 * (turns[currentIndex % turns.length]));
            currentIndex++;
        }
    }
}