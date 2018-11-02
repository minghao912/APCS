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