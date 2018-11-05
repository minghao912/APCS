public class Ship {
    private String name;
    private int length;
    private int[] startingPositions;
    private int hits;

    public Ship(String boatName, int boatLength, int[] boatStartingPositions) {
        name = boatName;
        length = boatLength;
        startingPositions = boatStartingPositions;
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
}

//31/10/2018 21:15