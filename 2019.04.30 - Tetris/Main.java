import Blocks.Block;
import Blocks.Square;
import Blocks.BlockManager;
import Game.Grid;
import Game.Location;
import Game.BlockSpawner;
import UI.GridPanel;
import UI.KeyEventHandler;
import Exceptions.BlockOutOfBoundsException;
import Exceptions.IncorrectBlockDefinitionException;

import java.util.ArrayList;
import java.util.Timer;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Main {
    private static JFrame win;
    private static JPanel field;

    public static void main(String[] args) {
        try {
            doStuff();
        } catch (Throwable e) {
            String errorMessage = e + "\n";
            for (StackTraceElement traceE : e.getStackTrace()) {
                errorMessage += traceE + "\n";
            }
            JTextArea ta = new JTextArea(errorMessage);
            JScrollPane sp = new JScrollPane(ta);
            ta.setLineWrap(true);
            ta.setWrapStyleWord(true);
            sp.setPreferredSize(new Dimension(400, 100));

            JOptionPane.showMessageDialog(win, sp, "Error", JOptionPane.ERROR_MESSAGE);
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

        Square[][] sample4Shape = {
            {null,                    new Square(Color.BLACK), null},
            {new Square(Color.BLACK), new Square(Color.BLACK), new Square(Color.BLACK)}
        };

        ArrayList<Block> blocksForBlockManager = new ArrayList<Block>();
        blocksForBlockManager.add(new Block(sample1Shape));
        blocksForBlockManager.add(new Block(sample2Shape));
        blocksForBlockManager.add(new Block(sample3Shape));
        blocksForBlockManager.add(new Block(sample4Shape));
        BlockManager<Block> blockManager = new BlockManager<Block>(blocksForBlockManager);
        
        Grid game = new Grid(20, 10);
        startSpawning(game, blockManager);

        KeyEventHandler.setGrid(game);

        System.out.println(game);

        createAndShowGame(game);

        //Make blocks move
        for(;;) {
            game.regularStep();
            field.repaint();
            
            try {
                Thread.sleep(200);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

    }

    public static void startSpawning(Grid grid, BlockManager<Block> blockManager) {
        //new Thread(new BlockSpawner(grid, blockManager)).run();
        BlockSpawner s = new BlockSpawner(grid, blockManager);
        //grid.setManager(blockManager);
        grid.setSpawner(s);
        s.run();
    }

    public static void createAndShowGame(Grid gameGrid) {
        field = new GridPanel(gameGrid);

        win = new JFrame("Tetris");    //window setup
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setPreferredSize(field.getPreferredSize());
        win.setResizable(false);
        win.add(field);
        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}