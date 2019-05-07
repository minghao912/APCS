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

import Blocks.*;
import UI.Graphics.*;
import UI.Game.*;

/**
 * A {@code GridPanel} is the graphical representation of a {@code Grid}.
 */
public class GridPanel extends JPanel implements MouseListener, KeyListener {
    private Grid grid;
    private Graphics g;
    private static final int SQUARESIZE = 20;

    /**
     * Creates a {@code GridPanel} to represent the passed {@code Grid} parameter.
     * 
     * @param passedGrid
     */
    public GridPanel(Grid passedGrid) {
        grid = passedGrid;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        JOptionPane.showMessageDialog(null, keyCode + "pressed.", "Key Press Detected",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        JOptionPane.showMessageDialog(null, keyCode + "typed.", "Key Press Detected",
                JOptionPane.INFORMATION_MESSAGE);
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