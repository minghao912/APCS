import info.gridworld.actor.Bug;

public class ZBug extends Bug {
    private int steps;
    private int width;
    private int direction; //0 for first horizontal, 1 for diagonal, 2 for second horizontal

    public ZBug(int zWidth) {
        this.setDirection(90);  //Set bug facing east
        steps = 0;
        direction = 0;
        width = zWidth;
    }

    public void act() {
        if (direction % 2 == 0) moveHorizontal();   //If direction is 0 or 2
        else if (direction == 1) moveDiagonal();
        else return;
    }

    public void moveHorizontal() {
        if (steps < width && canMove()) {
            this.setDirection(90);  //set bug direction east
            move();
            steps++;
        }

        if (steps == width) direction++;
    }

    public void moveDiagonal() {
        if (steps <= width && canMove()) {
            this.setDirection(225);
            move();
            steps--;
        }
        
        if (steps == 0) direction++;
    }
}