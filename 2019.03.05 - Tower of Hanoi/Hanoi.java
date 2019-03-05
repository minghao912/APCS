import java.util.ArrayList;

public class Hanoi {
    public static int moveCounter;
    public static int theoretical;

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
        moveCounter = 0;
        theoretical = (int)Math.pow(2, n) - 1;
        
        hanoi(n, 1, 2, 3);
        System.out.println("> Tower of Hanoi solved in " + moveCounter + " moves, theoretical minimum " + theoretical + " moves");
    }
    
    public static void hanoi(int disks, int source, int spare, int target) {
        if (disks == 0) return;
        else {
            moveCounter++;
            
            hanoi(disks - 1, source, target, spare);    //move m - 1 from source to spare
            System.out.println("> Moved Disk " + disks + " from Peg " + source + " to Peg " + target);  //move m from source to target
            hanoi(disks - 1, spare, source, target);    //move the m - 1 from spare to target
        }
    }
    
}

/*
    Pegs A, B, C
    n disks, 1 top, n bottom
    m disks on source peg
    move m - 1 from source to spare peg
    move disk m from source to target peg
    move m - 1 disk from spare peg to target peg
    if 1 disk move from source to target directly
*/
