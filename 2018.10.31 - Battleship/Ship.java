import java.util.Arrays;
import java.util.ArrayList;

public class Ship {
    private String name;
    private int length;
    private int[] startingPositions;
    private int hits;
    private ArrayList<Integer[]> coordinates;

    public Ship(String boatName, int boatLength, int[] boatStartingPositions) {
        name = boatName;
        length = boatLength;
        startingPositions = boatStartingPositions;
        coordinates = new ArrayList<Integer[]>();
    }

    public void setNewPosition(int[] boatStartingPositions) {
        startingPositions = boatStartingPositions;
    }

    public int[] getPositions() {
        return startingPositions;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    public void addCoordinate(Integer[] coordinate) {
        coordinates.add(coordinate);
    }

    public java.util.ArrayList<Integer[]> getCoordinate() {
        return coordinates;
    }

    public void removeCoordinate(Integer[] coordinate) {
        try {
            for (int i = 0; i < coordinates.size(); i++) if (Arrays.equals(coordinates.get(i), coordinate)) coordinates.remove(i);
        } catch (Throwable e) {
            Error.displayError("Fatal Error", "Error generating error message.\n(An unknown error has occured)");
        }
    }
}

//13/11/2018 18:05