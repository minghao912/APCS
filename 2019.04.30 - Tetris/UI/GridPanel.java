package UI;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

import Blocks.Square;
import Game.Grid;
import Game.Location;

/**
 * A {@code GridPanel} is the graphical representation of a {@code Grid}.
 */
public class GridPanel extends JPanel {
    private Grid grid;
    public static final int SQUARESIZE = 20;

    /**
     * Creates a {@code GridPanel} to represent the passed {@code Grid} parameter.
     * 
     * @param passedGrid {@code Grid} for the {@code GridPanel} to represent
     */
    public GridPanel(Grid passedGrid) {
        grid = passedGrid;
        addKeyListener(new KeyEventHandler());   //Add KeyListener to the JPanel
    }

    /**
     * Draws the game {@code Grid} onto the given {@code Graphics} component.
     * 
     * @param g the {@code Graphics} component to be drawn on
     */
    private void drawGrid(Graphics g) {
        // Fill in gridArray
        Square[][] gridArray = new Square[grid.getSize()[0]][grid.getSize()[1]];
        for (int r = 0; r < gridArray.length; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                gridArray[r][c] = grid.getSquareAt(new Location(r, c));
            }
        }

        // Draw grid
        for (int r = 0; r < gridArray.length; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                if (gridArray[r][c] == null)
                    continue;

                g.setColor(gridArray[r][c].getColor());
                g.fillRect(c * SQUARESIZE, r * SQUARESIZE, SQUARESIZE, SQUARESIZE);
            }
        }
    }

    //Requests focus to the JPanel so the KeyListener can detect keystrokes
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGrid(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((grid.getSize()[1] * SQUARESIZE), (grid.getSize()[0] * SQUARESIZE) + 30);
    }
}