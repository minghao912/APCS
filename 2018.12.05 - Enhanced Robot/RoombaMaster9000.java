public class RoombaMaster9000 extends Robot {
    public RoombaMaster9000(int[] givenHall, int position, boolean irght) {
        super(givenHall, position, irght);
    }

    public void move() {
        System.out.println("Pos: " + getPos() + " Things: " + getHall()[getPos()] + " Current Hall: " + java.util.Arrays.toString(getHall()));

        if (getHall()[getPos()] > 0) {
            if (getHall()[getPos()] >= 3) setNewHallElem(getHall()[getPos()] - 3, getPos());
            else setNewHallElem(0, getPos());
        }
        if (getHall()[getPos()] > 0)
            return;
        else {
            if (!forwardMoveBlocked()) {
                if (getDir())
                    setPos(getPos() + 1);
                else
                    setPos(getPos() - 1);
            } else {
                setDir(!getDir()); // switch directions
            }
        }
    }
}