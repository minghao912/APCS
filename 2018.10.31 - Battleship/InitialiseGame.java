import java.awt.event.*;
import javax.swing.*;

public class InitialiseGame implements WindowListener {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }

        Grid playfield = new InitialiseGame().createPlayfield();
    }

    private Grid createPlayfield() {
        Grid pleasefuckingwork = new Grid(10, 10);
        pleasefuckingwork.createGrid();
        pleasefuckingwork.setFrameTitle("Battlehsip");
        pleasefuckingwork.addWindowListener(this);
        pleasefuckingwork.pack();
        pleasefuckingwork.setLocationRelativeTo(null);
        pleasefuckingwork.setVisible(true);

        return pleasefuckingwork;
    }

    private void createComputerGrid() {
        Ship carrier = new Ship("Carrier", 5, Computer.generateRandom());
        Ship battleship = new Ship("Battleship", 4, Computer.generateRandom());
        Ship cruiser = new Ship("Cruiser", 3, Computer.generateRandom());
        Ship submarine = new Ship("Submarine", 3, Computer.generateRandom());
        Ship destroyer = new Ship("Destroyer", 2, Computer.generateRandom());
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

//03/11/2018 16:15