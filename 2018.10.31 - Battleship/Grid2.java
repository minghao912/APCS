import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

/**
 * Represents the Grid of Buttons
 * <p>
 * Utilises {@code JPanel} and {@code ActionListener}
 */
public class Grid2 extends JPanel implements ActionListener {
    private int rows;
    private int columns;
    private JButton[][] buttons; // Create 2D array of buttons
    private int[] size = new int[2];  
    public JPanel pane = new JPanel();

    /**
     * <h3>Create User Grid</h3>
     * Given the number of rows and columns, this will create 
     * a grid of buttons size 90x90, each with its own 
     * {@code ActionListener}.
     * 
     * @param inputRows - an {@code int}, the number of rows
     * @param inputColumns - an {@code int}, the number of columns
     */
    public Grid2(int inputRows, int inputColumns) {
        rows = inputRows;
        columns = inputColumns;
        buttons = new JButton[rows][columns];
        size[0] = columns;  //x
        size[1] = rows;     //y
    }

    /**
     * <h3>Create the Visible Grid of Buttons</h3>
     * Using {@code JPanel}, this will create a visible grid of
     * buttons that can be used.
     * 
     * @return {@code JPanel} - the grid of buttons
     */
    public JPanel createGrid() {
        pane.setBackground(Color.WHITE);
        pane.setLayout(new GridLayout(rows, columns));

        //Create 100 buttons, all at a preferred size of 90x90
        int buttonCount = 0;    
        String buttonID;
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                buttonID = ++buttonCount + "";

                buttons[y][x] = new JButton();
                buttons[y][x].setPreferredSize(new Dimension(90, 90));
                buttons[y][x].setName(buttonID);
                buttons[y][x].addActionListener(this);
                buttons[y][x].setActionCommand(x + ", " + y);

                pane.add(buttons[y][x]);
            }
        }

        return pane;
    }

    public void actionPerformed(ActionEvent e) {
        //Get button coordinate
        String actionCoordinate = e.getActionCommand();
        String[] xy = actionCoordinate.split(", ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        if (buttons[y][x].getName().contains(" &")) return;
        else {
            ++Computer.moveCounter; //Increase user move count
            System.out.println();
            System.out.println("> User called a hit on (" + x + ", " + y + ")");
            System.out.println("> User move count: " + Computer.moveCounter);

            buttons[y][x].setName(buttons[y][x].getName() + " &");  //Mark button as already clicked
            InitGame.userGuess(new int[] {y, x});   //Pass the guess to the main game
        }
    }
    
    /**
     * Retreives the size of the grid
     * 
     * @return {@code int[]} - the size {y, x}
     */
    public int[] getGridSize() {
        return size;
    }

    /**
     * <h3>Changes Button Colour</h3>
     * Given the coordinates of a button and the desired colour,
     * this will enact those changes.
     * 
     * @param coordinates - an {@code int[]}, the coordinates
     *                      of the button
     * @param colour - the desired {@code Color}
     */
    public void changeButtonColour(int[] coordinates, Color colour) {
        buttons[coordinates[0]][coordinates[1]].setBackground(colour);
        buttons[coordinates[0]][coordinates[1]].setContentAreaFilled(false);
        buttons[coordinates[0]][coordinates[1]].setOpaque(true);
    }

    /**
     * Sets {@code Grid} to the 'Game End' state, disabling
     * all guessing/pressing of buttons.
     */
    public void gameEndGrid() {
        for (int y = 0; y < columns; y++) 
            for (int x = 0; x < rows; x++) 
                buttons[y][x].setName(buttons[y][x].getName() + " &");
    }    
}

// 18/11/2018 18:25