package UI.Graphics;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import Blocks.Block;
import Blocks.Square;
import UI.Game.Grid;
import UI.Game.Location;

/**
 * A {@code GridPanel} is the graphical representation of a {@code Grid}.
 */
public class GridPanel extends JPanel implements KeyListener {
    private Grid grid;
    private Graphics g;
    private static final int SQUARESIZE = 20;

    /**
     * Creates a {@code GridPanel} to represent the passed {@code Grid} parameter.
     * 
     * @param passedGrid {@code Grid} for the {@code GridPanel} to represent
     */
    public GridPanel(Grid passedGrid) {
        grid = passedGrid;
        addKeyListener(this);
        // this.setBorder(BorderFactory.createLineBorder(Color.black));
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
    public void keyPressed(KeyEvent e) {
        KeyEventHandler.printEventInfo("Key Pressed", e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //KeyEventHandler.printEventInfo("Key Released", e);    //test only
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //KeyEventHandler.printEventInfo("Key Typed", e);   //test only
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