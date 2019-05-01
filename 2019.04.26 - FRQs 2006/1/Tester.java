public class Tester {
    public static void main(String[] args) {
        RandomStringChooser sChooser = new RandomStringChooser(new String[] {"wheels", "on", "the", "bus"});

        for (int k = 0; k < 6; k++) System.out.print(sChooser.getNext() + " ");
        System.out.println();
    }
}