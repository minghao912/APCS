package UI;

import Blocks.Block;
import Blocks.Square;

import java.awt.Graphics;
import javax.swing.JComponent;

public class HeldBlock extends JComponent {
    private Block block;
    private static final int SQUARESIZE = GridPanel.SQUARESIZE;

    public HeldBlock(Block block) {
        this.block = block;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Square[][] shape = block.getShape();

        for (int r = 0; r < shape.length; r++) {
            for (int c = 0; c < shape[0].length; c++) {
                g.setColor(shape[r][c].getColor());
                g.fillRect(c * SQUARESIZE, r * SQUARESIZE, SQUARESIZE, SQUARESIZE);
            }
        }
    }
}

//https://stackoverflow.com/questions/23479666/creating-a-simple-custom-jcomponent-in-java