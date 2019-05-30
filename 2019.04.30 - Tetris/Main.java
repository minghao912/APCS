import Blocks.Block;
import Blocks.Square;
import Blocks.BlockManager;
import Game.Grid;
import Game.GameRunner;
import Game.BlockSpawner;
import Game.Counter;
import Game.Lock;
import UI.GridPanel;
import UI.HoldPanel;
import UI.CounterFrame;
import UI.KeyEventHandler;
import Exceptions.ExceptionHandler;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main {
    private static JFrame win;
    private static JPanel field;
    private static HoldPanel hpanel;
    private static Grid game;
    private static BlockManager<Block> blockManager;

    public static void main(String[] args) {
        try {
            createBlocks();
            doStuff();
        } catch (Throwable e) {
            ExceptionHandler.showError(e);
        }
    }

    public static void doStuff() {
        Counter.maxHoldCount = 2;
        Lock lock = new Lock();
        game = new Grid(20, 10, lock);
        startSpawning(game, blockManager);

        System.out.println(game);

        createAndShowGame(game);

        //Make blocks move ☎1
        GameRunner runner = new GameRunner(game, field);
        ScheduledExecutorService runService = Executors.newSingleThreadScheduledExecutor();
        Counter.timeInterval = 250;
        runService.scheduleAtFixedRate(runner, 300, Counter.timeInterval, TimeUnit.MILLISECONDS);
    
        KeyEventHandler.setHandlerInfo(game, field, runner, lock);
    }

    public static void createBlocks() {
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
            {new Square(Color.PINK), null},
            {new Square(Color.PINK), null}
        };

        Square[][] sample4Shape = {
            {null,                   new Square(Color.GRAY), null},
            {new Square(Color.GRAY), new Square(Color.GRAY), new Square(Color.GRAY)}
        };

        Square[][] sample5Shape = {
            {new Square(Color.GREEN)},
            {new Square(Color.GREEN)},
            {new Square(Color.GREEN)},
            {new Square(Color.GREEN)}
        };

        Square[][] sample6Shape = {
            {new Square(Color.ORANGE), null},
            {new Square(Color.ORANGE), new Square(Color.ORANGE)},
            {null                    , new Square(Color.ORANGE)}
        };

        ArrayList<Block> blocksForBlockManager = new ArrayList<Block>();
        blocksForBlockManager.add(new Block(sample1Shape));
        blocksForBlockManager.add(new Block(sample2Shape));
        blocksForBlockManager.add(new Block(sample3Shape));
        blocksForBlockManager.add(new Block(sample4Shape));
        blocksForBlockManager.add(new Block(sample5Shape));
        blocksForBlockManager.add(new Block(sample6Shape));
        blockManager = new BlockManager<Block>(blocksForBlockManager);
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

        hpanel = new HoldPanel(game.getHoldManager());
        JFrame hFrame = new JFrame("Hold");
        hFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        hFrame.setPreferredSize(new Dimension(200, 150));
        hFrame.setResizable(false);
        hFrame.add(hpanel, BorderLayout.CENTER);
        hFrame.pack();
        //hFrame.setLocationRelativeTo(win);
        hFrame.setLocation(win.getX() + win.getWidth(), win.getY());
        hFrame.setVisible(true);
        game.setHoldPanel(hpanel);

        System.out.println("> Setting up CounterFrame");
        CounterFrame cf = new CounterFrame("Stats", game);
        cf.setSize(new Dimension(win.getWidth(), 75));
        cf.pack();
        cf.setLocation(win.getX(), win.getY() - 75);
        cf.setVisible(true);
        
        ScheduledExecutorService runService = Executors.newSingleThreadScheduledExecutor();
        runService.scheduleAtFixedRate(cf, 0, 1, TimeUnit.SECONDS);

        win.toFront();
        win.setState(Frame.NORMAL);
    }
}