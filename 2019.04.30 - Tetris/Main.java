import java.awt.*;
import javax.swing.*;

import Blocks.*;
import UI.Game.*;
import UI.Graphics.*;
import Exceptions.*;

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
        Square[][] sample1Block = {
            {new Square(Color.RED), new Square(Color.RED), new Square(Color.RED)},
            {new Square(Color.RED), null,                  null}
        };

        Block sample1 = new Block(sample1Block);
        //System.out.println(sample1);

        Square[][] sample2Block = {
            {new Square(Color.BLUE), new Square(Color.BLUE)},
            {new Square(Color.BLUE), new Square(Color.BLUE)}
        };

        Block sample2 = new Block(sample2Block);
        //System.out.println(sample2);

        Square[][] sample3Block = {
            {new Square(Color.PINK), new Square(Color.PINK)},
            {null,                   new Square(Color.PINK)},
            {null,                   new Square(Color.PINK)}
        };

        Block sample3 = new Block(sample3Block);
        
        Grid game = new Grid(20, 10);

        game.addBlock(sample1, new Location(0, 7));
        game.addBlock(sample2, new Location(3, 0));
        game.addBlock(sample3, new Location(0, 1));

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