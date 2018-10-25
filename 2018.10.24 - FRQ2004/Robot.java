public class Robot {
    private int[] hall;
    private int pos;
    private boolean right;

    public Robot(int[] theHall, int position, boolean facingRight) {
        hall = theHall;
        pos = position;
        right = facingRight;
    }

    private boolean forwardMoveBlocked() {
        if (right) {
            if (pos == hall.length - 1) return true;
        }
        else if (!right) {
            if (pos == 0) return true;
        }
        return false;
    }

    private void move() {
        if (hall[pos] > 0)  //Remove an item if there are items to remove
            hall[pos] -= 1;

        if (hall[pos] == 0) {   //If no more, than try to move forward
            if (right) {
                if (forwardMoveBlocked()) 
                    right = false;
                else 
                    pos++;
            }
            else if (!right) {
                if (forwardMoveBlocked())
                    right = true;
                else
                    pos--;
            }
        }
    }

    public int clearHall() {
        int moves = 0;
        boolean[] clear = new boolean[hall.length]; //Is the hall clear?

        clear:
        for (int i = 0; i < hall.length; i++) {
            //Check if the hall is clear
            boolean allClear = true;    
            for (boolean bool : clear) 
                if (!bool) 
                    allClear = false;
            
            if (allClear)   //If hall is clear, stop
                break clear;
            else if (hall[i] == 0) {    //If hall is not clear, continue
                clear[i] = true;
                continue clear;
            }
            while (hall[i] > 0 && !clear[i]) {
                move();
                moves++;
            }
        }

        return moves;
    }
}