import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class Grid2 extends JPanel implements ActionListener {
    private int rows;
    private int columns;
    private JButton[][] buttons; // Create 2D array of buttons
    private int[] size = new int[2];  
    public JPanel pane = new JPanel();

    public Grid2(int inputRows, int inputColumns) {
        rows = inputRows;
        columns = inputColumns;
        buttons = new JButton[rows][columns];
        size[0] = columns;  //x
        size[1] = rows;     //y
    }

    JPanel createGrid() {
        pane.setBackground(Color.WHITE);
        pane.setLayout(new GridLayout(rows, columns));

        //Create 100 buttons, all at a preferred size of 40x40
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
            buttons[y][x].setName(buttons[y][x].getName() + " &");  //Mark button as already clicked
            InitGame.userGuess(new int[] {y, x});   //Pass the guess to the main game

            System.out.println();
            System.out.println("> User called a hit on (" + x + ", " + y + ")");
            System.out.println("> User move count: " + Computer.moveCounter);
        }
    }
    
    int[] getGridSize() {
        return size;
    }

    void changeButtonColour(int[] coordinates, Color colour) {
        buttons[coordinates[0]][coordinates[1]].setBackground(colour);
        buttons[coordinates[0]][coordinates[1]].setContentAreaFilled(false);
        buttons[coordinates[0]][coordinates[1]].setOpaque(true);
    }

    
}

// 14/11/2018 16:58