import javax.swing.JFrame;

public class test {
    public static void main(String[] args) {
        Grid testGrid = new Grid(10, 10);
        testGrid.createGrid();
        testGrid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testGrid.pack();
        testGrid.setVisible(true);
    }
}