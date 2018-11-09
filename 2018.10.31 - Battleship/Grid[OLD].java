import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class Grid extends JFrame implements ActionListener {
    private int rows;
    private int columns;
    private JButton[][] buttons; // Create 2D array of buttons
    private int[] size = new int[2];  
    public Container pane = getContentPane();

    public Grid(int inputRows, int inputColumns) {
        rows = inputRows;
        columns = inputColumns;
        buttons = new JButton[rows][columns];
        size[0] = columns;  //x
        size[1] = rows;     //y
    }
    
    void setFrameTitle(String title) {
        this.setTitle(title);
    }

    void createGrid() {
        pane.setBackground(Color.WHITE);
        pane.setLayout(new GridLayout(rows, columns));

        //Create 100 buttons, all at a preferred size of 40x40
        int buttonCount = 0;    
        String buttonID;
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                buttonID = ++buttonCount + "";

                buttons[y][x] = new JButton();
                buttons[y][x].setPreferredSize(new Dimension(100, 100));
                buttons[y][x].setName(buttonID);
                buttons[y][x].addActionListener(this);
                buttons[y][x].setActionCommand(x + ", " + y);
                pane.add(buttons[y][x]);
            }
        }
    }

    int[] getGridSize() {
        return size;
    }

    public void actionPerformed(ActionEvent e) {
        //Get button coordinate
        String actionCoordinate = e.getActionCommand();
        String[] xy = actionCoordinate.split(", ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        if (buttons[y][x].getName().contains(" &")) {}
        else {
            //Actions
            buttons[y][x].setBackground(Color.red);
            buttons[y][x].setName(buttons[y][x].getName() + " &");
            new PlaySound().play("Files/Sounds/Explosion2.wav");
            System.out.println("User called a hit on (" + x + ", " + y + ")");
        }
    }
}