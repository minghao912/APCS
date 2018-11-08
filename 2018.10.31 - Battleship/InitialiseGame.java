import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.util.Arrays;

public class InitialiseGame implements WindowListener {
    public static void main(String[] args) {
        try {
            if (System.getProperty("os.name").contains("Windows")) UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            else UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
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
    
    private static int[] gridSize = { 10, 10 }; // {y, x}
    private static Computer ai = new Computer(gridSize);
    public static void accessToCheckGuess(int[] coordinates) {
        ai.checkGuess(coordinates);
    }

    private JFrame createPlayfield() {
        JFrame anAbsoluteUnit = new JFrame("Batttleship");
        anAbsoluteUnit.setTitle("Battlehsip");
        anAbsoluteUnit.setIconImage((new ImageIcon(this.getClass().getResource("Files/icon.png"))).getImage());

        JSplitPane flippingheck = new JSplitPane();
        
        //Stats
        JPanel stickthisupyourbum = new JPanel();
        stickthisupyourbum.add(new JLabel("god bless"));
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

        return anAbsoluteUnit;
    }

    private static void createComputerGrid() {
        Ship[] ships = new Ship[5];
        String[] shipNames = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
        int[] shipLengths = {5, 4, 3, 3, 2};

        for (int i = 0; i < 5; i++) {
            ships[i] = new Ship(shipNames[i], shipLengths[i], ai.generateRandom());
            while(!ai.checkShipPlacement(ships[i]))
                ships[i].setNewPosition(ai.generateRandom());
            ai.placeShip(ships[i]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(ai.getGrid()[i]));
        }
        
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