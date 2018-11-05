import java.util.Random;
import java.util.Arrays;

public class Computer {
    private Random rand = new Random();
    private String[][] gridOfShips;
    private int[] gridSize;

    public Computer(int[] givenGridSize) {
        gridSize = givenGridSize;
        gridOfShips = new String[givenGridSize[0]][givenGridSize[1]];
    }

    boolean checkShipPlacement(Ship ship) {
        int shipLength = ship.getLength();
        int[] startingPositions = ship.getPositions();
        int startX = startingPositions[0];
        int startY = startingPositions[1];
        int direct = startingPositions[2];

        //If the direction is horizontal
        if (direct == 0) {
            if (startX + shipLength > gridSize[1]) //If ship goes out of bounds
                return false;

            for (int x = startX; x < startX + shipLength; x++) {
                if (gridOfShips[startY][x] != null) return false; 
            }
            return true;
        } else if (direct == 1) {  // else if direction is vertial
            if (startY + shipLength > gridSize[0])
                return false;

            for (int y = startY; y < startY + shipLength; y++) {
                if (gridOfShips[y][startX] != null)
                    return false;
            }
            return true;
        } else {
            System.out.println("Fatal error");
            System.exit(128);
        }

        return false;
    }

    String[][] placeShip(Ship ship) {
        String shipName = ship.getName();
        int shipLength = ship.getLength();
        int[] startingPositions = ship.getPositions();
        int startX = startingPositions[0];
        int startY = startingPositions[1];
        int direct = startingPositions[2];

        // If the direction is horizontal
        if (direct == 0) {
            for (int x = startX; x < startX + shipLength; x++) {
                gridOfShips[startY][x] = shipName;
            }
            return gridOfShips;
        } else if (direct == 1) { // else if direction is vertial
            for (int y = startY; y < startY + shipLength; y++) {
                gridOfShips[y][startX] = shipName;
            }
            return gridOfShips;
        } else {
            System.out.println("Error reading direction.");
        }

        return gridOfShips;
    }

    String[][] getGrid() {
        return gridOfShips;
    }

    int[] generateRandom() {
        int startX = rand.nextInt(10); // This will give a random value betwen 0-9
        int startY = rand.nextInt(10);
        int radDir = rand.nextInt(2); // Generate 0 or 1

        return new int[] {startX, startY, radDir};
    }
}

// 31/10/2018 21:15