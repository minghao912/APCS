import Blocks.Block;
import Blocks.Square;
import Blocks.BlockManager;
import Blocks.SpawnBlock;
import Game.Grid;
import Game.Location;
import Game.BlockSpawner;
import UI.GridPanel;
import Exceptions.BlockOutOfBoundsException;
import Exceptions.IncorrectBlockDefinitionException;

import java.util.ArrayList;
import java.util.Timer;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    private static JFrame win;
    private static JPanel field;

    public static void main(String[] args) {
        try {
            doStuff();
        } catch (Throwable e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(win, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void doStuff() {
        Square[][] sample1Shape = {
            {new Square(Color.RED), new Square(Color.RED), new Square(Color.RED)},
            {new Square(Color.RED), null,                  null}
        };

        Square[][] sample2Shape = {
            {new Square(Color.BLUE), new Square(Color.BLUE)},
            {new Square(Color.BLUE), new Square(Color.BLUE)}
        };

        Square[][] sample3Shape = {
            {new Square(Color.PINK), new Square(Color.PINK)},
            {null,                   new Square(Color.PINK)},
            {null,                   new Square(Color.PINK)}
        };

        ArrayList<Block> blocksForBlockManager = new ArrayList<Block>();
        blocksForBlockManager.add(new Block(sample1Shape));
        blocksForBlockManager.add(new Block(sample2Shape));
        blocksForBlockManager.add(new Block(sample3Shape));
        BlockManager<Block> blockManager = new BlockManager<Block>(blocksForBlockManager);
        
        Grid game = new Grid(20, 10);
        startSpawning(game, blockManager);

        System.out.println(game);

        createAndShowGame(game);

        //Make blocks move
        for(;;) {
            game.regularStep();
            field.repaint();
            
            try {
                Thread.sleep(250);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

    }

    public static void startSpawning(Grid grid, BlockManager<Block> blockManager) {
        new Thread(new BlockSpawner(grid, blockManager)).run();
        grid.setSpawnBlock(new SpawnBlock(grid, blockManager));
    }

    public static void createAndShowGame(Grid gameGrid) {
        field = new GridPanel(gameGrid);

        win = new JFrame("Tetrisk");    //window setup
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setPreferredSize(field.getPreferredSize());
        win.setResizable(false);
        win.add(field);
        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}