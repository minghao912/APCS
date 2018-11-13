public class Ship {
    private String name;
    private int length;
    private int[] startingPositions;
    private int hits;
    private java.util.ArrayList<Integer[]> coordinates;

    public Ship(String boatName, int boatLength, int[] boatStartingPositions) {
        name = boatName;
        length = boatLength;
        startingPositions = boatStartingPositions;
        coordinates = new java.util.ArrayList<Integer[]>();
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
        boolean ableToRemove = coordinates.remove(coordinate);
        if (!ableToRemove) Error.displayError("Fatal Error", "Cannot remove coordinates of hit ship.");
    }
}

//31/10/2018 21:15