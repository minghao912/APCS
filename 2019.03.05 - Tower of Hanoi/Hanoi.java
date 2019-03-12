import java.util.Scanner;

public class Hanoi {
    public static int moveCounter;
    public static int theoretical;

    public static void main(String[] args) {
        Scanner kylesucksballs = new Scanner(System.in);
        System.out.print("> Please enter the number of disks: ");
        int n = kylesucksballs.nextInt();
        kylesucksballs.close();
        
        moveCounter = 0;
        theoretical = (int)Math.pow(2, n) - 1;
        
        long startTime = System.currentTimeMillis();
        hanoi(n, 1, 2, 3);
        long durationMS = System.currentTimeMillis() - startTime;  //duration in ms
        long durationS = durationMS / 1000L; //duration in s

        System.out.println("> Tower of Hanoi solved in " + moveCounter + " moves, theoretical minimum " + theoretical + " moves");
        System.out.println("> Tower of Hanoi solved in " + durationMS + "ms, " + durationS + "s");
    }
    
    public static void hanoi(int disks, int source, int spare, int target) {
        if (disks == 0) return;
        else {
            moveCounter++;
            
            int newDisk = disks - 1;
            hanoi(newDisk, source, target, spare);    //move m - 1 from source to spare
            System.out.println("> Moved Disk " + disks + " from Peg " + source + " to Peg " + target);  //move m from source to target
            hanoi(newDisk, spare, source, target);    //move the m - 1 from spare to target
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