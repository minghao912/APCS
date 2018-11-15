import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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
    private static Grid2 pleaseheckingwork = new Grid2(10, 10);
    private static JFrame anAbsoluteUnit = new JFrame("Batttleship");
    
    //Stat counters
    private static JLabel movesCounter = new JLabel("<html><div style='text-align: center;'>Moves<br>0</div></html>", SwingConstants.LEFT);
    private static JLabel shipsSunkCnt = new JLabel("<html><div style='text-align: center;'>Ships Sunk<br>0</div></html>", SwingConstants.CENTER);
    private static JLabel shipsLeftCnt = new JLabel("<html><div style='text-align: center;'>Ships Left<br>5</div></html>", SwingConstants.RIGHT);
    
    private JFrame createPlayfield() {
        anAbsoluteUnit.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        anAbsoluteUnit.setTitle("Battlehsip");
        anAbsoluteUnit.setIconImage((new ImageIcon(this.getClass().getResource("Files/icon.kylebigdumb"))).getImage());

        JSplitPane flippingheck = new JSplitPane();

        // Stats
        JPanel stickthisupyourbum = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 5));
        stickthisupyourbum.add(movesCounter);
        stickthisupyourbum.add(shipsLeftCnt);
        stickthisupyourbum.add(shipsSunkCnt);

        // Battlehsip grid
        JPanel whywontyoujustwork = pleaseheckingwork.createGrid();

        // Configure the split pane
        flippingheck.setOrientation(JSplitPane.VERTICAL_SPLIT);
        flippingheck.setDividerLocation(50);
        flippingheck.setTopComponent(stickthisupyourbum);
        flippingheck.setBottomComponent(whywontyoujustwork);

        // Set main frame visible
        anAbsoluteUnit.setLayout(new BorderLayout());   //For Windows, I think
        anAbsoluteUnit.add(flippingheck);
        anAbsoluteUnit.addWindowListener(this);
        anAbsoluteUnit.pack();
        anAbsoluteUnit.setVisible(true);
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
        movesCounter.setText("<html><div style='text-align: center;'>Moves<br>" + Computer.moveCounter + "</div></html>"); //Update moves counter
        if (hit) {
            pleaseheckingwork.changeButtonColour(coordinates, Color.RED);

            new PlaySound().play("Explosion2.kylebigdumb");
            System.out.println("> Hit!");

            String removedShipname = ai.removeShip(coordinates);
            int indexOfShip = -1;
            for (int i = 0; i < shipNames.length; i++) 
                if (shipNames[i].equalsIgnoreCase(removedShipname)) 
                    indexOfShip = i;

            System.out.println("> " + removedShipname + ", " + indexOfShip);   

            if (indexOfShip == -1) {
                System.out.println("> Error: Cannot determine type of ship.");
                Error.displayError("Fatal Error", "Cannot determine type of ship.");
                System.exit(128);   
            } else {
                ArrayList<Integer[]> shipCoord = ships[indexOfShip].getCoordinate();

                System.out.println();
                for (int i = 0; i < shipCoord.size(); i++)
                    System.out.println(Arrays.toString(shipCoord.get(i)));
                System.out.println();

                System.out.println("> Hit: " + Arrays.toString(coordinates));
                
                Integer[] bigI = Arrays.stream(coordinates).boxed().toArray(Integer[]::new);
                ships[indexOfShip].removeCoordinate(bigI);
                if (ai.checkSunk(ships[indexOfShip])) {
                    int shipsSunk = ++Computer.sunkCounter;
                    shipsSunkCnt.setText("<html><div style='text-align: center;'>Ships Sunk<br>" + shipsSunk + "</div></html>");
                    shipsLeftCnt.setText("<html><div style='text-align: center;'>Ships Left<br>" + (5 - shipsSunk) + "</div></html>");
                    System.out.println("> Ship Sunk");

                    if (shipsSunk >= ships.length) {
                        winner();
                    }
                }
            }
        } else if (!hit) {
            pleaseheckingwork.changeButtonColour(coordinates, Color.BLUE);
            System.out.println("> Miss!");
        } else {
            System.out.println("> Error determining hit or miss.");
            Error.displayError("Fatal Error", "Cannot determine hit or miss.");
            System.exit(128);
        }
    }

    public static void winner() {
        JOptionPane.showMessageDialog(anAbsoluteUnit, "You've won!\nYour score: " + Computer.moveCounter);
        String username = JOptionPane.showInputDialog(anAbsoluteUnit, "Please enter your name:");

        List<String> highscores = FileReadWrite.read("Files/highscores.kylebigdumb");
        List<String> usernamess = FileReadWrite.read("Files/highusernames.kylebigdumb");

        if (highscores == null || usernamess == null) Error.displayError("Fatal Error", "An unknown error has occured: null returned by FileReadWrite");
        else {
            //"Debug" the user info
            System.out.println("> Leaderboard Info:");
            System.out.println("> " + Arrays.toString(highscores.toArray()));
            System.out.println("> " + Arrays.toString(usernamess.toArray()));
        }
    }

    //Deal with the window closing events and stuff (*mandatory!*)
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        int close = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (close == 0) {
            anAbsoluteUnit.dispose();
            System.exit(0);
        } else return;
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

//14/11/2018 16:58