import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grid extends JFrame {
    int rows = 10;
    int columns = 10;

    public Grid(int inputRows, int inputColumns) {
        rows = inputRows;
        columns = inputColumns;
    }

    void createGrid() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows, columns));
        for (int i = 0; i < rows * columns; i++) {
            JButton button = new JButton((i + 1) + "");
            pane.add(button);
        }
    }
}