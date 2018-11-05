import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.util.Arrays;

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

        JFrame playfield = new InitialiseGame().createPlayfield();
        createComputerGrid();
    }

    private JFrame createPlayfield() {
        JFrame anAbsoluteUnit = new JFrame("Batttleship");
        anAbsoluteUnit.setTitle("Battlehsip");
        anAbsoluteUnit.setIconImage((new ImageIcon(this.getClass().getResource("Files/icon.png"))).getImage());

        JSplitPane flippingheck = new JSplitPane();
        
        //Stats
        JPanel stickthisupyourbum = new JPanel();
        stickthisupyourbum.add(new JLabel("fuck yes"));
        stickthisupyourbum.add(new JLabel("this works"));

        //Battlehsip grid
        Grid2 pleasefuckingwork = new Grid2(10, 10);
        JPanel whywontyoujustwork = pleasefuckingwork.createGrid();

        //Configure the split pane
        flippingheck.setOrientation(JSplitPane.VERTICAL_SPLIT);
        flippingheck.setDividerLocation(50);
        flippingheck.setTopComponent(stickthisupyourbum);
        flippingheck.setBottomComponent(whywontyoujustwork);

        //Set main frame visible
        anAbsoluteUnit.setLayout(new BorderLayout());
        anAbsoluteUnit.setVisible(true);
        anAbsoluteUnit.add(flippingheck);
        anAbsoluteUnit.addWindowListener(this);
        anAbsoluteUnit.pack();
        anAbsoluteUnit.setLocationRelativeTo(null);
        

        /*
        pleasefuckingwork.setFrameTitle("Battlehsip");
        pleasefuckingwork.setIconImage((new ImageIcon(this.getClass().getResource("Files/icon.png"))).getImage());
        pleasefuckingwork.addWindowListener(this);

        pleasefuckingwork.pack();
        pleasefuckingwork.setLocationRelativeTo(null);
        pleasefuckingwork.setVisible(true);
        */

        return anAbsoluteUnit;
    }

    private static void createComputerGrid() {
        int[] gridSize = {10, 10};  //{y, x}
        Computer ai = new Computer(gridSize);

        Ship carrier = new Ship("Carrier", 5, ai.generateRandom());
        while(!ai.checkShipPlacement(carrier)) {
            carrier.setNewPosition(ai.generateRandom());
        }
        ai.placeShip(carrier);

        Ship battleship = new Ship("Battleship", 4, ai.generateRandom());
        while (!ai.checkShipPlacement(battleship)) {
            battleship.setNewPosition(ai.generateRandom());
        }
        ai.placeShip(battleship);

        Ship cruiser = new Ship("Cruiser", 3, ai.generateRandom());
        while (!ai.checkShipPlacement(cruiser)) {
            cruiser.setNewPosition(ai.generateRandom());
        }
        ai.placeShip(cruiser);

        Ship submarine = new Ship("Submarine", 3, ai.generateRandom());
        while (!ai.checkShipPlacement(submarine)) {
            submarine.setNewPosition(ai.generateRandom());
        }
        ai.placeShip(submarine);
        
        Ship destroyer = new Ship("Destroyer", 2, ai.generateRandom());
        while (!ai.checkShipPlacement(destroyer)) {
            destroyer.setNewPosition(ai.generateRandom());
        }
        ai.placeShip(destroyer);

        /*
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(ai.getGrid()[i]));
        }
        */
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