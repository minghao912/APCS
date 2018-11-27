import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Starts the game and produces on-screen GUI.
 */
public class InitGame implements WindowListener {
    /**
     * <h3>Main</h3>
     * Sets the look and feel and initialises the game.
     */
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

        startGame();
    }

    //Battleship grid
    private static Grid2 pleaseheckingwork = new Grid2(10, 10);
    private static JFrame anAbsoluteUnit = new JFrame("Batttleship");
    
    // Acquire user settings
    public static int cheats = JOptionPane.showConfirmDialog(null, "Enable Cheats?", "Are you a wussy?", JOptionPane.YES_NO_OPTION);
    private static int sounds = JOptionPane.showConfirmDialog(null, "Enable Sound?", "Want to blow your eardrums?", JOptionPane.YES_NO_OPTION);
    
    //Stat counters
    private static JLabel movesCounter = new JLabel("<html><div style='text-align: center;'>Moves<br>0</div></html>", SwingConstants.LEFT);
    private static JLabel shipsSunkCnt = new JLabel("<html><div style='text-align: center;'>Ships Sunk<br>0</div></html>", SwingConstants.CENTER);
    private static JLabel shipsLeftCnt = new JLabel("<html><div style='text-align: center;'>Ships Left<br>5</div></html>", SwingConstants.RIGHT);
    
    /**
     * Starts Game
     */
    private static void startGame() {
        // yeet
        if (sounds == 0)
            System.out.println("> Sound on.");
        if (sounds == 1)
            System.out.println("> Sound off.");
        if (cheats == 0)
            System.out.println("> We've got a chicken playing this game.");
        if (cheats == 1)
            System.out.println("> Big baller here.");

        // Create new playfield and tell the computer to make the ship grid
        JFrame playfield = new InitGame().createPlayfield();
        createComputerGrid();
    }

    /**
     * <h3>Creates the User's Playfield</h3>
     * This sets up a {@code JSplitFrame} to deal with the grid and
     * the stats panel at the top of the screen. Then, it sets the 
     * entire {@code JFrame} visible.
     * 
     * @return The main {@code JFrame} that is displayed
     */
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

    /**
     * <h3>Creates the Computer's Grid</h3>
     * Places 5 ships with random starting coordinates and directions, and ensures no collisions.
     */
    private static void createComputerGrid() {
        //Place the ship objects (Make sure the ships don't collide)
        for (int i = 0; i < 5; i++) {
            ships[i] = new Ship(shipNames[i], shipLengths[i], ai.generateRandom());
            while(!ai.checkShipPlacement(ships[i]))
                ships[i].setNewPosition(ai.generateRandom());
            ai.placeShip(ships[i]);
        }

        //"Debug"
        if (cheats == 0) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Arrays.toString(ai.getGrid()[i]));
            }
        }
    }

    /** 
     * <h3>Deals with a user's guess. Determines hit/miss, changes button colours, etc.</h3>
     * 
     * @param coordinates - an {@code int[]} Coordinates of the User's Guess
     **/
    public static void userGuess(int[] coordinates) {   //Check user's guess and act accordingly
        boolean hit = ai.checkGuess(coordinates);
        movesCounter.setText("<html><div style='text-align: center;'>Moves<br>" + Computer.moveCounter + "</div></html>"); //Update moves counter
        
        if (sounds == 0) new PlaySound().play("Explosion2.kylebigdumb", -40.0f);
        
        if (hit) {
            pleaseheckingwork.changeButtonColour(coordinates, Color.RED);

            System.out.println("> Hit!");
            if (sounds == 0) new PlaySound().play("hit.kylebigdumb", -10.0f);

            String removedShipname = ai.removeShip(coordinates);
            int indexOfShip = -1;
            for (int i = 0; i < shipNames.length; i++) 
                if (shipNames[i].equalsIgnoreCase(removedShipname)) 
                    indexOfShip = i;

            System.out.println("> " + removedShipname + ", " + indexOfShip);   

            if (indexOfShip == -1) {
                System.out.println("> Error: Cannot determine type of ship.");
                Error.displayError("Fatal Error", "Cannot determine type of ship."); 
            } else {
                ArrayList<Integer[]> shipCoord = ships[indexOfShip].getCoordinate();

                if (cheats == 0) {  //Cheats Enabled
                    System.out.println();   //Debug stuff
                    for (int i = 0; i < shipCoord.size(); i++)
                        System.out.println(Arrays.toString(shipCoord.get(i)));
                    System.out.println();
                    System.out.println("> Hit: " + Arrays.toString(coordinates));
                }
                
                ships[indexOfShip].removeCoordinate(new Integer[] {coordinates[0], coordinates[1]});
                if (ai.checkSunk(ships[indexOfShip])) { //This changes the stats at the top if a ship is sunk
                    int shipsSunk = ++Computer.sunkCounter; 
                    shipsSunkCnt.setText("<html><div style='text-align: center;'>Ships Sunk<br>" + shipsSunk + "</div></html>");
                    shipsLeftCnt.setText("<html><div style='text-align: center;'>Ships Left<br>" + (5 - shipsSunk) + "</div></html>");
                    
                    if (sounds == 0) new PlaySound().play("shipsunk.kylebigdumb", -10.0f);
                    
                    System.out.println("> Ship Sunk");

                    if (shipsSunk >= ships.length) {    //If all ships are sunk
                        new InitGame().winner();
                    }
                }
            }
        } else if (!hit) {
            if (sounds == 0) new PlaySound().play("miss.kylebigdumb", -10.0f);
            
            pleaseheckingwork.changeButtonColour(coordinates, Color.BLUE);
            System.out.println("> Miss!");
        } else {
            System.out.println("> Error determining hit or miss.");
            Error.displayError("Fatal Error", "Cannot determine hit or miss.");
            System.exit(128);
        }
    }

    /**
     * <h3>Executes Code After Winning A Game</h3>
     * Calculates and displays the user's score and asks for a name
     * to be put on the leaderboard. It will then read/write from
     * the leaderboard file and display the leaderboard on screen.
     */
    public void winner() {
        pleaseheckingwork.gameEndGrid();    //No more moves

        //Start the leaderboard/scoring stuff
        JOptionPane.showMessageDialog(anAbsoluteUnit, "You've won!\nYour score: " + Computer.moveCounter, "Winner!", 
                JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("Files/trophy3.kylebigdumb")));
        String username = JOptionPane.showInputDialog(anAbsoluteUnit, "Please enter your name:");

        List<String> leaderboard = new FileReadWrite().read("Files/leaderboard.kylebigdumb");

        if (leaderboard == null) {
            Error.displayError("Fatal Error", "An unknown error has occured: null returned by FileReadWrite");
            return;
        }

        leaderboard.add(Computer.moveCounter + ": " + username);

        String[] sortedLeaderboard = leaderboard.toArray(new String[0]);
        Arrays.sort(sortedLeaderboard);

        new FileReadWrite().write("Files/leaderboard.kylebigdumb", sortedLeaderboard);

        new InitGame().showLeaderboard(sortedLeaderboard);

        //"Debug" the leaderboard info
        System.out.println("> New Leaderboard Info:");
        System.out.println("> " + Arrays.toString(sortedLeaderboard));
    }

    /**
     * <h3>Show Leaderboard</h3>
     * Given a {@code String[]} of elements, it will display each element
     * in its own {@code JLabel} row.
     * 
     * @param elements - a {@code String[]} of elements to display
     */
    public void showLeaderboard(String[] elements) {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            JLabel elementLabel;

            if (i >= 10) break;  //Only display the top 10 on the leaderboard
            else if (i == 0) elementLabel = new JLabel("<html><h1>" + element + "</h1></html>", SwingConstants.CENTER);
            else {
                elementLabel = new JLabel("<html><h3>" + element + "</h3></html>", SwingConstants.CENTER);
            }

            elementLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            box.add(Box.createRigidArea(new Dimension(0, 5)));
            box.add(elementLabel);
        }
        box.add(Box.createVerticalGlue());

        JFrame leaderboardInternalFrame = new JFrame("Leaderboard");
        leaderboardInternalFrame.getContentPane().add(box);
        leaderboardInternalFrame.addWindowListener(this);
        leaderboardInternalFrame.setPreferredSize(new Dimension(680, 480));
        leaderboardInternalFrame.pack();
        leaderboardInternalFrame.setLocationRelativeTo(null);
        leaderboardInternalFrame.setVisible(true);
    }

    //Deal with the window closing events and stuff (*mandatory!*)
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        String[] options = {"Quit", "Restart", "Cancel"};
        int close = JOptionPane.showOptionDialog(null, "Are you sure you want to quit?", "Quit Options", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
        switch (close) {
            case (0): 
                System.out.println("> Quit via user termination.");
                System.exit(0);
                break;
            case (1):
                JOptionPane.showMessageDialog(null, "Just quit and restart lmao");
                break;
            case (2): break;
        }
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

//20/11/2018 13:03