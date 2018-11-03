public class Ship {
    private String name;
    private int length;
    private int[][] coordinates;
    private int[] startingPositions;
    private int[] gridSize;

    public Ship(String boatName, int boatLength, int[] boatStartingPositions) {
        name = boatName;
        length = boatLength;
        startingPositions = boatStartingPositions;
    }
}

//31/10/2018 21:15