public class RoboTester {
    public static void main(String[] args) {
        System.out.println("'Joomba'");
        System.out.println("---------------------------------------------");

        Robot joomba = new Robot(new int[] {17, 63, 5, 21}, 1, true);
        int steps = joomba.clearHall();
        System.out.println("'Joomba' cleared the hall in " + steps + " moves.");

        System.out.println("RoombaMaster9000");
        System.out.println("---------------------------------------------");
        
        RoombaMaster9000 superiorRoomba = new RoombaMaster9000(new int[] {17, 63, 5, 21}, 1, true);
        int steeps = superiorRoomba.clearHall();
        System.out.println("Roomba\u00AE RoombaMaster9000\u2122, the superior Roomba\u00AE, cleared the hall in only " + steeps + " moves.");
    }
}
