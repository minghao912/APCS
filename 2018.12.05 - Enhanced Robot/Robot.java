public class Robot {
    private int[] hall;
    private int pos;             // current position(tile number) of Robot
    private boolean facingRight; // true means this Robot is facing right
  
    public Robot(int[] givenHall, int position, boolean irght) {
        hall = givenHall;
        pos = position;
        facingRight = irght;
    }

    public int[] getHall() {
        return hall;
    }

    public void setNewHallElem(int newHallElem, int index) {
        hall[index] = newHallElem;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int position) {
        pos = position;
    }

    public boolean getDir() {
        return facingRight;
    }

    public void setDir(boolean right) {
        facingRight = right;
    }
  
    public boolean forwardMoveBlocked() {
        boolean blocked = false;
        if ((getPos() == 0 && !getDir()) || (getPos() == getHall().length - 1 && getDir())) 
            blocked = true;
        return blocked;
    }
    
    public void move() {
        System.out.println("Pos: " + getPos() + " Things: " + getHall()[getPos()] + " Current Hall: " + java.util.Arrays.toString(getHall()));

        if (getHall()[getPos()] > 0) setNewHallElem(getHall()[getPos()] - 1, getPos());
        if (getHall()[getPos()] > 0) return;
        else {
            if (!forwardMoveBlocked()) {
                if (getDir()) setPos(getPos() + 1);
                else setPos(getPos() - 1);
            }
            else {
                setDir(!getDir());  // switch directions
            }
        }
    }

    // postcondition: returns true if the hallway contains no items;
    //                otherwise, returns false
    public boolean hallIsClear() {
        for (int i : getHall()) 
            if (i > 0) return false;   
        return true;
    }

        
    // postcondition: no more items remain in the hallway;
    //                returns the number of moves made
    public int clearHall() {
        int numMoves = 0;
        while (!hallIsClear()) {
            numMoves++;
            move();
        }
        return numMoves;
    }
    
}
