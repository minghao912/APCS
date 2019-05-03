package UI;

import java.awt.*;
import javax.swing.*;
import Blocks.*;
import UI.*;

public class GridPanel extends JPanel {
    private Grid grid;
    private Graphics g;
    private static final int SQUARESIZE = 20;

    public GridPanel(Grid passedGrid) {
        grid = passedGrid;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Draws the game {@code Grid} onto the given {@code Graphics} component.
     * @param g the {@code Graphics} component to be drawn on
     */
    private void drawGrid(Graphics g) {
        g.drawString("yeet", 10, 20);

        //Fill in gridArray
        Square[][] gridArray = new Square[grid.getSize()[0]][grid.getSize()[1]];
        for (int r = 0; r < gridArray.length; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                gridArray[r][c] = grid.getSquareAt(new Location(r, c));
            }
        }

        //Draw grid
        for (int r = 0; r < gridArray.length; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                if (gridArray[r][c] == null) continue;

                g.setColor(gridArray[r][c].getColor());
                g.fillRect(c * SQUARESIZE, r * SQUARESIZE, SQUARESIZE, SQUARESIZE);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawGrid(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(grid.getSize()[0] * 20, grid.getSize()[1] * 20);
    }
}