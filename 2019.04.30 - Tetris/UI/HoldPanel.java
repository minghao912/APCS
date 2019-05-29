package UI;

import Blocks.Square;
import Blocks.Block;
import Blocks.BlockHoldManager;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

public class HoldPanel extends JPanel {
    private BlockHoldManager<Block> holdManager;
    private static final int SQUARESIZE = GridPanel.SQUARESIZE;

    public HoldPanel(BlockHoldManager<Block> blockHoldManager) {
        holdManager = blockHoldManager;
    }

    private void paintPanel(Graphics g) {
        for (int i = 0; i < holdManager.currentHold(); i++) {
            Square[][] shape = holdManager.getMember(i).getShape();

            for (int r = 0; r < shape.length; r++) {
                for (int c = 0; c < shape[0].length; c++) {
                    if (shape[r][c] == null)
                        continue;
                    g.setColor(shape[r][c].getColor());
                    g.fillRect((c * SQUARESIZE) + (i * 100), r * SQUARESIZE, SQUARESIZE, SQUARESIZE);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintPanel(g);
    }
}