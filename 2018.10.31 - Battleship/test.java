import javax.swing.JFrame;

public class test {
    public static void main(String[] args) {
        Grid playfield = createPlayfield();
    }

    static Grid createPlayfield() {
        Grid testGrid = new Grid(10, 10);
        testGrid.createGrid();
        testGrid.setFrameTitle("Battlehsip");
        testGrid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testGrid.pack();
        testGrid.setLocationRelativeTo(null);
        testGrid.setVisible(true);

        return testGrid;
    }
}