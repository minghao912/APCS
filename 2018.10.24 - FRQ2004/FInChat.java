public class FInChat {
    public static void main(String[] args) {
        int[] hall = {1,1,2,2};

        Robot pleaseWork = new Robot(hall, 1, true);
        int moves = pleaseWork.clearHall();

        System.out.println("Hall cleared in " + moves + " moves.");
    }
}