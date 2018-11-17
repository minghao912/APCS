import java.util.Arrays;
import java.util.ArrayList;

/**
 * Represents a Ship.
 */
public class Ship {
    private String name;
    private int length;
    private int[] startingPositions;
    private int hits;
    private ArrayList<Integer[]> coordinates;

    /**
     * <h3>Creates a Ship Object</h3>
     * Given a name, length, and location, this will create
     * a {@code Ship} object with that information.
     * 
     * @param boatName  - a {@code String}
     * @param boatLength - an {@code int}
     * @param boatStartingPositions - an {@code int[]}
     */
    public Ship(String boatName, int boatLength, int[] boatStartingPositions) {
        name = boatName;
        length = boatLength;
        startingPositions = boatStartingPositions;
        coordinates = new ArrayList<Integer[]>();
    }

    /**
     * Given a set of starting positions, this will overwrite 
     * the current set with the new set.
     * 
     * @param boatStartingPositions - an {@code int[]}
     */
    public void setNewPosition(int[] boatStartingPositions) {
        startingPositions = boatStartingPositions;
    }

    /**
     * Retreives the set of starting positions.
     * 
     * @return {@code int[]} of starting positions
     */
    public int[] getPositions() {
        return startingPositions;
    }

    /**
     * Retreives the length of the specified {@code Ship}.
     * 
     * @return {@code int} length
     */
    public int getLength() {
        return length;
    }

    /**
     * Retreives the name of the specified {@code Ship}.
     * 
     * @return {@code String} name
     */
    public String getName() {
        return name;
    }

    /**
     * Retreives the number of hits on the specified {@code Ship}.
     * 
     * @return {@code int} - the number of hits
     */
    public int getHits() {
        return hits;
    }

    /**
     * Adds a coordinate position to the {@code Ship}'s data.
     * 
     * @param coordinate - an {@code Integer[]}
     */
    public void addCoordinate(Integer[] coordinate) {
        coordinates.add(coordinate);
    }

    /**
     * Retreives the list of coordinate positions of a
     * specified {@code Ship}.
     * 
     * @return {@code ArrayList<Integer[]>} of coordinates
     */
    public java.util.ArrayList<Integer[]> getCoordinate() {
        return coordinates;
    }

    /**
     * Removes a specified coordinate from the specified 
     * {@code Ship}'s data.
     * 
     * @param coordinate - an {@code Integer[]}
     * @throws Throwable when any error occurs
     */
    public void removeCoordinate(Integer[] coordinate) {
        try {
            for (int i = 0; i < coordinates.size(); i++) if (Arrays.equals(coordinates.get(i), coordinate)) coordinates.remove(i);
        } catch (Throwable e) {
            Error.displayError("Fatal Error", "Error generating error message.\n(An unknown error has occured)");
        }
    }
}

// 16/11/2018 21:06