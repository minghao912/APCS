import java.util.Random;
import java.util.Arrays;

/**
 * Represents a Computer.
 * <p>
 * Does a lot of the intermediary work.
 */
public class Computer {
    private Random rand = new Random();
    private String[][] gridOfShips;
    private int[] gridSize;
    public static int moveCounter = 0;
    public static int sunkCounter = 0;

    /**
     * <h3>Creates a Computer Object</h3>
     * Creates a {@code Computer} object when given a specified {@code int[] gridSize}
     * in the format {y[rows], x[columns]}.
     * 
     * @param   givenGridSize   - an {@code int[]} of values {y, x}
     */
    public Computer(int[] givenGridSize) {
        gridSize = givenGridSize;
        gridOfShips = new String[givenGridSize[0]][givenGridSize[1]];
    }

    /**
     * <h3>Checks Ship Collision</h3>
     * Given a {@code Ship}, it will retreive its length, location,
     * and direction. Then, it will determine whether or not the ship
     * will collide with other ships in that orientation.
     * 
     * @param   ship    - the {@code Ship} to check collision
     * @return  {@code boolean} {@code true} if the ship will not collide
     *                          and {@code false} if the ship will collide
     */
    public boolean checkShipPlacement(Ship ship) {
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
            System.out.println("> Error placing ships.");
            Error.displayError("Fatal Error", "Unable to place ships.");
            System.exit(128);
        }

        return false;
    }

    /**
     * <h3>Places Ship on Grid</h3>
     * Given a {@code Ship}, it will retreive its length, location, and 
     * direction. Using this information, it will place the {@code Ship}
     * on the {@code Computer}'s grid.
     * 
     * @param ship - the {@code Ship} to be placed
     * @return  {@code String[][]} of the {@code Computer}'s grid after
     *          placing the {@code Ship}
     */
    public String[][] placeShip(Ship ship) {
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
                ship.addCoordinate(new Integer[] { startY, x });
            }
            return gridOfShips;
        } else if (direct == 1) { // else if direction is vertial
            for (int y = startY; y < startY + shipLength; y++) {
                gridOfShips[y][startX] = shipName;
                ship.addCoordinate(new Integer[] { y, startX });
            }
            return gridOfShips;
        } else {
            System.out.println("> Error reading direction.");
            Error.displayError("Error", "Unable to read direction.");
        }

        return gridOfShips;
    }

    /**
     * <h3>Check's the User's Guess</h3>
     * Given the coordinates of the user's guess, it will run through the
     * {@code Computer}'s grid and determine if the guess was a hit or 
     * miss.
     * 
     * @param coordinate - an {@code int[]} {y, x} of the user's guess
     * @return {@code boolean} - {@code true} if hit and {@code false} if miss
     */
    public boolean checkGuess(int[] coordinate) {
        if(gridOfShips[coordinate[0]][coordinate[1]] != null) return true;
        else return false;
    }

    /**
     * <h3>Removes a Ship from Grid</h3>
     * Given the coordinates of the user's guess, it will remove the {@code Ship}
     * at that location.
     * 
     * @param coordinates - an {@code int[]} {y, x}
     * @return {@code String} of the removed {@code Ship}'s name
     */
    public String removeShip(int[] coordinates) {
        String shipname = null;
        if (gridOfShips[coordinates[0]][coordinates[1]] != null) {
            shipname = gridOfShips[coordinates[0]][coordinates[1]];
            gridOfShips[coordinates[0]][coordinates[1]] = null;
        } else return null;

        if (InitGame.cheats == 0) {
            System.out.println();
            for (int i = 0; i < 10; i++) 
                System.out.println(Arrays.toString(gridOfShips[i]));
            System.out.println();
        }

        return shipname;
    }

    /**
     * <h3>Checks if a Ship Has Been Sunk</h3>
     * Given a ship, this will retreive its coordinate locations and 
     * will determine if it has been sunk.
     * 
     * @param ship  - a {@code Ship} to be checked
     * @return {@code boolean} - {@code true} if sunk and {@code false} if not
     */
    public boolean checkSunk(Ship ship) {
        if (ship.getCoordinate().isEmpty()) return true;
        else return false;
    }

    /**
     * Gets the grid of ships.
     * 
     * @return {@code String[][]} - the grid of ships
     */
    String[][] getGrid() {
        return gridOfShips;
    }

    /**
     * <h3>Generates a Random Set of Integers</h3>
     * This will generate a random set of integers used to give
     * each {@code Ship} a location, length, and orientation.
     * 
     * @return {@code int[]} - a set of random values
     */
    public int[] generateRandom() {
        int startX = rand.nextInt(10); // This will give a random value betwen 0-9
        int startY = rand.nextInt(10);
        int radDir = rand.nextInt(2); // Generate 0 or 1

        return new int[] {startX, startY, radDir};
    }
}

// 17/11/2018 21:26