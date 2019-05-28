package UI;

import Blocks.Block;
import Blocks.BlockHoldManager;

import java.util.ArrayList;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class HoldPanel extends JPanel {
    private BlockHoldManager<Block> holdManager;
    private static final int SQUARESIZE = GridPanel.SQUARESIZE;

    public HoldPanel(BlockHoldManager<Block> blockHoldManager) {
        holdManager = blockHoldManager;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void paintPanel(Graphics g) {
        ArrayList<HeldBlock> hold = new ArrayList<HeldBlock>(holdManager.getMaxHold());
        for (int i = 0; i < holdManager.getMaxHold(); i++) {
            hold.add(new HeldBlock(holdManager.getMember(i)));
        }

        hold.forEach(hb -> {
            this.add(hb);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintPanel(g);
    }
}