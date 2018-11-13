import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.util.Arrays;

public class InitGame implements WindowListener {
    public static void main(String[] args) {
        //Set the look and feel to look like something not from the 90s
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

        //Create new playfield and tell the computer to make the ship grid
        JFrame playfield = new InitGame().createPlayfield();
        createComputerGrid();
    }

    //Battleship grid
    private static Grid2 pleasefuckingwork = new Grid2(10, 10);
    
    private JFrame createPlayfield() {
        JFrame anAbsoluteUnit = new JFrame("Batttleship");
        anAbsoluteUnit.setTitle("Battlehsip");
        anAbsoluteUnit.setIconImage((new ImageIcon(this.getClass().getResource("Files/icon.kylebigdumb"))).getImage());

        JSplitPane flippingheck = new JSplitPane();

        // Stats
        JPanel stickthisupyourbum = new JPanel();
        stickthisupyourbum.add(new JLabel("god bless"));
        stickthisupyourbum.add(new JLabel("this works"));

        // Battlehsip grid
        JPanel whywontyoujustwork = pleasefuckingwork.createGrid();

        // Configure the split pane
        flippingheck.setOrientation(JSplitPane.VERTICAL_SPLIT);
        flippingheck.setDividerLocation(50);
        flippingheck.setTopComponent(stickthisupyourbum);
        flippingheck.setBottomComponent(whywontyoujustwork);

        // Set main frame visible
        anAbsoluteUnit.setLayout(new BorderLayout());
        anAbsoluteUnit.setVisible(true);
        anAbsoluteUnit.add(flippingheck);
        anAbsoluteUnit.addWindowListener(this);
        anAbsoluteUnit.pack();
        anAbsoluteUnit.setLocationRelativeTo(null);

        return anAbsoluteUnit;
    }
    
    private static int[] gridSize = { 10, 10 }; // {y, x}
    private static Computer ai = new Computer(gridSize);

    // Make the ship objects
    private static Ship[] ships = new Ship[5];
    private static String[] shipNames = { "Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer" };
    private static int[] shipLengths = { 5, 4, 3, 3, 2 };

    private static void createComputerGrid() {
        //Place the ship objects (Make sure the ships don't collide)
        for (int i = 0; i < 5; i++) {
            ships[i] = new Ship(shipNames[i], shipLengths[i], ai.generateRandom());
            while(!ai.checkShipPlacement(ships[i]))
                ships[i].setNewPosition(ai.generateRandom());
            ai.placeShip(ships[i]);
        }

        //"Debug"
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(ai.getGrid()[i]));
        }
        
    }

    public static void userGuess(int[] coordinates) {   //Check user's guess and act accordingly
        boolean hit = ai.checkGuess(coordinates);
        if (hit) {
            pleasefuckingwork.changeButtonColour(coordinates, Color.RED);

            new PlaySound().play("Explosion2.kylebigdumb");
            System.out.println("> Hit!");

            String removedShipname = ai.removeShip(coordinates);
            int indexOfShip = -1;   //doesn't work
            for (int i = 0; i < shipNames.length; i++) if (shipNames[i].equalsIgnoreCase(removedShipname)) indexOfShip = i;

            System.out.println(indexOfShip);
        } else if (!hit) {
            pleasefuckingwork.changeButtonColour(coordinates, Color.BLACK);
            System.out.println("> Miss!");
        } else {
            System.out.println("> Error determining hit or miss.");
            System.exit(128);
        }
    }

    //Deal with the window closing events and stuff (*mandatory!*)
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

//08/11/2018 17:07