import java.awt.event.*;
import javax.swing.*;

public class InitialiseGame implements WindowListener {
    public static void main(String[] args) {
        Grid playfield = new InitialiseGame().createPlayfield();
    }

    private Grid createPlayfield() {
        Grid testGrid = new Grid(10, 10);
        testGrid.createGrid();
        testGrid.setFrameTitle("Battlehsip");
        testGrid.addWindowListener(this);
        testGrid.pack();
        testGrid.setLocationRelativeTo(null);
        testGrid.setVisible(true);

        return testGrid;
    }

    private void createComputerGrid() {
        Ship carrier = new Ship("Carrier", 5, Computer.generateRandom());
        Ship battleship = new Ship("Battleship", 4, Computer.generateRandom());
        Ship cruiser = new Ship("Cruiser", "3", Computer.generateRandom());
        Ship submarine = new Ship("Submarine", "3", Computer.generateRandom());
        Ship destroyer = new Ship("Destroyer", "2", Computer.generateRandom());
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}