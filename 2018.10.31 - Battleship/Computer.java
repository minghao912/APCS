import java.util.Random;

public class Computer {
    private static Random rand = new Random();

    public AI() {}

    public static boolean[][] placeShips(boolean[][] computerGrid) {
        int startX = rand.nextInt(10);  //This will give a random value betwen 0-9
        int startY = rand.nextInt(10);
        int radDir = rand.nextInt(2); //Generate 0 or 1
        
        boolean startDirVertical;
        if (radDir == 0) startDirVertical = true;
        else if (radDir == 1) startDirVertical = false;

        return computerGrid;
    }
}